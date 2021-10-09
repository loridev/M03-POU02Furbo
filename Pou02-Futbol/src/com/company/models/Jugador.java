package com.company.models;

public class Jugador {
    private final String nom;
    private final String cognom;
    private int golsMarcats;
    private boolean groga;
    private boolean expulsat;
    private boolean jugant;
    private final int dorsal;
    private String posicio;
    private Equip equip;

    public Jugador(String nom, String cognom, boolean jugant, int dorsal, String posicio, Equip equip) {
        this.nom = nom;
        this.cognom = cognom;
        this.jugant = jugant;
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.equip = equip;

        equip.getJugadors().add(this);
    }

    public void marcarGol(){
        this.golsMarcats++;
        System.out.println("Gol de "+this.nom + " " + this.cognom);
        this.equip.contarGol();
    }

    public void rebreTargeta(int gravetat){
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

    public Equip getEquip() {
        return equip;
    }

    public boolean isJugant() {
        return jugant;
    }

    public String getNom() {
        return nom;
    }

    public void setJugant(boolean jugant) {
        this.jugant = jugant;
    }

    public String getPosicio() {
        return this.posicio;
    }

    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }

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
