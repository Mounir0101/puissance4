package com.codingf.puissance;
import com.codingf.puissance.modeles.Grille;

import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean replay = true;

        while (replay) {

            System.out.println("1- Jouer tout seul");
            System.out.println("2- Jouer à deux ");
            System.out.println("3- Afficher le Top 10");
            System.out.println("4- Quittez la Partie");
            System.out.println( "Que voulez vous faire ? ");
            String reponseInput = input.next();

            Grille grille = new Grille();

            switch (reponseInput) {
                case "1" :
                    System.out.println("Vous allez jouer seul");
                    grille.affichageGrille();
                    break;
                case "2" :
                    System.out.println("Vous jouez à 2");
                    grille.affichageGrille();
                    break;
                case "3":
                    System.out.println("Voici le top 10");
                    break;
                case "4" :
                    System.out.println("Salut");
                    System.exit(1);
            }

        }

        //Grille grille = new Grille();

        //grille.affichageGrille();

    }

}
