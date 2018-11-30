package Classe;

import Contrat.ContratClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe Compéttion
 */
public class Competition implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * Id la compétition
     */
    private int id;

    /**
     * Titre de la compéttition
     */
    private String title;

    /**
     * Type de sport
     */
    private String type;

    /**
     * Equipe à domiciles
     */
    private Team team1;

    /**
     * Equipe à l'extérieur
     */
    private Team team2;

    /**
     * Liste d'utilisateur qui suivent la compéttion
     */
    private HashMap<ContratClient, String> viewers = new HashMap<>();

    /**
     * Liste d'évènement concernant la compétition
     */
    private ArrayList<Event> events = new ArrayList<>();

    /**
     * Liste de votes
     */
    private ArrayList<String> votes = new ArrayList<>();

    /**
     * Liste de paris
     */
    private HashMap<String, String> paris = new HashMap<>();

    /**
     * Savoir si un admin commente déjà la compétition
     */
    private boolean hasAdmin = false;

    /**
     * Savoir si la compétition est terminé
     */
    private boolean finish = false;

    /**
     * Constructeur
     *
     * @param id    id
     * @param title titre
     * @param t     type
     * @param t1    équipe à domicile
     * @param t2    équipe à l'extérieur
     */
    public Competition(int id, String title, String t, Team t1, Team t2) {
        this.id = id;
        this.title = title;
        this.type = t;
        this.team1 = t1;
        this.team2 = t2;
    }

    /**
     * Retourne l'id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le titre
     *
     * @return titre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retourne le type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne l'équipe à domicile
     *
     * @return équipe à domicile
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * Retourne l'équipe extérieur
     *
     * @return équipe extérieur
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Ajout d'un évènement
     *
     * @param event évènement à ajouter
     */
    public void addEvent(Event event) {
        this.events.add(event);
    }

    /**
     * Retourne les évènements
     *
     * @return liste d'évènement
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * @return
     */
    public boolean isHasAdmin() {
        return hasAdmin;
    }

    /**
     * Vérifier si la compétition est déjà géré par un admin
     */
    public void hasAdmin() {
        this.hasAdmin = true;
    }

    /**
     * Vérifier qu'une compétition est terminée ou non
     *
     * @return boolean
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * Terminer la compétition
     */
    public void finish() {
        this.finish = true;
    }

    /**
     * Permet de savoir que l'utilisateur à déjà voté dans cette compétition
     *
     * @param user identifiant du user
     */
    public void addVote(String user) {
        this.votes.add(user);
    }

    /**
     * Vérifie si l'utilisateur à déjà voté
     *
     * @param name identifiant du user
     * @return boolean
     */
    public boolean hasVote(String name) {
        for (String s : this.votes) {
            if (Objects.equals(name, s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne la liste des joueurs élu homme du match
     *
     * @return liste de joueur
     */
    public ArrayList<Player> winnersVotes() {

        int team1 = 0;
        int team2 = 0;
        ArrayList<Player> winners = new ArrayList<>();

        if (this.getTeam1().bestPlayers().size() > 0) {
            team1 = this.getTeam1().bestPlayers().get(0).getVoteUser().size();
        }
        if (this.getTeam2().bestPlayers().size() > 0) {
            team2 = this.getTeam2().bestPlayers().get(0).getVoteUser().size();
        }

        if (team1 > team2) {
            winners.addAll(this.getTeam1().bestPlayers());
        } else if (team1 < team2) {
            winners.addAll(this.getTeam2().bestPlayers());
        } else {
            ArrayList<Player> tmp = new ArrayList<>();
            tmp.addAll(this.getTeam1().bestPlayers());
            tmp.addAll(this.getTeam2().bestPlayers());

            winners.addAll(tmp);
        }

        return winners;
    }

    /**
     * Vérifie si l'utilisateur à déjà voté
     *
     * @param name identifiant du user
     * @return boolean
     */
    public boolean hasParis(String name) {
        for (Map.Entry<String, String> map : this.paris.entrySet()) {
            if (Objects.equals(map.getKey(), name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ajout d'un paris
     *
     * @param userName identifiant du user
     * @param pari     pari à ajouter
     */
    public void addParis(String userName, String pari) {
        this.paris.put(userName, pari);
    }

    /**
     * Mise à jour d'un paris
     *
     * @param userName identifiant du user
     * @param pari     pari à ajouter
     */
    public void updateParis(String userName, String pari) {
        for (Map.Entry<String, String> map : this.paris.entrySet()) {
            if (Objects.equals(map.getKey(), userName)) {
                map.setValue(pari);
            }
        }
    }

    /**
     * Retourne les client qui on gagné et perdu leur paris
     *
     * @return hasMap
     */
    public HashMap<ContratClient, Boolean> winnersParis() {
        HashMap<ContratClient, Boolean> clients = new HashMap<>();

        if (this.finish) {
            if (this.getTeam1().getScore() > this.getTeam2().getScore()) {
                for (Map.Entry<String, String> map : this.paris.entrySet()) {
                    if (Objects.equals(map.getValue(), "1")) {
                        for (Map.Entry<ContratClient, String> cli : this.viewers.entrySet()) {
                            if (Objects.equals(cli.getValue(), map.getKey())) {
                                clients.put(cli.getKey(), true);
                            } else {
                                clients.put(cli.getKey(), false);
                            }
                        }
                    }
                }
            } else if (this.getTeam1().getScore() < this.getTeam2().getScore()) {
                for (Map.Entry<String, String> map : this.paris.entrySet()) {
                    if (Objects.equals(map.getValue(), "2")) {
                        for (Map.Entry<ContratClient, String> cli : this.viewers.entrySet()) {
                            if (Objects.equals(cli.getValue(), map.getKey())) {
                                clients.put(cli.getKey(), true);
                            } else {
                                clients.put(cli.getKey(), false);
                            }
                        }
                    }
                }
            } else {
                for (Map.Entry<String, String> map : this.paris.entrySet()) {
                    if (Objects.equals(map.getValue(), "N")) {
                        for (Map.Entry<ContratClient, String> cli : this.viewers.entrySet()) {
                            if (Objects.equals(cli.getValue(), map.getKey())) {
                                clients.put(cli.getKey(), true);
                            } else {
                                clients.put(cli.getKey(), false);
                            }
                        }
                    }
                }
            }
        }
        return clients;
    }

    /**
     * Retourne les viewers
     *
     * @return hasMap
     */
    public HashMap<ContratClient, String> getViewers() {
        return viewers;
    }

    /**
     * Ajout d'un viewer
     *
     * @param v  client à ajouter
     * @param id identifiant du user
     */
    public void addViewers(ContratClient v, String id) {
        this.viewers.put(v, id);
    }

    /**
     * Suppression d'un viewer
     *
     * @param v client à supprimer
     */
    public void removeViewers(ContratClient v) {
        this.viewers.remove(v);
    }
}
