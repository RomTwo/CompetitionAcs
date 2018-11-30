package Ihm.Admin;

import Classe.Event;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class SendEvent extends JButton implements ActionListener {

    private Contrat objDist;
    private int compId;
    private Entry content;
    private String event = null;

    public SendEvent(Contrat objDist, int compId, Entry content) {
        super();
        this.objDist = objDist;
        this.compId = compId;
        this.content = content;

        this.setText("SendVote");
        this.setEnabled(false);
        this.addActionListener(this);
    }

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
