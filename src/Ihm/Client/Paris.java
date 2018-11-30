package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;

public class Paris extends JPanel {

    private JLabel title;
    private JComboBox<String> list;
    private SendParis sendParis;
    private Box box;

    public Paris(Contrat objDist, int compId, String userName) {
        super();

        this.title = new JLabel("Paris");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new JComboBox<>();
        this.list.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list.addItem("-- Selectionnez un pari --");
        this.list.addItem("1");
        this.list.addItem("N");
        this.list.addItem("2");
        this.sendParis = new SendParis(compId, this.list, objDist, userName);
        this.sendParis.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box = Box.createVerticalBox();

        this.box.add(this.title);
        this.box.add(new JPanel());
        this.box.add(this.list);
        this.box.add(this.sendParis);

        this.add(this.box);

    }

}
