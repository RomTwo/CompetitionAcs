package Ihm.Admin;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;

public class Actions extends JPanel {

    private Entry entry;
    private Goal goalTeam1;
    private Goal goalTeam2;
    private Finish finish;
    private Box box;

    public Actions(Contrat objDist, Competition c) {
        super();

        this.entry = new Entry(objDist, c.getId());
        this.goalTeam1 = new Goal(objDist, c.getId(), c.getTeam1().getId());
        this.goalTeam2 = new Goal(objDist, c.getId(), c.getTeam2().getId());
        this.finish = new Finish(objDist, c.getId());

        this.box = Box.createVerticalBox();

        this.box.add(this.goalTeam1);
        this.box.add(this.goalTeam2);
        this.box.add(this.finish);
        this.box.add(this.entry);

        this.add(this.box);

    }
}
