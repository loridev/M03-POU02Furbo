package com.company;

import com.company.models.Equip;
import com.company.models.Jugador;
import com.company.utils.ControladorsErrors;

public class Main {

    public static void main(String[] args) {
        Equip realBetisBalompie = new Equip("Betis");
        System.out.println(new Jugador("Beimar","Torrez",false,21,"DFC",realBetisBalompie));
    }
}
