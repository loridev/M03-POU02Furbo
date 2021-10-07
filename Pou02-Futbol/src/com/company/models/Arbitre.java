package com.company.models;

public class Arbitre {
    private String nom;
    private String cognom;
    private String tipusArbitre;

    public Arbitre(String nom, String cognom, String tipusArbitre) {
        this.nom = nom;
        this.cognom = cognom;
        this.tipusArbitre = tipusArbitre;
    }

    public void treureTarjeta(Jugador jugadorSancionat, String color){
        jugadorSancionat.rebreTargeta(color);
    }

    @Override
    public String toString() {
        return "Arbitre{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", tipusArbitre='" + tipusArbitre + '\'' +
                '}';
    }
}
