package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Classe Finish
 */
public class Finish extends JButton implements ActionListener {

    /**
     * Titre
     */
    private static final String FINISH = "Terminer le match";

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Id de la compétition courante
     */
    private int compId;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param compId  id de la compétition courante
     */
    public Finish(Contrat objDist, int compId) {
        super();
        this.objDist = objDist;
        this.compId = compId;

        this.setText(FINISH);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.objDist.finish(this.compId);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
