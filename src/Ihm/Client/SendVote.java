package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Classe SendVote
 */
public class SendVote extends JButton implements ActionListener {

    /**
     * Id de la compétition
     */
    private int compId;

    /**
     * Liste de joueur (choix)
     */
    private ListVote choice;

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Username
     */
    private String userName;

    /**
     * Identifiant unique de l'utilisateur
     */
    private String uniqueId;

    /**
     * Constructeur
     *
     * @param compId   identifiant de la compétition
     * @param choice   choix de vote
     * @param objDist  objet distant
     * @param userName username
     * @param uniqueId identifiant unique de l'utilisateur
     */
    public SendVote(int compId, ListVote choice, Contrat objDist, String userName, String uniqueId) {
        super();

        this.userName = userName;
        this.compId = compId;
        this.choice = choice;
        this.objDist = objDist;
        this.uniqueId = uniqueId;

        this.setText("Envoyer");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.choice.getChoice() != null) {
            try {
                boolean finish = this.objDist.getCompById(this.compId).isFinish();
                if (!finish) {
                    this.objDist.vote(this.userName, this.uniqueId, this.compId, this.choice.getChoice());
                    JOptionPane.showMessageDialog(null, "Vote envoyé", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Les votes sont fermés, match terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez selectionnez un joueur", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
