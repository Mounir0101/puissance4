package com.codingf.puissance.games;

import com.codingf.puissance.fileactions.WriteFile;
import com.codingf.puissance.fonctions.Victoire;
import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.Grille;
import com.codingf.puissance.modeles.Joueur;
import com.codingf.puissance.modeles.ia.IA;
import com.codingf.puissance.modeles.ia.IALvl1;
import com.codingf.puissance.modeles.ia.IALvl2;

import java.util.Scanner;

public class JeuSeul {

    public static void singlePlayer(Cases[][] casesList) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cases square = new Cases(i, j, ' ');
                casesList[i][j] = square;
            }
        }

        Grille grille = new Grille(casesList);

        System.out.println("Vous allez jouer seul");

        Scanner player = new Scanner(System.in);
        System.out.println("Choisissez votre pseudo");
        String playerPseudo = player.nextLine();
        System.out.println("Choisissez votre symbole");
        char playerSymbol = player.nextLine().charAt(0);

        Joueur joueur = new Joueur(playerPseudo, playerSymbol, 1);
        IA ia = new IA("Ordi", '@', 0);

        var currentPlayer = new Joueur(joueur.getPseudo(), joueur.getSymbol(), joueur.getTurn());
        boolean play = true;
        int turn = 0;
        Scanner input = new Scanner(System.in);

        while (play) {

            grille.affichageGrille();

            int line = 5;

            if (currentPlayer.getPseudo().equals(joueur.getPseudo())) {

                System.out.println("Sélectionnez une colonne " + currentPlayer.getPseudo());
                String numColInput = input.next();

                int numCol;

                try {
                    numCol = Integer.parseInt(numColInput) - 1;
                    if (numCol < 0 || numCol > 6) {
                        System.out.println("Sélectionnez une colonne entre 1 et 7");
                        continue;
                    }

                } catch (Exception e) {
                    System.err.println("Veuillez entrer un nombre valide");
                    continue;
                }

                try {

                    while (casesList[line][numCol].getSymbol() != ' ') {
                        line--;
                    }

                    casesList[line][numCol].setSymbol(currentPlayer.getSymbol());
                    currentPlayer.setTurn(currentPlayer.getTurn() + 1);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Choisissez une autre colonne");
                    continue;
                }
            }

            else {

                int iaColumn = IALvl2.linePlacement(casesList);

                //int iaColumn = IALvl1.iaPlay();

                try {

                    while (casesList[line][iaColumn].getSymbol() != ' ') {
                        line--;
                    }

                    casesList[line][iaColumn].setSymbol(currentPlayer.getSymbol());
                    currentPlayer.setTurn(currentPlayer.getTurn() + 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Choisissez une autre colonne");
                    continue;
                }
            }

            turn += 1;

            if (Victoire.lineVictory(casesList).isVictory() || Victoire.columnVictory(casesList).isVictory() ||
                    Victoire.diagTLBRVictory(casesList).isVictory() || Victoire.diagTRBLVictory(casesList).isVictory()) {
                play = false;
                grille.affichageGrille();
                System.out.println();
                System.out.println("Victoire de " + currentPlayer.getPseudo() + " en "+currentPlayer.getTurn()+ " coups\n");

                WriteFile.writeTop10(currentPlayer);

            }

            if (turn == 42 && play) {
                grille.affichageGrille();
                System.out.println();
                System.out.println("Egalité, fin de la partie\n");
                play = false;
            }

            currentPlayer = Joueur.playerSwitch(currentPlayer, joueur, ia);

        }

    }

}
