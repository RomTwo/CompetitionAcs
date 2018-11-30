package Ihm.Client;


import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class SendParis extends JButton implements ActionListener {

    private int compId;
    private JComboBox<String> choice;
    private Contrat objDist;
    private String userName;

    public SendParis(int compId, JComboBox<String> choice, Contrat objDist, String userName) {
        super();

        this.userName = userName;
        this.compId = compId;
        this.choice = choice;
        this.objDist = objDist;

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
                            this.objDist.paris(this.userName, this.compId, pari);
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
