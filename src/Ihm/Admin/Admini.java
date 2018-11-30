package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

/**
 * Classe Admini
 */
public class Admini extends JFrame {
    /**
     * Titre
     */
    private static final String TITLE = "Administration";

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Titre
     */
    private JLabel title;

    /**
     * Liste des compétitions
     */
    private ListComp list;

    /**
     * Démarrer la compétition
     */
    private Start start;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @throws RemoteException exception
     */
    public Admini(Contrat objDist) throws RemoteException {
        super();

        this.box = Box.createVerticalBox();
        this.title = new JLabel(TITLE);
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.list = new ListComp(objDist);
        this.list.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.start = new Start(objDist, this.list, this);
        this.start.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box.add(this.title);
        this.box.add(new JPanel());
        this.box.add(this.list);
        this.box.add(this.start);

        this.setTitle("Compétitions");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.box, BorderLayout.NORTH);
        this.setVisible(true);
    }
}
