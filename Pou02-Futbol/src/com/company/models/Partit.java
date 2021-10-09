package com.company.models;

import java.util.ArrayList;

public class Partit {
    public static int tempsMaxim = 90;
    private final Equip local;
    private final Equip visitant;
    private final ArrayList<Arbitre> arbitres = new ArrayList<>();
    private int minuts;

    public Partit(Equip local, Equip visitant) {
        this.local = local;
        this.visitant = visitant;
    }

    public void passarTemps(){
        this.minuts += 15;
        System.out.println("MINUT " + this.minuts + ": " + this.local.getGols() + " - " + this.visitant.getGols());
        if(this.minuts == tempsMaxim){
            this.acabar();
        }
    }

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

    public Equip getLocal() {
        return local;
    }

    public Equip getVisitant() {
        return visitant;
    }

    public ArrayList<Arbitre> getArbitres() {
        return arbitres;
    }

    public int getMinuts() {
        return minuts;
    }

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
