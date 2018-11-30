package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Go extends JButton implements ActionListener {

    private static final String TITLE = "Suivre";
    private int compId;
    private Contrat objDist;
    private Main frame;

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
            FrameComp fc = new FrameComp(this.objDist, this.compId, this.frame);
            this.frame.setVisible(false);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }

    }
}