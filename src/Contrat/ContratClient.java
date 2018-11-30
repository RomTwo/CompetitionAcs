package Contrat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Classe ContratClient
 */
public interface ContratClient extends Remote {
    /**
     * Ajoute l'évènement dans le panel (pour les utilisateurs qui suive une compétition)
     *
     * @param msg évènement à ajouter
     * @throws RemoteException exception
     */
    void msg(String msg) throws RemoteException;
}
