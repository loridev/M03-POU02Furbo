package com.company.models;

/**
 * Classe que representa un Entrenador d'un equip
 */
public class Entrenador {
    private final String nom;
    private final String cognom;
    private final Equip equip;

    /**
     * Mètode constructor d'un Entrenador
     *
     * @param nom Nom de l'Entrenador
     * @param cognom Cognom de l'Entrenador
     * @param equip Equip que entrena l'Entrenador
     */
    public Entrenador(String nom, String cognom, Equip equip) {
        this.nom = nom;
        this.cognom = cognom;
        this.equip = equip;
        this.equip.setEntrenador(this);
    }

    /**
     * Mètode que controla la substitució d'un Jugador per part de l'Entrenador
     *
     * @param sortida Jugador que surt del camp
     * @param entrada Jugador que entra al camp
     */
    public void canviarJugador(Jugador sortida, Jugador entrada){
        if (this.equip.getJugadors().contains(entrada) && this.equip.getJugadors().contains(sortida)){
            entrada.setJugant(true);
            sortida.setJugant(false);

            entrada.setPosicio(sortida.getPosicio());

            System.out.println("S'ha canviar al jugador " + sortida.getNom() + " " + sortida.getCognom()
            + " pel jugador " + entrada.getNom() + " " + entrada.getCognom());
        }
    }


    /**
     * Mètode override toString d'un Entrenador
     *
     * @return Dades d'un Entrenador
     */
    @Override
    public String toString() {
        return "Entrenador{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", equip=" + equip +
                '}';
    }
}
