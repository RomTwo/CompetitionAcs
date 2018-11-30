package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Admini extends JFrame {
    private static final String TITLE = "Administration";
    private Box box;
    private JLabel title;
    private ListComp list;
    private Start start;

    public Admini(Contrat objDist) throws RemoteException {
        super();

        this.box = Box.createVerticalBox();
        this.title = new JLabel(TITLE);
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new ListComp(objDist);
        this.start = new Start(objDist, this.list, this);

        this.box.add(this.title);
        this.box.add(this.list);
        this.box.add(this.start);

        this.setTitle("Compétitions");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.box);
        this.setVisible(true);
    }
}
