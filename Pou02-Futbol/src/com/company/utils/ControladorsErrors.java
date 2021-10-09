package com.company.utils;

import java.util.Scanner;

public class ControladorsErrors {
    public static int llegirEnter(int min, int max){
        Scanner llegir = new Scanner(System.in);
        int retorn = 0;
        boolean valorCorrecte;

        do{
            valorCorrecte = llegir.hasNextInt();

            if (!valorCorrecte){
                System.out.println("ERROR: No has escrit un enter.");
                llegir.nextLine();
            }else {
                retorn = llegir.nextInt();
                llegir.nextLine();

                if (retorn < min || retorn > max){
                    System.out.println("ERROR: Valor fora de rang.");
                    valorCorrecte = false;
                }
            }
        }while (!valorCorrecte);

        return retorn;
    }
}
