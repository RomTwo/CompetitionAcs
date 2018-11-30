package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Goal extends JButton implements ActionListener {

    private static final String GOAL = "GOAL";
    private Contrat objDist;
    private int compId;
    private int teamId;

    public Goal(Contrat objDist, int compId, int teamId) {
        super();
        this.objDist = objDist;
        this.compId = compId;
        this.teamId = teamId;

        this.setText(GOAL);
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
