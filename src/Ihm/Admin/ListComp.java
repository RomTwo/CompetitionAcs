package Ihm.Admin;

import Classe.Competition;
import Contrat.Contrat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Objects;

/**
 * Classe ListComp
 */
public class ListComp extends JComboBox<String> implements ActionListener {

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Compétition choisie
     */
    private Competition choice = null;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @throws RemoteException exception
     */
    public ListComp(Contrat objDist) throws RemoteException {
        super();
        this.addActionListener(this);
        this.objDist = objDist;
        this.constructList();

    }

    /**
     * Retourne une compétition rechercher en fonction du nom passé en paramètre
     *
     * @param name nom
     * @return une compétition
     * @throws RemoteException exception
     */
    public Competition getByTitle(String name) throws RemoteException {
        for (Competition c : this.objDist.getCompetitions()) {
            String t = c.getTeam1().getName() + " VS " + c.getTeam2().getName();
            if (Objects.equals(t, name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Mise à jour de la liste de compétition à commenter (certaines compétitions sont peut-être terminées)
     *
     * @throws RemoteException
     */
    public void refresh() throws RemoteException {
        this.removeAllItems();
        this.constructList();
    }

    /**
     * Ajout des compétition dans la liste de compétition
     *
     * @throws RemoteException exception
     */
    private void constructList() throws RemoteException {
        for (Competition c : this.objDist.getCompetitions()) {
            if (!c.isHasAdmin()) {
                this.addItem(c.getTeam1().getName() + " VS " + c.getTeam2().getName());
            }
        }
    }

    /**
     * Eetourne la compétition choisie
     *
     * @return une compétition
     */
    public Competition getChoice() {
        return choice;
    }

    /**
     * Modifie le choix de la compétition
     *
     * @param choice une compétition
     */
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
