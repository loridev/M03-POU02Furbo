package com.company.utils;

import java.util.ArrayList;

/**
 * Classe estàtica amb eines que simplificaran tasques recurrents al codi
 */
public class Eines {
    /**
     * Mètode que imprimeix una ArrayList amb un número des del 1 (posició + 1)
     *
     * @param arraylist ArrayList que es vol imprimir
     */
    public static void imprirArrayList(ArrayList arraylist){
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(i+1 + " - " + arraylist.get(i));
        }
    }
}
