package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Classe Start
 */
public class Start extends JButton implements ActionListener {

    /**
     * Objet distant
     */
    private Contrat objDist;

    /**
     * Liste de compétition
     */
    private ListComp choice;

    /**
     * Frame parent
     */
    private Admini content;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param list    list de compétition
     * @param content frame parent
     */
    public Start(Contrat objDist, ListComp list, Admini content) {
        super();
        this.objDist = objDist;
        this.choice = list;
        this.content = content;
        this.setText("Start");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.choice.getChoice() != null) {
            try {
                if (this.objDist.addAdmin(this.choice.getChoice().getId())) {
                    this.choice.setVisible(false);
                    this.setVisible(false);
                    Actions actions = new Actions(this.objDist, this.choice.getChoice());
                    this.content.getContentPane().add(actions, BorderLayout.CENTER);

                } else {
                    JOptionPane.showMessageDialog(null, "Compétition déjà démarré", "Erreur", JOptionPane.WARNING_MESSAGE);
                    this.choice.refresh();
                }
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        }

    }
}
