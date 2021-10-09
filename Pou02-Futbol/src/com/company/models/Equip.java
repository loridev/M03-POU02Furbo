package com.company.models;

import java.util.ArrayList;

public class Equip {
    private final String nom;
    private int gols;
    private final ArrayList<Jugador> jugadors = new ArrayList<>();
    private int numFaltes;
    private Entrenador entrenador;

    public Equip(String nom) {
        this.nom = nom;
    }

    public void contarGol(){
        this.gols++;
    }

    public void contarFalta(){
        this.numFaltes++;
    }

    public String getNom() {
        return nom;
    }

    public int getGols() {
        return gols;
    }

    public ArrayList<Jugador> getJugadors() {
        return this.jugadors;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public boolean comprovarRequeriments(){
        ArrayList<Jugador> titulars = new ArrayList<>();
        if (this.jugadors.size() == 18){
            jugadors.forEach(jugador -> {
                if (jugador.isJugant()){
                    titulars.add(jugador);
                }
            });
            if (titulars.size() == 11){
                if (this.entrenador != null){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Equip{" +
                "nom='" + nom + '\'' +
                ", gols=" + gols +
                ", JUGADORS=" + jugadors +
                ", numFaltes=" + numFaltes +
                '}';
    }
}
