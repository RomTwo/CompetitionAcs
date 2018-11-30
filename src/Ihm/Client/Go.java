package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Classe Go
 */
public class Go extends JButton implements ActionListener {

    /**
     * Titre
     */
    private static final String TITLE = "Suivre";

    /**
     * Id de la compétition
     */
    private int compId;

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Frame parent
     */
    private Main frame;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param compId  id de la compétition
     * @param frame   frame parent
     */
    public Go(Contrat objDist, int compId, Main frame) {
        super();
        this.compId = compId;
        this.objDist = objDist;
        this.frame = frame;
        this.setText(TITLE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FrameComp fc = new FrameComp(this.objDist, this.compId, this.frame, this.frame.getUserId());
            this.frame.setVisible(false);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }

    }
}