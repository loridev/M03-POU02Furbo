package com.company.models;

public class Arbitre {
    private String nom;
    private String cognom;
    private String tipusArbitre;
    private Partit partitArbitrat;

    public Arbitre(String nom, String cognom, String tipusArbitre, Partit partit) {
        this.nom = nom;
        this.cognom = cognom;
        this.tipusArbitre = tipusArbitre;
        this.partitArbitrat = partit;
        this.partitArbitrat.getArbitres().add(this);
    }

    public void treureTarjeta(Jugador jugadorSancionat, int gravetat){
        jugadorSancionat.rebreTargeta(gravetat);
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
