package Ihm.Admin;

import Classe.Event;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Classe SendEvent
 */
public class SendEvent extends JButton implements ActionListener {

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Id de la compétition
     */
    private int compId;

    /**
     * Zone de saisie et d'envoi d'évènement
     */
    private Entry content;

    /**
     * Texte à envoyer
     */
    private String event = null;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param compId  id de la compétition
     * @param content entry
     */
    public SendEvent(Contrat objDist, int compId, Entry content) {
        super();
        this.objDist = objDist;
        this.compId = compId;
        this.content = content;

        this.setText("Envoyer");
        this.setEnabled(false);
        this.addActionListener(this);
    }

    /**
     * Modifie le texte à envoyer (en fonction des entré taper sur le clavier)
     *
     * @param event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.objDist.addEvent(new Event(this.event), this.compId);
            this.content.clearTextField();
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
