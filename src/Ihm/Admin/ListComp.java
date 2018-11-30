package Ihm.Admin;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Objects;

public class ListComp extends JComboBox<String> implements ActionListener {

    private Contrat objDist;
    private Competition choice = null;

    public ListComp(Contrat objDist) throws RemoteException {
        super();
        this.addActionListener(this);
        this.objDist = objDist;
        this.constructList();

    }

    public Competition getByTitle(String name) throws RemoteException {
        for (Competition c : this.objDist.getCompetitions()) {
            String t = c.getTeam1().getName() + " VS " + c.getTeam2().getName();
            if (Objects.equals(t, name)) {
                return c;
            }
        }
        return null;
    }

    public void refresh() throws RemoteException {
        this.removeAllItems();
        this.constructList();
    }

    private void constructList() throws RemoteException {
        for (Competition c : this.objDist.getCompetitions()) {
            if (!c.isHasAdmin()) {
                this.addItem(c.getTeam1().getName() + " VS " + c.getTeam2().getName());
            }
        }
    }

    public Competition getChoice() {
        return choice;
    }

    public void setChoice(Competition choice) {
        this.choice = choice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String t = (String) comboBox.getSelectedItem();

        try {
            setChoice(getByTitle(t));
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }


    }
}
