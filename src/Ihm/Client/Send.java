package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Send extends JButton implements ActionListener {

    private int compId;
    private ListVote choice;
    private Contrat objDist;
    private String userName;

    public Send(int compId, ListVote choice, Contrat objDist, String userName) {
        super();

        this.userName = userName;

        this.setText("Send");
        this.addActionListener(this);
        this.compId = compId;
        this.choice = choice;
        this.objDist = objDist;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.choice.getChoice() != null) {
            try {
                boolean finish = this.objDist.getCompById(this.compId).isFinish();
                if (!finish) {
                    this.objDist.vote(this.userName, this.compId, this.choice.getChoice()); //Passer le username du client
                    JOptionPane.showMessageDialog(null, "Vote envoyé", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Les votes sont fermés, match terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        }
    }
}
