package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Vote extends JPanel {

    private JLabel title;
    private ListVote list;
    private Send send;
    private Box box;

    public Vote(Contrat objDist, int compId, String userName) throws RemoteException {
        super();

        this.box = Box.createVerticalBox();
        this.title = new JLabel("Vote");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new ListVote(objDist, compId);
        this.send = new Send(compId, this.list, objDist, userName);

        this.box.add(this.title);
        this.box.add(this.list);
        this.box.add(this.send);
        this.add(this.box);

    }
}
