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
    private Paris paris;
    private Box box;
    private Box box2;

    public FrameComp(Contrat objDist, int compId, Main frame) throws RemoteException {
        super();
        this.box = Box.createVerticalBox();
        this.box2 = Box.createVerticalBox();
        this.events = new JPanel();
        this.events.add(this.box);
        this.events.setAlignmentX(Component.CENTER_ALIGNMENT);
        Thread th = new Thread(new Client(objDist, this, compId));
        th.start();

        this.prev = new Previous(frame, this, th);
        this.vote = new Vote(objDist, compId, frame.getUserName());
        this.paris = new Paris(objDist, compId, frame.getUserName());
        this.setTitle("Compétitions");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pack();

        this.box2 = Box.createVerticalBox();
        this.box2.add(this.vote);
        this.box2.add(new JPanel());
        this.box2.add(this.paris);

        this.getContentPane().add(this.events, BorderLayout.CENTER);
        this.getContentPane().add(this.prev, BorderLayout.WEST);
        this.getContentPane().add(this.box2, BorderLayout.EAST);
        this.setVisible(true);
    }

    public void addJLabel(String msg) {
        this.box.add(new JLabel(msg));
        this.validate();
    }
}
