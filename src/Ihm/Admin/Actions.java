package Ihm.Admin;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;

/**
 * Classe Actions
 */
public class Actions extends JPanel {

    /**
     * Permet d'envoyer les évènements
     */
    private Entry entry;

    /**
     * Bouton permettant d'ajouter un but à l'équipe 1
     */
    private Goal goalTeam1;

    /**
     * Bouton permettant d'ajouter un but à l'équipe 2
     */
    private Goal goalTeam2;

    /**
     * Bouton permettant de terminer un match
     */
    private Finish finish;

    /**
     * Titre
     */
    private JLabel title;

    /**
     * Titre de la liste
     */
    private JLabel listTitle;

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Conteneur
     */
    private Box box2;

    /**
     * Conteneur
     */
    private Box box3;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param c       compétition
     */
    public Actions(Contrat objDist, Competition c) {
        super();

        this.title = new JLabel(c.getTeam1().getName() + " VS " + c.getTeam2().getName());
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.entry = new Entry(objDist, c.getId());
        this.goalTeam1 = new Goal(objDist, c.getId(), c.getTeam1().getId(), c.getTeam1().getName());
        this.goalTeam2 = new Goal(objDist, c.getId(), c.getTeam2().getId(), c.getTeam2().getName());
        this.finish = new Finish(objDist, c.getId());
        this.listTitle = new JLabel("Saisissez l'évènement :");
        this.listTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box = Box.createVerticalBox();
        this.box.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.box2 = Box.createHorizontalBox();
        this.box2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.box3 = Box.createVerticalBox();
        this.box3.setAlignmentX(Component.CENTER_ALIGNMENT);


        this.box.add(this.listTitle);
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
