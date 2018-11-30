package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Main extends JFrame {

    private static final String TITLE = "Compétitions";
    private JLabel title;
    private Logout logout;
    private CompChoice comp;
    private String userName;
    private JPanel panLogout;

    public Main(Contrat objDist, String userId, String userName) throws RemoteException {
        super();
        this.userName = userName;

        this.title = new JLabel(TITLE);
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.logout = new Logout(objDist, userId);
        this.comp = new CompChoice(objDist, this);

        this.setTitle("Compétitions");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pack();

        this.panLogout = new JPanel(new BorderLayout());
        this.panLogout.add(this.logout, BorderLayout.EAST);

        this.getContentPane().add(this.panLogout, BorderLayout.NORTH);
        this.getContentPane().add(this.comp, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public String getUserName() {
        return userName;
    }


}
