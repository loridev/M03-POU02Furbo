/*
    HOLA RAIMON, ELS JAVADOCS ESTAN A LA CARPETA DOCS DE L'ARREL DEL PROJECTE, PERO SI ELS VOLS GENERAR I QUE ELS
    ACCENTS ES VEUIN CORRECTAMENT, ESCRIU EL SEGÜENT A "other command line arguments:" A LA FINESTRA ON ES GENERA
    LA DOCUMENTACIÓ: -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
 */



package com.company;

import com.company.models.*;
import com.company.utils.ControladorsErrors;
import com.company.utils.Eines;

import java.util.ArrayList;

/**
 * Classe executable del programa
 */
public class Main {
    static ArrayList<Equip> equips = carregarPoolEquips();

    /**
     * Mètode que controla el que s'executarà quan s'executi el programa
     *
     * @param args El codi a executar
     */
    public static void main(String[] args) {
        int menu;
        int jugadorSeleccionat;
        carregarPoolJugadors();
        carregarPoolEntrenadors();
        Partit partit = new Partit(equips.get(0), equips.get(1));
        Arbitre arbitre = new Arbitre("Marc","Martinez","Principal", partit);
        if (partit.iniciar()){
            do{

                System.out.println("""
                        Que vols fer?
                        1. Avançar 15 minuts\s
                        2. Falta d'un jugador local\s
                        3. Falta d'un jugador visitant\s
                        4. Gol d'un jugador local\s
                        5. Gol d'un jugador visitant\s
                        6. Canviar jugador local\s
                        7. Canviar jugador visitant\s
                        8. Veure jugadors equip local\s
                        9. Veure jugadors equip visitant""");

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
                            arbitre.treureTargeta(partit.getLocal().getJugadors().get(jugadorSeleccionat - 1), ControladorsErrors.llegirEnter(0, 1));
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
                            arbitre.treureTargeta(partit.getVisitant().getJugadors().get(jugadorSeleccionat - 1), ControladorsErrors.llegirEnter(0, 1));
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
                        int jugadorEntrant;
                        do{
                            System.out.println("A quin jugador vols canviar?");
                            Eines.imprirArrayList(partit.getLocal().getJugadors());
                            jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getLocal().getJugadors().size());
                            if(!partit.getLocal().getJugadors().get(jugadorSeleccionat-1).isJugant()){
                                System.out.println("Has de seleccionar un jugador que estigui al camp!");
                            }
                        }while (!partit.getLocal().getJugadors().get(jugadorSeleccionat-1).isJugant());

                        do{
                            System.out.println("Per quin jugador el vols canviar?");
                            jugadorEntrant = ControladorsErrors.llegirEnter(1, partit.getLocal().getJugadors().size());
                            if(partit.getLocal().getJugadors().get(jugadorEntrant-1).isJugant()){
                                System.out.println("Has de seleccionar un jugador que no estigui al camp!");
                            }
                        }while (partit.getLocal().getJugadors().get(jugadorEntrant-1).isJugant());

                        partit.getLocal().getEntrenador().canviarJugador(partit.getLocal().getJugadors().get(jugadorSeleccionat-1), partit.getLocal().getJugadors().get(jugadorEntrant-1));

                    }
                    case 7 -> {
                        int jugadorEntrant;
                        do{
                            System.out.println("A quin jugador vols canviar?");
                            Eines.imprirArrayList(partit.getVisitant().getJugadors());
                            jugadorSeleccionat = ControladorsErrors.llegirEnter(1, partit.getVisitant().getJugadors().size());
                            if(!partit.getVisitant().getJugadors().get(jugadorSeleccionat-1).isJugant()){
                                System.out.println("Has de seleccionar un jugador que estigui al camp!");
                            }
                        }while (!partit.getVisitant().getJugadors().get(jugadorSeleccionat-1).isJugant());

                        do{
                            System.out.println("Per quin jugador el vols canviar?");
                            jugadorEntrant = ControladorsErrors.llegirEnter(1, partit.getLocal().getJugadors().size());
                            if(partit.getVisitant().getJugadors().get(jugadorEntrant-1).isJugant() || partit.getVisitant().getJugadors().get(jugadorEntrant-1).isExpulsat()){
                                System.out.println("Has de seleccionar un jugador que no estigui al camp i no estigui expulsat!");
                            }
                        }while (partit.getVisitant().getJugadors().get(jugadorEntrant-1).isJugant() || partit.getVisitant().getJugadors().get(jugadorEntrant-1).isExpulsat());

                        partit.getVisitant().getEntrenador().canviarJugador(partit.getVisitant().getJugadors().get(jugadorSeleccionat-1),
                                partit.getVisitant().getJugadors().get(jugadorEntrant-1));

                    }
                    case 8 -> Eines.imprirArrayList(partit.getLocal().getJugadors());
                    case 9 -> Eines.imprirArrayList(partit.getVisitant().getJugadors());
                }

            }while (partit.getMinuts() < Partit.tempsMaxim);
        }
    }

    /**
     * Mètode que s'encarrega de carregar Equips a memòria per usar-los al programa
     *
     * @return ArrayList d'Equips ple amb els objectes de dins el mètode.
     */
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

    /**
     * Mètode que carrega objectes Jugador als Equips
     */
    private static void carregarPoolJugadors(){
        int contadorsal = 0;
        ArrayList<Jugador> afegirJugadors = new ArrayList<>();
        afegirJugadors.add(new Jugador("Juan", "Garcia", true, ++contadorsal, "Porter", equips.get(0)));
        afegirJugadors.add(new Jugador("Eric", "Rodriguez", true, ++contadorsal, "Defensa", equips.get(0)));
        afegirJugadors.add(new Jugador("John", "Doe", true, ++contadorsal, "Defensa", equips.get(0)));
        afegirJugadors.add(new Jugador("Lorem", "Ipsum", true, ++contadorsal, "Defensa", equips.get(0)));
        afegirJugadors.add(new Jugador("Aaron", "Garcia", true, ++contadorsal, "Defensa", equips.get(0)));
        afegirJugadors.add(new Jugador("Manolo", "Perez", true, ++contadorsal, "Migcampista", equips.get(0)));
        afegirJugadors.add(new Jugador("Victor", "Lorca", true, ++contadorsal, "Migcampista", equips.get(0)));
        afegirJugadors.add(new Jugador("Federico", "Garcia", true, ++contadorsal, "Migcampista", equips.get(0)));
        afegirJugadors.add(new Jugador("Xavier", "Gomez", true, ++contadorsal, "Davanter", equips.get(0)));
        afegirJugadors.add(new Jugador("Sergi", "Cruz", true, ++contadorsal, "Davanter", equips.get(0)));
        afegirJugadors.add(new Jugador("Miquel", "Lopez", true, ++contadorsal, "Davanter", equips.get(0)));
        afegirJugadors.add(new Jugador("Bruno", "Perez", false, ++contadorsal, "Porter", equips.get(0)));
        afegirJugadors.add(new Jugador("Luis", "Bueno", false, ++contadorsal, "Defensa", equips.get(0)));
        afegirJugadors.add(new Jugador("Antonio", "Se", false, ++contadorsal, "Defensa", equips.get(0)));
        afegirJugadors.add(new Jugador("Ramon", "Llull", false, ++contadorsal, "Migcampista", equips.get(0)));
        afegirJugadors.add(new Jugador("Sergio", "Garcia", false, ++contadorsal, "Davanter", equips.get(0)));
        afegirJugadors.add(new Jugador("Juan", "Diaz", false, ++contadorsal, "Davanter", equips.get(0)));
        afegirJugadors.add(new Jugador("Antonio", "Diaz", false, ++contadorsal, "Davanter", equips.get(0)));
        contadorsal = 0;
        afegirJugadors.add(new Jugador("Juan", "Perez", true, ++contadorsal, "Porter", equips.get(1)));
        afegirJugadors.add(new Jugador("Kevin", "Rodriguez", true, ++contadorsal, "Defensa", equips.get(1)));
        afegirJugadors.add(new Jugador("John", "Lorca", true, ++contadorsal, "Defensa", equips.get(1)));
        afegirJugadors.add(new Jugador("Antonio", "Ipsum", true, ++contadorsal, "Defensa", equips.get(1)));
        afegirJugadors.add(new Jugador("Aaron", "Perez", true, ++contadorsal, "Defensa", equips.get(1)));
        afegirJugadors.add(new Jugador("Victor", "Perez", true, ++contadorsal, "Migcampista", equips.get(1)));
        afegirJugadors.add(new Jugador("Victor", "Hernandez", true, ++contadorsal, "Migcampista", equips.get(1)));
        afegirJugadors.add(new Jugador("Andres", "Garcia", true, ++contadorsal, "Migcampista", equips.get(1)));
        afegirJugadors.add(new Jugador("Xavier", "Escobar", true, ++contadorsal, "Davanter", equips.get(1)));
        afegirJugadors.add(new Jugador("Pablo", "Cruz", true, ++contadorsal, "Davanter", equips.get(1)));
        afegirJugadors.add(new Jugador("Miquel", "Williams", true, ++contadorsal, "Davanter", equips.get(1)));
        afegirJugadors.add(new Jugador("Iñaki", "Perez", false, ++contadorsal, "Porter", equips.get(1)));
        afegirJugadors.add(new Jugador("Luis", "Cruz", false, ++contadorsal, "Defensa", equips.get(1)));
        afegirJugadors.add(new Jugador("Yeray", "Se", false, ++contadorsal, "Defensa", equips.get(1)));
        afegirJugadors.add(new Jugador("Ramon", "Zurriaga", false, ++contadorsal, "Migcampista", equips.get(1)));
        afegirJugadors.add(new Jugador("Ramon", "Hernandez", false, ++contadorsal, "Migcampista", equips.get(1)));
        afegirJugadors.add(new Jugador("Pedro", "Aguado", false, ++contadorsal, "Davanter", equips.get(1)));
        afegirJugadors.add(new Jugador("Mohammed", "Franco", false, ++contadorsal, "Davanter", equips.get(1)));
    }

    /**
     * Mètode que carrega objectes Entrenador als Equips
     */
    private static void carregarPoolEntrenadors(){
        ArrayList<Entrenador> afegirEntrenadors = new ArrayList<>();
        afegirEntrenadors.add(new Entrenador("Miguel", "Bose", equips.get(0)));
        afegirEntrenadors.add(new Entrenador("Joan","Martinez", equips.get(1)));
    }
}
