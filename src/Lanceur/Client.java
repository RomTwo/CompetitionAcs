package Lanceur;

import Contrat.Contrat;
import Contrat.ContratClient;
import Ihm.Client.FrameComp;
import Ihm.Client.Main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ContratClient, Runnable {

    private static Contrat objDist;
    private FrameComp content;
    private int compId;

    public Client(Contrat o, FrameComp frame, int compId) throws RemoteException {
        Client.objDist = o;
        this.content = frame;
        this.compId = compId;
        objDist.addViewer(this, compId);
    }

    @Override
    public void msg(String msg) {
        this.content.addJLabel(msg);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            //Le client fait ce qu'il désire
        }
        try {
            objDist.removeViewer(this, this.compId);
            System.out.println("Intterupt.....");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Recherche de l'objet");
            String url = "rmi://" + args[0] + "/competition";
            Contrat objDist = (Contrat) Naming.lookup(url);

            String id = objDist.getId(args[1]);
            String username = args[1];

            if (id == null) {
                System.out.println("Connexion impossible cet utilisateur est déjà connecté...");
            } else {
                Main m = new Main(objDist, id, username);
            }


        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }


}