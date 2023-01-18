package com.codingf.puissance;

import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.fileactions.ReadFile;
import com.codingf.puissance.games.JeuA2;
import com.codingf.puissance.games.JeuSeul;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean replay = true;

        Cases[][] casesList = new Cases[6][7];

        while (replay) {

            System.out.println("1- Jouer tout seul");
            System.out.println("2- Jouer à deux ");
            System.out.println("3- Afficher le Top 10");
            System.out.println("4- Quittez la Partie");
            System.out.println( "Que voulez vous faire ? ");
            String reponseInput = input.next();

            switch (reponseInput) {

                case "1":

                    JeuSeul.singlePlayer(casesList);

                    break;

                case "2":

                    JeuA2.twoPlayers(casesList);

                    break;

                case "3":

                    ReadFile.readTop10();
                    System.out.println();

                    break;

                case "4":
                    System.out.println("Salut");
                    System.exit(0);

                default:
                    System.out.println("Veuillez sélectionner une option valide");
            }

        }

    }

}
