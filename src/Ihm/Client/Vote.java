package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

/**
 * Classe Vote
 */
public class Vote extends JPanel {

    /**
     * Titre
     */
    private JLabel title;

    /**
     * Liste de vote (liste de joueur)
     */
    private ListVote list;

    /**
     * Envoi du vote
     */
    private SendVote sendVote;

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Constructeur
     *
     * @param objDist  objet distant
     * @param compId   id de la compétition
     * @param userName username
     * @param uniqueId identifiant unique de l'utilisateur
     * @throws RemoteException exception
     */
    public Vote(Contrat objDist, int compId, String userName, String uniqueId) throws RemoteException {
        super();

        this.box = Box.createVerticalBox();
        this.title = new JLabel("Vote");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new ListVote(objDist, compId);
        this.sendVote = new SendVote(compId, this.list, objDist, userName, uniqueId);
        this.sendVote.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box.add(this.title);
        this.box.add(this.list);
        this.box.add(this.sendVote);
        this.add(this.box);

    }
}
