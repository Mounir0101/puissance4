package com.codingf.puissance;
import com.codingf.puissance.modeles.Grille;
import com.codingf.puissance.modeles.Joueur;
import com.codingf.puissance.modeles.Cases;

import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean replay = true;

        Cases[][] casesList = new Cases[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cases square = new Cases(i, j, ' ');
                casesList[i][j] = square;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(casesList[i][j].getSymbol() + "|");
            }
            System.out.println();
        }

        while (replay) {

            System.out.println("1- Jouer tout seul");
            System.out.println("2- Jouer à deux ");
            System.out.println("3- Afficher le Top 10");
            System.out.println("4- Quittez la Partie");
            System.out.println( "Que voulez vous faire ? ");
            String reponseInput = input.next();

            Grille grille = new Grille(casesList);

            switch (reponseInput) {

                case "1":
                    System.out.println("Vous allez jouer seul");
                    grille.affichageGrille();
                    replay = false;
                    boolean game = true ;
                    while (game) {
                        System.out.println("Selectionner une column ");
                        String numColInput = input.next();
                        System.out.println(numColInput);
                        game = false;
                        break;
                    }
                    break;
                case "2":
                    System.out.println("Vous jouez à 2");

                    Scanner players = new Scanner(System.in);
                    System.out.println("Joueur 1, choisissez votre pseudo");
                    String player1Pseudo = players.nextLine();
                    System.out.println("Joueur 1, choisissez votre symbole");
                    char player1Symbol = players.nextLine().charAt(0);
                    System.out.println("Joueur 2, choisissez votre pseudo");
                    String player2Pseudo = players.nextLine();
                    char player2Symbol;

                    while (true) {
                        System.out.println("Joueur 2, choisissez votre symbole");
                        player2Symbol = players.nextLine().charAt(0);
                        if (player2Symbol == player1Symbol) {
                            System.out.println("Les deux joueurs ne peuvent pas avoir le même symbole");
                            continue;
                        } else {
                            break;
                        }
                    }

                    Joueur player1 = new Joueur(player1Pseudo, player1Symbol);
                    Joueur player2 = new Joueur(player2Pseudo, player2Symbol);

                    System.out.println(player1);
                    System.out.println(player2);

                    String currentPlayerPseudo = player1.getPseudo();
                    char currentPlayerSymbol = player1.getSymbol();
                    boolean play = true;

                        while (play) {

                            grille.affichageGrille();

                            int line = 5;

                            System.out.println("Sélectionnez une colonne "+currentPlayerPseudo);
                            String numColInput = input.next();
                            System.out.println(numColInput);

                            int numCol;

                            try {
                                numCol = Integer.parseInt(numColInput)-1;
                                if (numCol < 0 || numCol > 6) {
                                    System.out.println("selectionner une colonne entre 1 et 7");
                                    continue;
                                }

                            }
                            catch (Exception e) {
                                System.err.println("Veuillez entrer un nombre valide");
                                continue;
                            }

                            try {

                                while (casesList[line][numCol].getSymbol() != ' ' ) {
                                    line --;
                                }

                                casesList[line][numCol].setSymbol(currentPlayerSymbol);
                            }
                            catch (ArrayIndexOutOfBoundsException e){
                                System.err.println("choisissez une autre colonne ");
                                continue;
                            }


                            if (currentPlayerPseudo.equals(player1.getPseudo())){
                                currentPlayerPseudo = player2.getPseudo();
                                currentPlayerSymbol = player2.getSymbol();
                            }else {
                                currentPlayerPseudo = player1.getPseudo();
                                currentPlayerSymbol = player1.getSymbol();

                            }

                            //play = false;
                            //break;
                        }

                        break;


                case "3":
                    System.out.println("Voici le top 10");
                    replay = false;
                    break;

                case "4":
                    System.out.println("Salut");
                    System.exit(0);

                default:
                    System.out.println("Veuillez sélectionner une option valide");
            }

        }

        //Grille grille = new Grille();

        //grille.affichageGrille();

    }

}
