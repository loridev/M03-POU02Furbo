package com.company.utils;

import java.util.ArrayList;

public class Eines {
    public static void imprirArrayList(ArrayList arraylist){
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(i+1 + " - " + arraylist.get(i));
        }
    }
}
