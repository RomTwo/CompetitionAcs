package Ihm.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe Previous
 */
public class Previous extends JButton implements ActionListener {

    /**
     * Titre
     */
    private static final String TITRE = "Précédent";

    /**
     * Page principale
     */
    private Main frame;

    /**
     * Frame parent
     */
    private FrameComp parent;

    /**
     * Thread lancé dans le parent
     */
    private Thread th;

    /**
     * Constructeur
     *
     * @param frame  page principale
     * @param parent frame parent
     * @param th     thread lancé dans le parent
     */
    public Previous(Main frame, FrameComp parent, Thread th) {
        super();
        this.frame = frame;
        this.parent = parent;
        this.th = th;

        this.setText(TITRE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.setVisible(true);
        this.parent.dispose();

        this.th.interrupt();
        try {
            this.th.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }
}
