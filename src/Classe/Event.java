package Classe;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Event
 */
public class Event implements Serializable {

    /**
     * Texte de l'évènement
     */
    private String text;

    /**
     * Constructeur
     * @param texte texte
     */
    public Event(String texte) {
        SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss");
        Date today = new Date();
        String date = formater.format(today);

        this.text = date + " : " + texte;

    }

    /**
     * Retourne le texte de l'évènement
     * @return texte
     */
    public String getText() {
        return text;
    }

}
