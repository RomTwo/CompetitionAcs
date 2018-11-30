package Classe;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private int id;
    private String name;
    private String surname;
    private ArrayList<String> voteUser = new ArrayList<>();

    public Player(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<String> getVoteUser() {
        return voteUser;
    }

    public void addVote(String user) {
        this.voteUser.add(user);
    }

    public void removeVote(String user) {
        this.voteUser.remove(user);
    }

}
