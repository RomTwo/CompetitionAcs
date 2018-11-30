package Ihm.Client;

import Contrat.Contrat;
import Lanceur.Client;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class FrameComp extends JFrame {

    private JPanel events;
    private Previous prev;
    private Vote vote;

    public FrameComp(Contrat objDist, int compId, Main frame) throws RemoteException {
        super();
        this.events = new JPanel();
        Thread th = new Thread(new Client(objDist, this, compId));
        th.start();

        this.prev = new Previous(frame, this, th);
        this.vote = new Vote(objDist, compId, frame.getUserName());
        this.setTitle("Compétitions");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.events, BorderLayout.NORTH);
        this.getContentPane().add(this.prev, BorderLayout.WEST);
        this.getContentPane().add(this.vote, BorderLayout.EAST);
    }


    public void addJLabel(String msg) {
        this.events.add(new JLabel(msg));
        this.setVisible(false);
        this.setVisible(true);

    }
}
