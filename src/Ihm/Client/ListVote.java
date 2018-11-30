package Ihm.Client;

import Classe.Player;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Objects;

public class ListVote extends JComboBox<String> implements ActionListener {

    private Player choice = null;
    private Contrat objDist;
    private int compId;

    public ListVote(Contrat objDist, int compId) throws RemoteException {
        super();
        this.addActionListener(this);
        this.objDist = objDist;
        this.compId = compId;

        this.addItem("-- Selectionnez un joueur --");
        for (Player p1 : this.objDist.getCompById(compId).getTeam1().getPlayers()) {
            this.addItem(p1.getSurname() + " " + p1.getName());
        }
        for (Player p2 : this.objDist.getCompById(compId).getTeam2().getPlayers()) {
            this.addItem(p2.getSurname() + " " + p2.getName());
        }

    }

    public Player getByName(String name) throws RemoteException {
        for (Player p1 : this.objDist.getCompById(this.compId).getTeam1().getPlayers()) {
            String t = p1.getSurname() + " " + p1.getName();
            if (Objects.equals(t, name)) {
                return p1;
            }
        }
        for (Player p2 : this.objDist.getCompById(this.compId).getTeam2().getPlayers()) {
            String t = p2.getSurname() + " " + p2.getName();
            if (Objects.equals(t, name)) {
                return p2;
            }
        }

        return null;
    }

    public Player getChoice() {
        return choice;
    }

    public void setChoice(Player choice) {
        this.choice = choice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String t = (String) comboBox.getSelectedItem();
        try {
            setChoice(getByName(t));
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
