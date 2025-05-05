package org.example;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int nombre = 33;
//        if(estDivisibleParTrois(nombre)) {
//            System.out.println("Le nombre est divisible par 3");
//        }
//        else {
//            System.out.println("Le nombre n'est par divisible par 3");
//        }
//        *
        //Programme OK
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " => " + transformer(i));
        }
    }

    //methode pour tester si un nombre est disible par 3
    static boolean estDivisibleParTrois(int nombre) {
        return nombre % 3 == 0;
    }
    static boolean estDivisibleParCinq(int nombre) {
        return nombre % 5 == 0;
    }

    private static int[] extraireChifres (int nombre) {
        String nombreStr = Integer.toString(Math.abs(nombre)); // Prend en compte les nombres négatifs
        int[] chiffres = new int[nombreStr.length()];
        for (int i = 0; i < nombreStr.length(); i++) {
            chiffres[i] = Character.getNumericValue(nombreStr.charAt(i));

            if ((i>0 && chiffres[i-1] != chiffres[i]) && (chiffres[i] == 3 ||  chiffres[i] ==5)) {
                int prec = chiffres[i-1];
                int courant =chiffres[i];
                chiffres[i] = prec;
                chiffres[i-1] = courant;
                chiffres[i-1] = courant;
            }

        }
        return chiffres;
    }


    public static String transformer(int nombre) {
        if (nombre < 0 || nombre > 100) {
            throw new IllegalArgumentException("Le nombre doit être compris entre 0 et 100.");
        }

        StringBuilder result = new StringBuilder();

        // Règle "divisible par" (prioritaire)
        if (nombre % 3 == 0) result.append("FOO");
        if (nombre % 5 == 0) result.append("BAR");

        // Règle "contient", appliquée uniquement si pas déjà prise en compte par "divisible par"
//        if (result.length() == 0) {
//            String strNombre = String.valueOf(nombre);
//            for (char c : strNombre.toCharArray()) {
//                if (c == '3') result.append("FOO");
//                else if (c == '5') result.append("BAR");
//                else if (c == '7') result.append("QUIX");
//            }
//        }
// Règle "contient 3, 5 ou 7"
            String strNombre = String.valueOf(nombre);
            for (char c : strNombre.toCharArray()) {
                if (c == '3') result.append("FOO");
                else if (c == '5') result.append("BAR");
                else if (c == '7') result.append("QUIX");
            }


        //---- Si aucune règle ne s'applique, retourner le nombre
        return result.length() > 0 ? result.toString() : String.valueOf(nombre);
    }


}