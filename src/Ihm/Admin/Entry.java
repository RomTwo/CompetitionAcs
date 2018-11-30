package Ihm.Admin;

import Contrat.Contrat;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Entry extends JPanel implements DocumentListener {

    private JTextField entry;
    private SendEvent send;
    private Box box;

    public Entry(Contrat objDist, int compId) {
        super();

        this.box = Box.createVerticalBox();
        this.entry = new JTextField();
        this.entry.getDocument().addDocumentListener(this);
        this.send = new SendEvent(objDist, compId, this);

        this.box.add(this.entry);
        this.box.add(this.send);

        this.add(this.box);
    }

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
