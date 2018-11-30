package Classe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Team
 */
public class Team implements Serializable {

    /**
     * Id de l'équipe
     */
    private int id;

    /**
     * Nom de l'équipe
     */
    private String name;

    /**
     * Effectif de l'équipe
     */
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * Score de l'équipe
     */
    private int score;

    /**
     * Constructeur
     *
     * @param id   id
     * @param name nom
     * @param p    effectif
     */
    public Team(int id, String name, ArrayList<Player> p) {
        this.id = id;
        this.name = name;
        this.players = p;
        this.score = 0;
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
     * Retourne le nom
     *
     * @return nom
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne l'effectif
     *
     * @return effectif
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Retourne son score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * L'équipe marque un but (incrémente le score)
     */
    public void goal() {
        this.score++;
    }

    /**
     * Retourne la liste des joueurs ayant le plus de votes
     *
     * @return liste de joueurs
     */
    public ArrayList<Player> bestPlayers() {
        ArrayList<Player> winners = new ArrayList<>();
        int res = 0;
        for (Player p : this.getPlayers()) {
            System.out.println("nb votes = " + p.getVoteUser().size());
            System.out.println("res" + res);
            if (p.getVoteUser().size() > res) {
                winners.add(p);
                res = p.getVoteUser().size();
            }
        }
        return winners;
    }

}
