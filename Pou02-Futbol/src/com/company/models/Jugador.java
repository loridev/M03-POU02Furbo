package com.company.models;

/**
 * Classe que simula un Jugador a un Partit de futbol
 */
public class Jugador {
    private final String nom;
    private final String cognom;
    private int golsMarcats;
    private boolean groga;
    private boolean expulsat;
    private boolean jugant;
    private final int dorsal;
    private String posicio;
    private final Equip equip;

    /**
     * Mètode constructor d'un Jugaodr
     *
     * @param nom Nom del Jugador
     * @param cognom Cognom del Jugador
     * @param jugant Si està o no jugant
     * @param dorsal Dorsal del Jugador
     * @param posicio Posició del Jugador
     * @param equip Equip en el que juga el Jugador
     */
    public Jugador(String nom, String cognom, boolean jugant, int dorsal, String posicio, Equip equip) {
        this.nom = nom;
        this.cognom = cognom;
        this.jugant = jugant;
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.equip = equip;

        equip.getJugadors().add(this);
    }

    /**
     * Mètode que controla quan un Jugador marca gol
     */
    public void marcarGol(){
        this.golsMarcats++;
        System.out.println("Gol de "+this.nom + " " + this.cognom);
        this.equip.contarGol();
    }

    /**
     * Controla que implica per a un Jugador que un Arbitre li tregui la targeta.
     * Aquest mètode s'ha fet per simplificar l'accès als atributs del Jugador
     *
     * @param gravetat Gravetat de la falta (0 groga | 1 vermella)
     */
    public void rebreTargeta(int gravetat){
        this.equip.contarFalta();
        if(this.groga){
            System.out.println("El jugador " + this.nom + " " + this.cognom + " ha sigut expulsat");
            this.expulsat = true;
            this.jugant = false;
        }
        else{
            if(gravetat == 0){
                this.groga = true;
            }
            else{
                System.out.println("El jugador " + this.nom + " " + this.cognom + " ha sigut expulsat");
                this.expulsat = true;
                this.jugant = false;
            }

        }
    }

    /**
     * Mètode getter de si esta al camp
     *
     * @return Si el jugador és al camp o no
     */
    public boolean isJugant() {
        return jugant;
    }

    /**
     * Mètode getter de si esta expulsat
     *
     * @return Si el jugador està expulsat o no
     */
    public boolean isExpulsat() {
        return expulsat;
    }

    /**
     * Mètode getter del nom
     *
     * @return Nom del Jugador
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mètode getter del cognom
     *
     * @return Cognom del Jugador
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Mètode setter de si un jugador és al camp o no
     *
     * @param jugant Nou valor
     */
    public void setJugant(boolean jugant) {
        this.jugant = jugant;
    }

    /**
     * Mètode getter de la posició
     *
     * @return Posició del Jugador
     */
    public String getPosicio() {
        return this.posicio;
    }

    /**
     * Mètode setter de la posició
     *
     * @param posicio Nova posició del Jugador
     */
    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }

    /**
     * Mètode override toString d'un Jugador
     *
     * @return Dades del Jugador
     */
    @Override
    public String toString() {
        return "Jugador{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", golsMarcats=" + golsMarcats +
                ", groga=" + groga +
                ", expulsat=" + expulsat +
                ", jugant=" + jugant +
                ", dorsal=" + dorsal +
                ", posicio='" + posicio + '\'' +
                ", equip=" + equip.getNom() +
                '}';
    }
}
