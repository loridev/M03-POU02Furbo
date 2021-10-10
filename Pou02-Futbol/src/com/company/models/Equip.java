package com.company.models;

import java.util.ArrayList;

/**
 * Classe que simula un Equip a un Partit de futbol
 */
public class Equip {
    private final String nom;
    private int gols;
    private final ArrayList<Jugador> jugadors = new ArrayList<>();
    private int faltes;
    private Entrenador entrenador;

    /**
     * Mètode constructor d'un Equip
     *
     * @param nom Nom de l'Equip
     */
    public Equip(String nom) {
        this.nom = nom;
    }

    /**
     * Mètode que compta quan un Jugador de l'Equip marca un gol
     */
    public void contarGol(){
        this.gols++;
    }

    /**
     * Mètode que compta quan un Jugador de l'Equip fa falta
     */
    public void contarFalta(){
        this.faltes++;
    }

    /**
     * Mètode getter del nom
     *
     * @return Nom de l'Equip
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mètode getter dels gols
     *
     * @return Gols de l'Equip
     */
    public int getGols() {
        return gols;
    }

    /**
     * Mètode getter de l'Entrenador
     *
     * @return Entrenador de l'Equip
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Mètode getter dels Jugadors
     *
     * @return Jugadors de l'Equip
     */
    public ArrayList<Jugador> getJugadors() {
        return this.jugadors;
    }

    /**
     * Mètode getter de les faltes
     *
     * @return Faltes totals de l'Equip
     */
    public int getFaltes() {
        return faltes;
    }

    /**
     * Mètode setter de l'Entrenador
     *
     * @param entrenador Nou Entrenador de l'Equip
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Comprova si un Equip pot jugar un Partit
     *
     * @return Si pot o no jugar
     */
    public boolean comprovarRequeriments(){
        ArrayList<Jugador> titulars = new ArrayList<>();
        if (this.jugadors.size() == 18){
            jugadors.forEach(jugador -> {
                if (jugador.isJugant()){
                    titulars.add(jugador);
                }
            });
            if (titulars.size() == 11){
                return this.entrenador != null;
            }
        }
        return false;
    }

    /**
     * Mètode override toString d'un Equip
     *
     * @return Informació d'un Equip
     */
    @Override
    public String toString() {
        return "Equip{" +
                "nom='" + nom + '\'' +
                ", gols=" + gols +
                ", JUGADORS=" + jugadors +
                ", numFaltes=" + faltes +
                '}';
    }
}
