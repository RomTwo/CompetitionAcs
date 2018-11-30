package Ihm.Client;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Classe CompChoice
 */
public class CompChoice extends JPanel {

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param parent  frame parent
     * @throws RemoteException
     */
    public CompChoice(Contrat objDist, Main parent) throws RemoteException {
        super();

        this.box = Box.createVerticalBox();
        for (Competition c : objDist.getCompetitions()) {
            this.box.add(constructPanel(c, objDist, parent));
        }
        this.add(this.box);
    }

    /**
     * Construction d'un panel avec le nom de la compétition et le bouton permmettant de suivre la compétition
     *
     * @param comp    compétition
     * @param objDist objet distant
     * @param frame   frame parent
     * @return JPanel
     */
    private JPanel constructPanel(Competition comp, Contrat objDist, Main frame) {
        JPanel panel = new JPanel();
        Go btn = new Go(objDist, comp.getId(), frame);
        panel.add(new JLabel(comp.getType()));
        panel.add(new JLabel(comp.getTitle()));
        panel.add(new JLabel(comp.getTeam1().getName() + " VS " + comp.getTeam2().getName()));
        panel.add(btn);

        return panel;
    }
}
