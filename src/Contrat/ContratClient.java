package Contrat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContratClient extends Remote {
    void msg(String msg) throws RemoteException;
}
