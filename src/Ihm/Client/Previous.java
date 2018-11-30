package Ihm.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Previous extends JButton implements ActionListener {

    private static final String TITRE = "Previous";
    private Main frame;
    private FrameComp parent;
    private Thread th;

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
