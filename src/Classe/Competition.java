package Classe;

import Contrat.ContratClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Competition implements Serializable {
    private int id;
    private String title;
    private String type;
    private Team team1;
    private Team team2;
    private ArrayList<ContratClient> viewers = new ArrayList<>();
    private HashMap<ContratClient, String> views = new HashMap<>();
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<String> votes = new ArrayList<>();
    private HashMap<String, String> paris = new HashMap<>();
    private boolean hasAdmin = false;
    private boolean finish = false;


    public Competition(int id, String title, String t, Team t1, Team t2) {
        this.id = id;
        this.title = title;
        this.type = t;
        this.team1 = t1;
        this.team2 = t2;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void addViewers(ContratClient viewer) {
        this.viewers.add(viewer);
    }

    public void removeViewers(ContratClient viewer) {
        this.viewers.remove(viewer);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<ContratClient> getViewers() {
        return viewers;
    }

    public boolean isHasAdmin() {
        return hasAdmin;
    }

    public void hasAdmin() {
        this.hasAdmin = true;
    }

    public void hasNotAdmin() {
        this.hasAdmin = false;
    }

    public boolean isFinish() {
        return finish;
    }

    public void finish() {
        this.finish = true;
    }

    public ArrayList<String> getVotes() {
        return votes;
    }

    public void addVote(String user) {
        this.votes.add(user);
    }

    public boolean hasVote(String name) {
        for (String s : this.votes) {
            if (Objects.equals(name, s)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> winnersVotes() {

        int team1 = 0;
        int team2 = 0;
        ArrayList<String> winners = new ArrayList<>();

        if (this.getTeam1().bestPlayers().size() > 0) {
            team1 = this.getTeam1().bestPlayers().get(0).getVoteUser().size();
        }
        if (this.getTeam2().bestPlayers().size() > 0) {
            team2 = this.getTeam2().bestPlayers().get(0).getVoteUser().size();
        }

        if (team1 > team2) {
            for (Player p : this.getTeam1().bestPlayers()) {
                winners.addAll(p.getVoteUser());
            }
        } else if (team1 < team2) {
            for (Player p : this.getTeam2().bestPlayers()) {
                winners.addAll(p.getVoteUser());
            }
        } else {
            ArrayList<Player> tmp = new ArrayList<>();
            tmp.addAll(this.getTeam1().bestPlayers());
            tmp.addAll(this.getTeam2().bestPlayers());

            for (Player p : tmp) {
                winners.addAll(p.getVoteUser());
            }
        }

        return winners;
    }


    public boolean hasParis(String name) {
        for (Map.Entry<String, String> map : this.paris.entrySet()) {
            if (Objects.equals(map.getKey(), name)) {
                return true;
            }
        }
        return false;
    }

    public void addParis(String userName, String pari) {
        this.paris.put(userName, pari);
    }

    public void updateParis(String userName, String pari) {
        for (Map.Entry<String, String> map : this.paris.entrySet()) {
            if (Objects.equals(map.getKey(), userName)) {
                map.setValue(pari);
            }
        }
    }

    public ArrayList<String> winnersParis() {
        ArrayList<String> winners = new ArrayList<>();

        if (this.finish) {
            if (this.getTeam1().getScore() > this.getTeam2().getScore()) {
                for (Map.Entry<String, String> map : this.paris.entrySet()) {
                    if (Objects.equals(map.getValue(), "1")) {
                        winners.add(map.getKey());
                    }
                }
            } else if (this.getTeam1().getScore() < this.getTeam2().getScore()) {
                for (Map.Entry<String, String> map : this.paris.entrySet()) {
                    if (Objects.equals(map.getValue(), "2")) {
                        winners.add(map.getKey());
                    }
                }
            } else {
                for (Map.Entry<String, String> map : this.paris.entrySet()) {
                    if (Objects.equals(map.getValue(), "N")) {
                        winners.add(map.getKey());
                    }
                }
            }
        }
        return winners;
    }
}
