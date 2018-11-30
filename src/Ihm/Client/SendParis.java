package Ihm.Client;


import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class SendParis extends JButton implements ActionListener {

    /**
     * Id de la compétition
     */
    private int compId;

    /**
     * Liste de pari
     */
    private JComboBox<String> choice;

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Username
     */
    private String userName;

    /**
     * Id unique de l'utilisateur
     */
    private String uniqueId;

    /**
     * Constructeur
     *
     * @param compId   id de la compétition
     * @param choice   choix de pari
     * @param objDist  objet distant
     * @param userName username
     * @param uniqueId id unique de l'utilisateur
     */
    public SendParis(int compId, JComboBox<String> choice, Contrat objDist, String userName, String uniqueId) {
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
        System.out.println(this.choice.getSelectedItem());

        String pari = (String) this.choice.getSelectedItem();

        if (pari != null) {
            if (pari.length() < 2) {
                try {
                    boolean finish = this.objDist.getCompById(this.compId).isFinish();
                    if (!finish) {
                        try {
                            this.objDist.paris(this.userName, this.uniqueId, this.compId, pari);
                            JOptionPane.showMessageDialog(null, "Pari envoyé", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Les paris sont fermés, match terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez un pari", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez selectionnez un pari", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
