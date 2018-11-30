package Contrat;

import Classe.Competition;
import Classe.Event;
import Classe.Player;
import Classe.Scenario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * Classe ContratImpl
 */
public class ContratImpl extends UnicastRemoteObject implements Contrat {

    private static final long serialVersionUID = 1;
    private Map<String, String> connected = new HashMap<>();
    private ArrayList<Competition> competitions = new ArrayList<>();

    public ContratImpl() throws RemoteException {
        Scenario sc = new Scenario();
        this.competitions.add(sc.foot());
        this.competitions.add(sc.foot2());
    }

    @Override
    public String getId(String name) throws RemoteException {
        String id = null;
        if (!nameExist(name)) {
            id = UUID.randomUUID().toString();
            this.connected.put(id, name);
        }
        System.out.println("Number of customers on server = " + this.connected.size());
        return id;
    }

    @Override
    public void close(String id) throws RemoteException {
        this.connected.remove(id);
        System.out.println("Number of customers on server = " + this.connected.size());
    }

    @Override
    public ArrayList<Competition> getCompetitions() throws RemoteException {
        System.out.println("There is " + this.competitions.size() + " Competitions");
        return this.competitions;
    }

    @Override
    public Competition getCompById(int id) throws RemoteException {
        for (Competition c : this.competitions) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void addEvent(Event e, int id) throws RemoteException {
        Competition c = getCompById(id);
        if (c != null) {
            c.addEvent(e);
            for (ContratClient cli : c.getViewers()) {
                System.out.println(e);
                cli.msg(e.getText());
            }
        }

    }

    @Override
    public void addViewer(ContratClient cli, int id) throws RemoteException {
        System.out.println("Add viewer...");
        for (Competition c : this.competitions) {
            if (c.getId() == id) {
                c.addViewers(cli);
                if (c.getEvents().size() == 0) {
                    c.getViewers().get(c.getViewers().size() - 1).msg("La compétition n'est pas encore commencé...");
                } else {
                    int i = 0;
                    while (i < c.getEvents().size()) {
                        c.getViewers().get(c.getViewers().size() - 1).msg(c.getEvents().get(i).getText());
                        i++;
                    }
                }
            }
        }
    }

    @Override
    public void removeViewer(ContratClient cli, int id) throws RemoteException {
        System.out.println("Remove viewer...");
        for (Competition c : this.competitions) {
            if (c.getId() == id) {
                c.removeViewers(cli);
            }
        }
    }

    @Override
    public void vote(String userName, int compId, Player player) throws RemoteException {
        Competition c = getCompById(compId);

        if (!c.hasVote(userName)) {
            System.out.println("Add vote...");
            c.addVote(userName);
            addVote(userName, c, player);
        } else {
            System.out.println("Modify vote...");
            //Suppression de l'ancien vote
            removeVote(userName, c);
            //Ajout du nouveau vote
            addVote(userName, c, player);
        }
    }

    @Override
    public void paris(String userName, int compId, String pari) throws RemoteException {
        Competition c = getCompById(compId);

        if (!c.hasParis(userName)) {
            System.out.println("Add pari...");
            c.addParis(userName, pari);
        } else {
            System.out.println("Update pari...");
            c.updateParis(userName, pari);
        }
    }

    @Override
    public boolean addAdmin(int compId) throws RemoteException {
        Competition c = getCompById(compId);
        if (c.isHasAdmin()) {
            return false;
        } else {
            c.hasAdmin();
            return true;
        }
    }

    @Override
    public void goal(int compId, int teamId) throws RemoteException {
        Competition c = getCompById(compId);
        String event = "But pour ";
        if (c.getTeam1().getId() == teamId) {
            c.getTeam1().goal();
            event = event + c.getTeam1().getName();
        } else if (c.getTeam2().getId() == teamId) {
            c.getTeam2().goal();
            event = event + c.getTeam2().getName();
        }

        addEvent(new Event(event), c.getId());
    }

    @Override
    public void finish(int compId) throws RemoteException {
        Event event = new Event("Match terminé, merci de nous avoir suivi, à bientôt...");
        Competition c = getCompById(compId);
        c.finish();
        addEvent(event, c.getId());

        // Résultats vote
        String res;
        if (c.winnersParis().size() < 1) {
            res = "Aucuns vote sur cette compétition (aucun homme du match élu)";
        } else {
            res = "Le/les joueur(s) élu(s) meilleur(s) homme du match : ";
            for (Player p : c.winnersVotes()) {
                res += p.getSurname() + " " + p.getName();
            }
        }

        addEvent(new Event(res), compId);
    }

    private boolean nameExist(String name) {
        for (Map.Entry<String, String> entry : this.connected.entrySet()) {
            if (name.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    private void addVote(String userName, Competition c, Player player) throws RemoteException {
        boolean found = false;
        for (Player p : c.getTeam1().getPlayers()) {
            if (p.getId() == player.getId()) {
                p.addVote(userName);
                found = true;
            }
        }
        if (!found) {
            for (Player p : c.getTeam2().getPlayers()) {
                if (p.getId() == player.getId()) {
                    p.addVote(userName);
                }
            }
        }
    }

    private void removeVote(String userName, Competition c) throws RemoteException {
        boolean found = false;
        //Suppression du vote précédent
        for (Player p : c.getTeam1().getPlayers()) {
            for (String v : p.getVoteUser()) {
                if (Objects.equals(v, userName)) {
                    found = true;
                    p.removeVote(userName);
                }
            }
        }
        if (!found) {
            for (Player p : c.getTeam2().getPlayers()) {
                for (String v : p.getVoteUser()) {
                    if (Objects.equals(v, userName)) {
                        p.removeVote(userName);
                    }
                }
            }
        }

    }

}

