package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Vote extends JPanel {

    private JLabel title;
    private ListVote list;
    private SendVote sendVote;
    private Box box;

    public Vote(Contrat objDist, int compId, String userName) throws RemoteException {
        super();

        this.box = Box.createVerticalBox();
        this.title = new JLabel("Vote");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new ListVote(objDist, compId);
        this.sendVote = new SendVote(compId, this.list, objDist, userName);
        this.sendVote.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box.add(this.title);
        this.box.add(this.list);
        this.box.add(this.sendVote);
        this.add(this.box);

    }
}
