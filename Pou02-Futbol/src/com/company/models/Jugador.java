package com.company.models;

public class Jugador {
    private String nom;
    private String cognom;
    private int golsMarcats;
    private boolean groga;
    private boolean expulsat;
    private boolean jugant;
    private int dorsal;
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
        this.equip.contarGol();
    }

    public void rebreTargeta(String color){
        if(this.groga){
            this.expulsat = true;
        }
        else{
            if(color.equals("groga")){
                this.groga = true;
            }
            else{
                this.expulsat = true;
            }

        }
    }

    public Equip getEquip() {
        return equip;
    }

    public void setJugant(boolean jugant) {
        this.jugant = jugant;
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
