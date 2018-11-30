package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Finish extends JButton implements ActionListener {

    private static final String FINISH = "FINISH";
    private Contrat objDist;
    private int compId;

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
