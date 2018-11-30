package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;

/**
 * Classe Paris
 */
public class Paris extends JPanel {

    /**
     * Titre
     */
    private JLabel title;

    /**
     * Liste de paris
     */
    private JComboBox<String> list;

    /**
     * Envoyer le paris
     */
    private SendParis sendParis;

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Constructeur
     *
     * @param objDist  objet distant
     * @param compId   id de la compétition
     * @param userName username
     * @param uniqueId identifiant unique de l'utilisateur
     */
    public Paris(Contrat objDist, int compId, String userName, String uniqueId) {
        super();

        this.title = new JLabel("Paris");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new JComboBox<>();
        this.list.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list.addItem("-- Selectionnez un pari --");
        this.list.addItem("1");
        this.list.addItem("N");
        this.list.addItem("2");
        this.sendParis = new SendParis(compId, this.list, objDist, userName, uniqueId);
        this.sendParis.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box = Box.createVerticalBox();

        this.box.add(this.title);
        this.box.add(new JPanel());
        this.box.add(this.list);
        this.box.add(this.sendParis);

        this.add(this.box);

    }

}
