package Ihm.Client;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

/**
 * Classe Main
 */
public class Main extends JFrame {

    /**
     * Titre
     */
    private static final String TITLE = "Compétitions";

    /**
     * Titre
     */
    private JLabel title;

    /**
     * Permet de se déconnecter
     */
    private Logout logout;

    /**
     *
     */
    private CompChoice comp;

    /**
     * Username
     */
    private String userName;

    /**
     * Conteneur
     */
    private JPanel panLogout;

    /**
     * Identifiant unique de l'utilisateur
     */
    private String userId;

    /**
     * Constructeur
     *
     * @param objDist  objet distant
     * @param userId   identifiant unique
     * @param userName username
     * @throws RemoteException
     */
    public Main(Contrat objDist, String userId, String userName) throws RemoteException {
        super();
        this.userName = userName;
        this.userId = userId;

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

    /**
     * Retourne le username
     *
     * @return String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Retourne l'identifiant unique
     *
     * @return String
     */
    public String getUserId() {
        return userId;
    }
}
