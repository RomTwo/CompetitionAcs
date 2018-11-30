package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Classe Entry
 */
public class Entry extends JPanel implements DocumentListener {

    /**
     * Zone de saisie de texte
     */
    private JTextField entry;

    /**
     * Envoi du texte vers la compétition (ajout d'un évènement)
     */
    private SendEvent send;

    /**
     * Conteneur
     */
    private Box box;

    /**
     * Constructeur
     *
     * @param objDist objet distant
     * @param compId  id de la compétition commentée
     */
    public Entry(Contrat objDist, int compId) {
        super();

        this.box = Box.createVerticalBox();
        this.entry = new JTextField();
        this.entry.getDocument().addDocumentListener(this);
        this.entry.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.send = new SendEvent(objDist, compId, this);
        this.send.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.box.add(this.entry);
        this.box.add(this.send);

        this.add(this.box);
    }

    /**
     * Effacer le contenu de la zone de saisie
     */
    public void clearTextField() {
        this.entry.setText(null);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (this.entry.getText().length() > 10) {
            this.send.setEnabled(true);
        } else {
            this.send.setEnabled(false);
        }
        this.send.setEvent(this.entry.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (this.entry.getText().length() > 10) {
            this.send.setEnabled(true);
        } else {
            this.send.setEnabled(false);
        }
        this.send.setEvent(this.entry.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (this.entry.getText().length() > 10) {
            this.send.setEnabled(true);
        } else {
            this.send.setEnabled(false);
        }
        this.send.setEvent(this.entry.getText());
    }
}
