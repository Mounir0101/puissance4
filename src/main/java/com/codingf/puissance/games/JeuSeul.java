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

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cases square = new Cases(i, j, ' ');
                casesList[i][j] = square;
            }
        }

        int iaLvl;

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

        Scanner player = new Scanner(System.in);
        System.out.println("Choisissez votre pseudo");
        String playerPseudo = player.nextLine();

        char playerSymbol;

        while (true) {
            System.out.println("Choisissez votre symbole");
            playerSymbol = player.nextLine().charAt(0);
            if (playerSymbol == '@') {
                System.out.println("Désolé, ce symbole est réservé pour l'ordi");
            }
            else {
                break;
            }
        }

        Joueur joueur = new Joueur(playerPseudo, playerSymbol, 1);
        IA ia = new IA("Ordi", '@', 0);

        var currentPlayer = new Joueur(joueur.getPseudo(), joueur.getSymbol(), joueur.getTurn());
        VictoryChecker vic = new VictoryChecker(false);
        boolean play = true;
        int turn = 0;
        Scanner input = new Scanner(System.in);

        while (play) {

            grille.affichageGrille(vic);

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

                //int iaColumn = IALvl2.linePlacement(casesList);
                
                int iaColumn = 0;
                
                if (iaLvl == 1) {
                    iaColumn = IALvl1.iaPlay();
                } else if (iaLvl == 2) {
                    iaColumn = IALvl2.iaPlay2(casesList);
                }

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
                if (Victoire.lineVictory(casesList).isVictory()) {
                    vic = Victoire.lineVictory(casesList);
                }
                if (Victoire.columnVictory(casesList).isVictory()) {
                    vic = Victoire.columnVictory(casesList);
                }
                if (Victoire.diagTLBRVictory(casesList).isVictory()) {
                    vic = Victoire.diagTLBRVictory(casesList);
                }
                if (Victoire.diagTRBLVictory(casesList).isVictory()) {
                    vic = Victoire.diagTRBLVictory(casesList);
                }
                play = false;
                grille.affichageGrille(vic);
                System.out.println();
                System.out.println("Victoire de " + currentPlayer.getPseudo() + " en "+currentPlayer.getTurn()+ " coups\n");

                WriteFile.writeTop10(currentPlayer);

            }

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
