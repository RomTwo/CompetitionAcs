package Classe;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    private int id;
    private String name;
    private ArrayList<Player> players = new ArrayList<>();
    private int score;

    public Team(int id, String name, ArrayList<Player> p) {
        this.id = id;
        this.name = name;
        this.players = p;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getScore() {
        return score;
    }

    public void goal() {
        this.score++;
    }

    public ArrayList<Player> bestPlayers() {
        ArrayList<Player> list = new ArrayList<>();
        int res = 0;

        for (Player p : this.getPlayers()) {
            if (p.getVoteUser().size() > res) {
                if (list.size() > 0) {
                    list.clear();
                }
                list.add(p);
                //res = p.getVote();
            } else if (p.getVoteUser().size() == res) {
                list.add(p);
            }
        }
        return list;
    }

}
