package Ihm.Client;

import Contrat.Contrat;
import Lanceur.Client;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

/**
 * Classe FrameComp
 */
public class FrameComp extends JFrame {

    /**
     * Conteneur
     */
    private JPanel events;

    /**
     * Permet de revenir vers la page d'accueil
     */
    private Previous prev;

    /**
     * Permet de voter
     */
    private Vote vote;

    /**
     * Permet de parier
     */
    private Paris paris;

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Conteneur
     */
    private Box box2;

    /**
     * Constructeur
     *
     * @param objDist  objet distant
     * @param compId   id de la compétition
     * @param frame    frame parent
     * @param uniqueId identifiant unique de l'utitilisateur
     * @throws RemoteException exception
     */
    public FrameComp(Contrat objDist, int compId, Main frame, String uniqueId) throws RemoteException {
        super();
        this.box = Box.createVerticalBox();
        this.box2 = Box.createVerticalBox();
        this.events = new JPanel();
        this.events.add(this.box);
        this.events.setAlignmentX(Component.CENTER_ALIGNMENT);
        Thread th = new Thread(new Client(objDist, this, compId, frame.getUserName(), uniqueId));
        th.start();

        this.prev = new Previous(frame, this, th);
        this.vote = new Vote(objDist, compId, frame.getUserName(), uniqueId);
        this.paris = new Paris(objDist, compId, frame.getUserName(), uniqueId);
        this.setTitle("Compétitions");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

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

    /**
     * Ajout de l'évènement dans la fenêtre
     *
     * @param msg évènement
     */
    public void addJLabel(String msg) {
        this.box.add(new JLabel(msg));
        this.validate();
    }
}
