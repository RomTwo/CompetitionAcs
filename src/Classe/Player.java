package Classe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Player
 */
public class Player implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * Id du joueur
     */
    private int id;

    /**
     * Prénom du joueur
     */
    private String name;

    /**
     * Nom du joueur
     */
    private String surname;

    /**
     * Liste des utilisateurs ayant voté pour le joueur
     */
    private ArrayList<String> voteUser = new ArrayList<>();

    /**
     * Constructeur
     *
     * @param id      id
     * @param name    prénom
     * @param surname nom
     */
    public Player(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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
     * Retourne le prénom
     *
     * @return prénom
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le nom
     *
     * @return nom
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Retourne les votes
     *
     * @return les votes
     */
    public ArrayList<String> getVoteUser() {
        return voteUser;
    }

    /**
     * Ajout d'un vote
     *
     * @param user vote à ajouter
     */
    public void addVote(String user) {
        this.voteUser.add(user);
    }

    /**
     * Suppression d'un vote
     *
     * @param user vote à supprimer
     */
    public void removeVote(String user) {
        this.voteUser.remove(user);
    }

}
