package com.codingf.puissance.games;

import com.codingf.puissance.fileactions.WriteFile;
import com.codingf.puissance.fonctions.Victoire;
import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.Grille;
import com.codingf.puissance.modeles.Joueur;
import com.codingf.puissance.modeles.VictoryChecker;
import com.codingf.puissance.modeles.ia.IA;
import com.codingf.puissance.modeles.ia.IALvl1;
import com.codingf.puissance.modeles.ia.IALvl2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JeuSeul {

    public static void singlePlayer(Cases[][] casesList) {
    // initiation des cases
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cases square = new Cases(i, j, ' ');
                casesList[i][j] = square;
            }
        }

        int iaLvl;
        // menu pour jouer avec l'IA
        while (true) {
            Scanner level = new Scanner(System.in);
            System.out.println("Contre quel niveau d'Ia voulez-vous jouer ? (1 ou 2)");
            try {
                iaLvl = level.nextInt();
                if (iaLvl != 1 && iaLvl != 2) {
                    System.out.println("Le niveau de l'ia peut être de 1 ou 2");
                }
                else {
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Sélectionnez un nombre valide (1 ou 2)");
            }

        }

        Grille grille = new Grille(casesList);

        System.out.println("Vous allez jouer seul");

        // Creation du joueur et de l'ia
        Joueur joueur = InitPlayers.player1();
        IA ia = new IA("Ordi", '@', 0);

        var currentPlayer = new Joueur(joueur.getPseudo(), joueur.getSymbol(), joueur.getTurn());
        VictoryChecker vic = new VictoryChecker(false);
        boolean play = true;
        int turn = 0;
        Scanner input = new Scanner(System.in);

        while (play) {

            grille.affichageGrille(vic);

            int line = 5;
            // Tour du joueur
            if (currentPlayer.getPseudo().equals(joueur.getPseudo())) {

                if (!PlayerTurn.playerTurn(currentPlayer, casesList, line)) {
                    continue;
                }

            }

            else {

                // Tour de l'ia
                if (!IA.iaTurn(casesList, iaLvl, currentPlayer, line)) {
                    continue;
                }

            }

            turn += 1;

            play = Victoire.mainChecker(vic, casesList, currentPlayer, grille);

            if (turn == 42 && play) {
                grille.affichageGrille(vic);
                System.out.println();
                System.out.println("Egalité, fin de la partie\n");
                play = false;
            }

            currentPlayer = Joueur.playerSwitch(currentPlayer, joueur, ia);

        }

    }

}
