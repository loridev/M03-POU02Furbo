package com.company.models;

/**
 * Classe que simula un Arbitre a un partit de futbol
 */
public class Arbitre {
    private String nom;
    private String cognom;
    private String tipusArbitre;
    private Partit partitArbitrat;

    /**
     * Mètode constructor d'un Arbitre
     *
     * @param nom Nom de l'Arbitre
     * @param cognom Cognom de l'Arbitre
     * @param tipusArbitre Tipus d'Arbitre (principal, línia, etc.)
     * @param partit Partit que arbitra
     */
    public Arbitre(String nom, String cognom, String tipusArbitre, Partit partit) {
        this.nom = nom;
        this.cognom = cognom;
        this.tipusArbitre = tipusArbitre;
        this.partitArbitrat = partit;
        this.partitArbitrat.getArbitres().add(this);
    }

    /**
     * Mètode que controla quan un Arbitre treu una targeta
     *
     * @param jugadorSancionat Jugador que ha fet la falta
     * @param gravetat Si es treurà targeta groga (0) o vermella (1)
     */
    public void treureTargeta(Jugador jugadorSancionat, int gravetat){
        jugadorSancionat.rebreTargeta(gravetat);
    }

    /**
     * Mètode override toString d'un Arbitre
     *
     * @return Dades d'un Arbitre
     */
    @Override
    public String toString() {
        return "Arbitre{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", tipusArbitre='" + tipusArbitre + '\'' +
                '}';
    }
}
