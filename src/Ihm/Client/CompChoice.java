package Ihm.Client;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;
import java.rmi.RemoteException;

public class CompChoice extends JPanel {

    public CompChoice(Contrat objDist, Main parent) throws RemoteException {
        super();

        for (Competition c : objDist.getCompetitions()) {
            this.add(constructPanel(c, objDist, parent));
        }
    }

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
