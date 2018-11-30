package Ihm.Admin;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;

public class Actions extends JPanel {

    private Entry entry;
    private Goal goalTeam1;
    private Goal goalTeam2;
    private Finish finish;
    private JLabel title;
    private Box box;
    private Box box2;
    private Box box3;

    public Actions(Contrat objDist, Competition c) {
        super();

        this.title = new JLabel(c.getTeam1().getName() + "VS" + c.getTeam2().getName());
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.entry = new Entry(objDist, c.getId());
        this.goalTeam1 = new Goal(objDist, c.getId(), c.getTeam1().getId(), c.getTeam1().getName());
        this.goalTeam2 = new Goal(objDist, c.getId(), c.getTeam2().getId(), c.getTeam2().getName());
        this.finish = new Finish(objDist, c.getId());

        this.box = Box.createVerticalBox();
        this.box.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.box2 = Box.createHorizontalBox();
        this.box2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.box3 = Box.createVerticalBox();
        this.box3.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box.add(this.entry);

        this.box2.add(this.goalTeam1);
        this.box2.add(this.goalTeam2);
        this.box2.add(this.finish);

        this.box3.add(this.title);
        this.box3.add(this.box2);
        this.box3.add(this.box);

        this.add(this.box3);
    }
}
