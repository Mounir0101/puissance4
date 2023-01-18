package com.codingf.puissance.games;

import com.codingf.puissance.fileactions.WriteFile;
import com.codingf.puissance.fonctions.Victoire;
import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.Grille;
import com.codingf.puissance.modeles.Joueur;
import com.codingf.puissance.modeles.VictoryChecker;

import java.util.Scanner;

public class JeuA2 {

    public static void twoPlayers(Cases[][] casesList) {
        // initialisation des cases
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cases square = new Cases(i, j, ' ');
                casesList[i][j] = square;
            }
        }

        Grille grille = new Grille(casesList);

        // menu pour les joueurs
        System.out.println("Vous jouez à 2");

        /*Scanner players = new Scanner(System.in);
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
        }*/

        Joueur[] playerList = InitPlayers.players2();

        Joueur player1 = playerList[0];
        Joueur player2 = playerList[1];

        System.out.println(player1);
        System.out.println(player2);

        Joueur currentPlayer = new Joueur(player1.getPseudo(), player1.getSymbol(), player1.getTurn());
        VictoryChecker vic = new VictoryChecker(false);
        boolean play = true;
        int turn = 0;
        Scanner input = new Scanner(System.in);

        // boucle principale du jeu
        while (play) {

            grille.affichageGrille(vic);

            int line = 5;

            if (!PlayerTurn.playerTurn(currentPlayer, casesList, line)) {
                continue;
            }

            turn += 1;

            // Vérifications de victoire
            play = Victoire.mainChecker(vic, casesList, currentPlayer, grille);

            // verification d'égalité
            if (turn == 42 && play) {
                grille.affichageGrille(vic);
                System.out.println();
                System.out.println("Egalité, fin de la partie\n");
                play = false;
            }

            currentPlayer = Joueur.playerSwitch(currentPlayer, player1, player2);

        }

    }

}
