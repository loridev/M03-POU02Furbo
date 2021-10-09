package com.company.models;

public class Entrenador {
    private final String nom;
    private final String cognom;
    private Equip equip;

    public Entrenador(String nom, String cognom, Equip equip) {
        this.nom = nom;
        this.cognom = cognom;
        this.equip = equip;
        this.equip.setEntrenador(this);
    }

    public void canviarJugador(Jugador entrada, Jugador sortida){
        if (this.equip.getJugadors().contains(entrada) && this.equip.getJugadors().contains(sortida)){
            entrada.setJugant(true);
            sortida.setJugant(false);

            entrada.setPosicio(sortida.getPosicio());
        }
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", equip=" + equip +
                '}';
    }
}
