package Ihm.Client;

import Classe.Player;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Objects;

/**
 * Classe ListVote
 */
public class ListVote extends JComboBox<String> implements ActionListener {

    /**
     * Joueur choisi
     */
    private Player choice = null;

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Id de la compétition
     */
    private int compId;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param compId  id de la compétition
     * @throws RemoteException exception
     */
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

    /**
     * Retourne un joueur rechercher en fonction du nom passé en paramètre
     *
     * @param name paramètre de recherche
     * @return un joueur
     * @throws RemoteException exception
     */
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

    /**
     * Joueur choisi
     *
     * @return Player
     */
    public Player getChoice() {
        return choice;
    }

    /**
     * Modification du choix
     *
     * @param choice nouveau joueur choisi
     */
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
