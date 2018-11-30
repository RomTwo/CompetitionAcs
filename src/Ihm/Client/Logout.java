package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Class Logout
 */
public class Logout extends JButton implements ActionListener {

    /**
     * Titre
     */
    private static final String TITLE = "Quitter";

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Identifiant unique de l'utilsateur
     */
    private String id;

    /**
     * Constructeur
     *
     * @param c objet distant
     * @param i identifiant unique
     */
    public Logout(Contrat c, String i) {
        this.objDist = c;
        this.id = i;
        this.setText(TITLE);
        this.addActionListener(this);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.objDist.close(this.id);
            System.exit(0);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
