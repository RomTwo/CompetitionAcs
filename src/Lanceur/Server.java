package Lanceur;

import Contrat.ContratImpl;

import java.rmi.Naming;

/**
 * Classe Server
 */
public class Server {
    public static void main(String[] args) {
        ContratImpl objServ = null;
        try {
            System.out.println("Création de l'objet distant...");
            objServ = new ContratImpl();
            System.out.println("Enregistrement de l'objet distant...");
            Naming.rebind("competition", objServ);
            System.out.println("Lanceur.Server opérationnel.");

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
