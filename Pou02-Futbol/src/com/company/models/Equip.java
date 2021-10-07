package com.company.models;

import java.util.ArrayList;

public class Equip {
    private String nom;
    private int gols;
    private final ArrayList<Jugador> JUGADORS = new ArrayList<>();
    private int numFaltes;

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

    public ArrayList<Jugador> getJugadors() {
        return this.JUGADORS;
    }

    @Override
    public String toString() {
        return "Equip{" +
                "nom='" + nom + '\'' +
                ", gols=" + gols +
                ", JUGADORS=" + JUGADORS +
                ", numFaltes=" + numFaltes +
                '}';
    }
}
