package com.company.utils;

import java.util.Scanner;

/**
 * Classe estàtica de controladors d'errors
 */
public class ControladorsErrors {
    /**
     * Mètode que llegeix un input de l'usuari i s'assegura que és enter i es troba a un rang
     *
     * @param min Número vàlid mínim
     * @param max Número vàlid màxim
     * @return Número enter vàlid dins el rang especificat
     */
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
