package Contrat;

import Classe.Competition;
import Classe.Event;
import Classe.Player;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Contrat extends Remote {

    String getId(String name) throws RemoteException;

    void close(String id) throws RemoteException;

    ArrayList<Competition> getCompetitions() throws RemoteException;

    Competition getCompById(int id) throws RemoteException;

    void addViewer(ContratClient c, int id) throws RemoteException;

    void removeViewer(ContratClient c, int id) throws RemoteException;

    void vote(String userName, int compId, Player p) throws RemoteException;

    void paris(String userName, int compId, String pari) throws RemoteException;

    void addEvent(Event e, int id) throws RemoteException;

    boolean addAdmin(int compId) throws RemoteException;

    void goal(int compId, int teamId) throws RemoteException;

    void finish(int compId) throws RemoteException;

}
