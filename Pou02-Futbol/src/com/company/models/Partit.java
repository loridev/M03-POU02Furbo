package com.company.models;

import java.util.ArrayList;

public class Partit {
    private String resultat;
    private Equip local;
    private Equip visitant;
    private final ArrayList<Arbitre> ARBITRES = new ArrayList<>();
    private int minuts;

    public void passarTemps(){
        this.minuts += 15;
    }

    public void canviJugador(Jugador entrada, Jugador sortida){
        if(entrada.getEquip() != sortida.getEquip()){
            System.out.println("No pots canviar dos jugadors de diferent equip!!!!!!!!!!!!");
        }
        else{
            entrada.setJugant(false);
            sortida.setJugant(true);
        }
    }

    public void faltaSancionada(Jugador jugador, int gravetat, Arbitre arbitePrincipal){
        if(gravetat == 0){
            arbitePrincipal.treureTarjeta(jugador, "groga");
        }
        else{
            arbitePrincipal.treureTarjeta(jugador, "vermella");
        }
    }

    public void iniciar(){

    }
    public void acabar(){

    }

    @Override
    public String toString() {
        return "Partit{" +
                "resultat='" + resultat + '\'' +
                ", local=" + local +
                ", visitant=" + visitant +
                ", ARBITRES=" + ARBITRES +
                ", minuts=" + minuts +
                '}';
    }
}
