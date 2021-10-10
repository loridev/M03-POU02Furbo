package com.company.models;

import java.util.ArrayList;

/**
 * Classe que simula un Partit de futbol
 */
public class Partit {
    /**
     * Atribut estàtic que controla el temps màxim d'un partit, es modificarà fins a 120 si s'arriba a aquest valor amb
     * un empat
     */
    public static int tempsMaxim = 90;
    private final Equip local;
    private final Equip visitant;
    private final ArrayList<Arbitre> arbitres = new ArrayList<>();
    private int minuts;

    /**
     * Mètode constructor d'un Partit
     *
     * @param local Equip local del Partit
     * @param visitant Equip visitant del partit
     */
    public Partit(Equip local, Equip visitant) {
        this.local = local;
        this.visitant = visitant;
    }

    /**
     * Mètode que controla el pas del temps a un partit
     */
    public void passarTemps(){
        this.minuts += 15;
        System.out.println("MINUT " + this.minuts + ": " + this.local.getGols() + " - " + this.visitant.getGols());
        if(this.minuts == tempsMaxim){
            this.acabar();
        }
    }

    /**
     * Mètode que comprova si els dos Equips poden jugar un Partit i l'inicia
     *
     * @return Si els 2 Equips compleixen els requeriments per jugar un Partit
     */
    public boolean iniciar(){
        tempsMaxim = 90;
        if(!this.local.comprovarRequeriments() || !this.visitant.comprovarRequeriments()){
            System.out.println("Un dels dos equips no compleix els requeriments per jugar un partit!");
            return false;
        }
        else{
            System.out.println("MINUT 0: 0 - 0");
            return true;
        }
    }

    /**
     * Mètode que comprova si no hi ha un empat al minut 90 i, si n'hi ha un, crida per fer pròrroga.
     * Si segueixen en empat després de la pròrroga, acabarà el partit igualment.
     * Quan s'acaba un partit es mostra el resultat final i les faltes de cada equip
     */
    private void acabar(){
        if ((this.local.getGols() != this.visitant.getGols()) || tempsMaxim == 120) {
            System.out.println("El partit ha acabat! \n" +
                    "Resultat: " + this.local.getNom() + " " + this.local.getGols() + " - " +
                    this.visitant.getGols() + " " + this.visitant.getNom() + "\n" +
                    "Faltes: " + this.local.getNom() + " " + this.local.getFaltes() + " - " +
                    this.visitant.getFaltes() + " " + this.visitant.getNom());
        }
        else{
            if(tempsMaxim == 90){
                System.out.println("PRORROGA");
            }
            tempsMaxim = 120;
        }

    }

    /**
     * Mètode getter de l'Equip local
     *
     * @return Equip local del Partit
     */
    public Equip getLocal() {
        return local;
    }

    /**
     * Mètode getter de l'Equip visitant
     *
     * @return Equip visitant del Partit
     */
    public Equip getVisitant() {
        return visitant;
    }

    /**
     * Mètode getter dels Arbitres d'un Partit
     *
     * @return Arbitres del Partit
     */
    public ArrayList<Arbitre> getArbitres() {
        return arbitres;
    }

    /**
     * Mètode getter dels minuts d'un Partit
     *
     * @return Minuts del Partit
     */
    public int getMinuts() {
        return minuts;
    }

    /**
     * Mètode override toString d'un Partit
     *
     * @return Dades d'un Partit
     */
    @Override
    public String toString() {
        return "Partit{" +
                ", local=" + local +
                ", visitant=" + visitant +
                ", arbitres=" + arbitres +
                ", minuts=" + minuts +
                '}';
    }
}
