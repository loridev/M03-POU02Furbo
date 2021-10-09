package com.company;

import com.company.models.*;
import com.company.utils.ControladorsErrors;
import com.company.utils.Eines;

import java.util.ArrayList;

//TODO: CANVI JUGADORS I CONTROLAR QUE ESTIGUIN EXPULSATS O NO
public class Main {
    static ArrayList<Equip> equips = carregarPoolEquips();

    public static void main(String[] args) {
        int menu;
        int jugadorSeleccionat;
        ArrayList<Jugador> jugadors = carregarPoolJugadors();
        ArrayList<Entrenador> entrenadors = carregarPoolEntrenadors();
        Partit partit = new Partit(equips.get(0), equips.get(1));
        Arbitre arbitre = new Arbitre("Marc","Martinez","Principal", partit);
        if (partit.iniciar()){
            do{

                System.out.println("Que vols fer?\n" +
                        "1. Avançar 15 minuts \n" +
                        "2. Falta d'un jugador local \n" +
                        "3. Falta d'un jugador visitant \n" +
                        "4. Gol d'un jugador local \n" +
                        "5. Gol d'un jugador visitant \n" +
                        "6. Canviar jugador local \n" +
                        "7. Canviar jugador visitant \n" +
                        "8. Veure jugadors equip local \n" +
                        "9. Veure jugadors equip visitant");

                menu = ControladorsErrors.llegirEnter(1, 9);

                switch (menu){
                    case 1 -> partit.passarTemps();
                    case 2 -> {
                        System.out.println("Quin jugador local ha fet la falta?");
                        Eines.imprirArrayList(partit.getLocal().getJugadors());
                        jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getLocal().getJugadors().size());
                        if(!partit.getLocal().getJugadors().get(jugadorSeleccionat -1).isJugant()){
                            System.out.println("Has de seleccionar un jugador que estigui jugant!");
                        }
                        else{
                            System.out.println("Quina és la gravetat de la falta (0 groga, 1 vermella)");
                            arbitre.treureTarjeta(partit.getLocal().getJugadors().get(jugadorSeleccionat - 1), ControladorsErrors.llegirEnter(0, 1));
                        }
                    }
                    case 3 -> {
                        System.out.println("Quin jugador visitant ha fet la falta?");
                        Eines.imprirArrayList(partit.getVisitant().getJugadors());
                        jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getVisitant().getJugadors().size());
                        if(!partit.getVisitant().getJugadors().get(jugadorSeleccionat -1).isJugant()){
                            System.out.println("Has de seleccionar un jugador que estigui jugant!");
                        }
                        else{
                            System.out.println("Quina és la gravetat de la falta (0 groga, 1 vermella)");
                            arbitre.treureTarjeta(partit.getVisitant().getJugadors().get(jugadorSeleccionat - 1), ControladorsErrors.llegirEnter(0, 1));
                        }                    }
                    case 4 -> {
                        System.out.println("Quin jugador local ha fet gol?");
                        Eines.imprirArrayList(partit.getLocal().getJugadors());
                        jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getLocal().getJugadors().size());
                        if(!partit.getLocal().getJugadors().get(jugadorSeleccionat -1).isJugant()){
                            System.out.println("Has de seleccionar un jugador que estigui jugant!");
                        }
                        else{
                            partit.getLocal().getJugadors().get(jugadorSeleccionat - 1).marcarGol();
                        }
                    }
                    case 5 -> {
                        System.out.println("Quin jugador visitant ha fet gol?");
                        Eines.imprirArrayList(partit.getVisitant().getJugadors());
                        jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getVisitant().getJugadors().size());
                        if(!partit.getVisitant().getJugadors().get(jugadorSeleccionat -1).isJugant()){
                            System.out.println("Has de seleccionar un jugador que estigui jugant!");
                        }
                        else{
                            partit.getVisitant().getJugadors().get(jugadorSeleccionat - 1).marcarGol();
                        }
                    }
                    case 6 -> {
                        do{
                            System.out.println("A quin jugador vols canviar?");
                            Eines.imprirArrayList(partit.getLocal().getJugadors());
                            jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getLocal().getJugadors().size());
                            if(!partit.getLocal().getJugadors().get(jugadorSeleccionat).isJugant()){
                                System.out.println("Has de seleccionar un jugador que estigui al camp!");
                            }
                        }while (partit.getLocal().getJugadors().get(jugadorSeleccionat).isJugant());

                    }
                    case 8 -> {
                        Eines.imprirArrayList(partit.getLocal().getJugadors());
                    }
                    case 9 -> {
                        Eines.imprirArrayList(partit.getVisitant().getJugadors());
                    }
                }

            }while (partit.getMinuts() < Partit.tempsMaxim);
        }
    }

    private static ArrayList<Equip> carregarPoolEquips(){
        ArrayList<Equip> retorn = new ArrayList<>();
        retorn.add(new Equip("Barcelona"));
        retorn.add(new Equip("Madrid"));
        retorn.add(new Equip("Espanyol"));
        retorn.add(new Equip("Betis"));
        retorn.add(new Equip("Atletico de Madrid"));
        retorn.add(new Equip("Athletic"));
        retorn.add(new Equip("Real Sociedad"));
        retorn.add(new Equip("Alaves"));
        retorn.add(new Equip("Almeria"));
        retorn.add(new Equip("Rayo Vallecano"));
        retorn.add(new Equip("Cadiz"));
        retorn.add(new Equip("Chelsea"));
        retorn.add(new Equip("Juventus"));
        retorn.add(new Equip("Arsenal"));
        retorn.add(new Equip("PSG"));

        return retorn;
    }

    private static ArrayList<Jugador> carregarPoolJugadors(){
        int contadorsal = 0;
        ArrayList<Jugador> retorn = new ArrayList<>();
        retorn.add(new Jugador("Juan", "Garcia", true, ++contadorsal, "Porter", equips.get(0)));
        retorn.add(new Jugador("Eric", "Rodriguez", true, ++contadorsal, "Defensa", equips.get(0)));
        retorn.add(new Jugador("John", "Doe", true, ++contadorsal, "Defensa", equips.get(0)));
        retorn.add(new Jugador("Lorem", "Ipsum", true, ++contadorsal, "Defensa", equips.get(0)));
        retorn.add(new Jugador("Aaron", "Garcia", true, ++contadorsal, "Defensa", equips.get(0)));
        retorn.add(new Jugador("Manolo", "Perez", true, ++contadorsal, "Migcampista", equips.get(0)));
        retorn.add(new Jugador("Victor", "Lorca", true, ++contadorsal, "Migcampista", equips.get(0)));
        retorn.add(new Jugador("Federico", "Garcia", true, ++contadorsal, "Migcampista", equips.get(0)));
        retorn.add(new Jugador("Xavier", "Gomez", true, ++contadorsal, "Davanter", equips.get(0)));
        retorn.add(new Jugador("Sergi", "Cruz", true, ++contadorsal, "Davanter", equips.get(0)));
        retorn.add(new Jugador("Miquel", "Lopez", true, ++contadorsal, "Davanter", equips.get(0)));
        retorn.add(new Jugador("Bruno", "Perez", false, ++contadorsal, "Porter", equips.get(0)));
        retorn.add(new Jugador("Luis", "Bueno", false, ++contadorsal, "Defensa", equips.get(0)));
        retorn.add(new Jugador("Antonio", "Se", false, ++contadorsal, "Defensa", equips.get(0)));
        retorn.add(new Jugador("Ramon", "Llull", false, ++contadorsal, "Migcampista", equips.get(0)));
        retorn.add(new Jugador("Sergio", "Garcia", false, ++contadorsal, "Davanter", equips.get(0)));
        retorn.add(new Jugador("Juan", "Diaz", false, ++contadorsal, "Davanter", equips.get(0)));
        retorn.add(new Jugador("Antonio", "Diaz", false, ++contadorsal, "Davanter", equips.get(0)));
        contadorsal = 0;
        retorn.add(new Jugador("Juan", "Perez", true, ++contadorsal, "Porter", equips.get(1)));
        retorn.add(new Jugador("Kevin", "Rodriguez", true, ++contadorsal, "Defensa", equips.get(1)));
        retorn.add(new Jugador("John", "Lorca", true, ++contadorsal, "Defensa", equips.get(1)));
        retorn.add(new Jugador("Antonio", "Ipsum", true, ++contadorsal, "Defensa", equips.get(1)));
        retorn.add(new Jugador("Aaron", "Perez", true, ++contadorsal, "Defensa", equips.get(1)));
        retorn.add(new Jugador("Victor", "Perez", true, ++contadorsal, "Migcampista", equips.get(1)));
        retorn.add(new Jugador("Victor", "Hernandez", true, ++contadorsal, "Migcampista", equips.get(1)));
        retorn.add(new Jugador("Andres", "Garcia", true, ++contadorsal, "Migcampista", equips.get(1)));
        retorn.add(new Jugador("Xavier", "Escobar", true, ++contadorsal, "Davanter", equips.get(1)));
        retorn.add(new Jugador("Pablo", "Cruz", true, ++contadorsal, "Davanter", equips.get(1)));
        retorn.add(new Jugador("Miquel", "Williams", true, ++contadorsal, "Davanter", equips.get(1)));
        retorn.add(new Jugador("Iñaki", "Perez", false, ++contadorsal, "Porter", equips.get(1)));
        retorn.add(new Jugador("Luis", "Cruz", false, ++contadorsal, "Defensa", equips.get(1)));
        retorn.add(new Jugador("Yeray", "Se", false, ++contadorsal, "Defensa", equips.get(1)));
        retorn.add(new Jugador("Ramon", "Zurriaga", false, ++contadorsal, "Migcampista", equips.get(1)));
        retorn.add(new Jugador("Ramon", "Hernandez", false, ++contadorsal, "Migcampista", equips.get(1)));
        retorn.add(new Jugador("Pedro", "Aguado", false, ++contadorsal, "Davanter", equips.get(1)));
        retorn.add(new Jugador("Mohammed", "Franco", false, ++contadorsal, "Davanter", equips.get(1)));

        return retorn;
    }

    private static ArrayList<Entrenador> carregarPoolEntrenadors(){
        ArrayList<Entrenador> retorn = new ArrayList<>();
        retorn.add(new Entrenador("Miguel", "Bose", equips.get(0)));
        retorn.add(new Entrenador("Joan","Martinez", equips.get(1)));

        return retorn;
    }
}
