package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Classe Goal
 */
public class Goal extends JButton implements ActionListener {

    /**
     * Titre
     */
    private static final String GOAL = "But pour ";

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Id de la compétition
     */
    private int compId;

    /**
     * Id de l'équipe
     */
    private int teamId;

    /**
     * Constructeur
     *
     * @param objDist  objet distant
     * @param compId   id de la compétition
     * @param teamId   id de l'équipe
     * @param teamName nom de l'équipe
     */
    public Goal(Contrat objDist, int compId, int teamId, String teamName) {
        super();
        this.objDist = objDist;
        this.compId = compId;
        this.teamId = teamId;

        this.setText(GOAL + teamName);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.objDist.goal(this.compId, this.teamId);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
