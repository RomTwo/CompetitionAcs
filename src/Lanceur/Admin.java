package Lanceur;

import Contrat.Contrat;
import Ihm.Admin.Admini;

import java.rmi.Naming;

/**
 * Classe Admin
 */
public class Admin {
    public static void main(String[] args) {
        try {
            System.out.println("Recherche de l'objet");
            String url = "rmi://" + args[0] + "/competition";
            Contrat objDist = (Contrat) Naming.lookup(url);

            Admini ad = new Admini(objDist);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }
}
