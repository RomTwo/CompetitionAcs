package Contrat;

import Classe.Competition;
import Classe.Event;
import Classe.Player;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Classe Contrat
 */
public interface Contrat extends Remote {

    /**
     * Créé et retourne un id unique pour chaque utilisateur (lors de la connexion)
     * Ajoute l'utilisateur dans le HasMap des utilisateurs connectés
     *
     * @param name identifiants
     * @return id unique
     * @throws RemoteException exception
     */
    String getId(String name) throws RemoteException;

    /**
     * Déconnexion de l'utilisateur, suppression de l'utilisateur dans le HasMap des utilisateurs connectés
     *
     * @param id id unique
     * @throws RemoteException exception
     */
    void close(String id) throws RemoteException;

    /**
     * Retourne la liste des compétitions
     *
     * @return une liste de compétition
     * @throws RemoteException exception
     */
    ArrayList<Competition> getCompetitions() throws RemoteException;

    /**
     * Recherche une compétition en fonction de l'id passé en paramètre
     *
     * @param id id de la compéttion
     * @return une compétition
     * @throws RemoteException exception
     */
    Competition getCompById(int id) throws RemoteException;

    /**
     * Un utilisateur suit la compétition, on l'ajoute dans la liste des viewers de la compétition
     *
     * @param c  Client
     * @param id id de la compéttion
     * @throws RemoteException exception
     */
    void addViewer(ContratClient c, int id) throws RemoteException;

    /**
     * Un utilisateur arrête de suivre la compétition, on le supprime de la liste des viewers de la compétition
     *
     * @param c  Client
     * @param id id de la compéttion
     * @throws RemoteException exception
     */
    void removeViewer(ContratClient c, int id) throws RemoteException;

    /**
     * Voter pour un joueur
     *
     * @param userName identifiants de l'utilisateur
     * @param compId   id de la compéttion
     * @param p
     * @throws RemoteException exception
     */
    void vote(String userName, int compId, Player p) throws RemoteException;

    /**
     * Parier sur une compétition
     *
     * @param userName identifiants de l'utilisateur
     * @param compId   id de la compéttion
     * @param pari
     * @throws RemoteException exception
     */
    void paris(String userName, int compId, String pari) throws RemoteException;

    /**
     * Ajouter un évènement
     *
     * @param e  évènement à ajouter
     * @param id id de la compéttion
     * @throws RemoteException exception
     */
    void addEvent(Event e, int id) throws RemoteException;

    /**
     * Ajouter un administrateur à la compétition (un admin est déjà entrain de commenter la compétition)
     *
     * @param compId id de la compéttion
     * @return un booléen
     * @throws RemoteException exception
     */
    boolean addAdmin(int compId) throws RemoteException;

    /**
     * Marquer un but
     *
     * @param compId id de la compéttion
     * @param teamId id de l'équipe qui à marqué
     * @throws RemoteException exception
     */
    void goal(int compId, int teamId) throws RemoteException;

    /**
     * Met fin à une compétition
     *
     * @param compId id de la compéttion
     * @throws RemoteException exception
     */
    void finish(int compId) throws RemoteException;

}
