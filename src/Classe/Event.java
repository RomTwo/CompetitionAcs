package Classe;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Serializable {
    private String text;

    public Event(String texte) {
        SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss");
        Date today = new Date();
        String date = formater.format(today);

        this.text = date + " : " + texte;

    }

    public String getText() {
        return text;
    }

}
