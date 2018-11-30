package Classe;

import java.util.ArrayList;

public class Scenario {

    public Scenario() {

    }

    public Competition foot() {

        // Joueurs Real Madrid
        Player a1 = new Player(1, "Thibaud", "Courtois");
        Player a2 = new Player(2, "Dani", "Carvajal");
        Player a3 = new Player(3, "Raphael", "Varane");
        Player a4 = new Player(4, "Sergio", "Ramos");
        Player a5 = new Player(5, "", "Marcelo");
        Player a7 = new Player(6, "Toni", "Kroos");
        Player a6 = new Player(7, "Carlos Henrique", "Casemiro");
        Player a8 = new Player(8, "Lukas", "Modric");
        Player a9 = new Player(9, "", "Isco");
        Player a10 = new Player(10, "Karim", "Benzema");
        Player a11 = new Player(11, "Gareth", "Bale");

        ArrayList<Player> madridPlayers = new ArrayList<>();
        madridPlayers.add(a1);
        madridPlayers.add(a2);
        madridPlayers.add(a3);
        madridPlayers.add(a4);
        madridPlayers.add(a5);
        madridPlayers.add(a6);
        madridPlayers.add(a7);
        madridPlayers.add(a8);
        madridPlayers.add(a9);
        madridPlayers.add(a10);
        madridPlayers.add(a11);

        // Joueurs FC Barcelone
        Player b1 = new Player(1, "Marc-André ", "Ter Stegen");
        Player b2 = new Player(2, "Sergi", "Roberto");
        Player b3 = new Player(3, "Gerard", "Piqué");
        Player b4 = new Player(4, "Samuel", "Umtiti");
        Player b5 = new Player(5, "Jordi", "Alba");
        Player b6 = new Player(6, "Phillipe", "Coutinho");
        Player b7 = new Player(7, "Sergio", "Busquet");
        Player b8 = new Player(8, "Ivan", "Rakitic");
        Player b9 = new Player(9, "Ousmane", "Dembélé");
        Player b10 = new Player(10, "Luis", "Suarez");
        Player b11 = new Player(11, "Lionel", "Messi");

        ArrayList<Player> barcaPlayers = new ArrayList<>();
        barcaPlayers.add(b1);
        barcaPlayers.add(b2);
        barcaPlayers.add(b3);
        barcaPlayers.add(b4);
        barcaPlayers.add(b5);
        barcaPlayers.add(b6);
        barcaPlayers.add(b7);
        barcaPlayers.add(b8);
        barcaPlayers.add(b9);
        barcaPlayers.add(b10);
        barcaPlayers.add(b11);

        //Les équipes
        Team madrid = new Team(1, "Real Madrid", madridPlayers);
        Team barca = new Team(2, "FC Barcelone", barcaPlayers);

        //Les compétitions
        Competition foot = new Competition(1, "Champion's Leaque", "Football", madrid, barca);

        return foot;
    }

    public Competition foot2() {

        // Joueurs Real Madrid
        Player a1 = new Player(1, "Thibaud", "Courtois");
        Player a2 = new Player(2, "Dani", "Carvajal");
        Player a3 = new Player(3, "Raphael", "Varane");
        Player a4 = new Player(4, "Sergio", "Ramos");
        Player a5 = new Player(5, "", "Marcelo");
        Player a7 = new Player(6, "Toni", "Kroos");
        Player a6 = new Player(7, "Carlos Henrique", "Casemiro");
        Player a8 = new Player(8, "Lukas", "Modric");
        Player a9 = new Player(9, "", "Isco");
        Player a10 = new Player(10, "Karim", "Benzema");
        Player a11 = new Player(11, "Gareth", "Bale");

        ArrayList<Player> madridPlayers = new ArrayList<>();
        madridPlayers.add(a1);
        madridPlayers.add(a2);
        madridPlayers.add(a3);
        madridPlayers.add(a4);
        madridPlayers.add(a5);
        madridPlayers.add(a6);
        madridPlayers.add(a7);
        madridPlayers.add(a8);
        madridPlayers.add(a9);
        madridPlayers.add(a10);
        madridPlayers.add(a11);

        // Joueurs FC Barcelone
        Player b1 = new Player(1, "Marc-André ", "Ter Stegen");
        Player b2 = new Player(2, "Sergi", "Roberto");
        Player b3 = new Player(3, "Gerard", "Piqué");
        Player b4 = new Player(4, "Samuel", "Umtiti");
        Player b5 = new Player(5, "Jordi", "Alba");
        Player b6 = new Player(6, "Phillipe", "Coutinho");
        Player b7 = new Player(7, "Sergio", "Busquet");
        Player b8 = new Player(8, "Ivan", "Rakitic");
        Player b9 = new Player(9, "Ousmane", "Dembélé");
        Player b10 = new Player(10, "Luis", "Suarez");
        Player b11 = new Player(11, "Lionel", "Messi");

        ArrayList<Player> barcaPlayers = new ArrayList<>();
        barcaPlayers.add(b1);
        barcaPlayers.add(b2);
        barcaPlayers.add(b3);
        barcaPlayers.add(b4);
        barcaPlayers.add(b5);
        barcaPlayers.add(b6);
        barcaPlayers.add(b7);
        barcaPlayers.add(b8);
        barcaPlayers.add(b9);
        barcaPlayers.add(b10);
        barcaPlayers.add(b11);

        //Les équipes
        Team madrid = new Team(3, "Lyon", madridPlayers);
        Team barca = new Team(4, "PSG", barcaPlayers);

        //Les compétitions
        Competition foot = new Competition(2, "Champion's Leaque", "Football", madrid, barca);

        return foot;
    }
}
