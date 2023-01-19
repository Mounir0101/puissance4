package com.codingf.puissance.fonctions;

import com.codingf.puissance.fileactions.WriteFile;
import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.Grille;
import com.codingf.puissance.modeles.Joueur;
import com.codingf.puissance.modeles.VictoryChecker;

public class Victoire {

    static VictoryChecker victory;

    public static VictoryChecker lineVictory(Cases[][] casesList) {
        // Vérification des victoires sur une ligne

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i][j + 1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i][j + 2].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i][j + 3].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    return victory = new VictoryChecker(true, casesList[i][j], casesList[i][j + 1], casesList[i][j + 2], casesList[i][j + 3]);
                }
            }
        }
        return victory = new VictoryChecker(false);
    }

    public static VictoryChecker columnVictory(Cases[][] casesList) {
        // Vérification des victoires sur une colonne

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (casesList[i][j].getSymbol() == casesList[i + 1][j].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i + 2][j].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i + 3][j].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    return victory = new VictoryChecker(true, casesList[i][j], casesList[i + 1][j], casesList[i + 2][j], casesList[i + 3][j]);
                }
            }
        }
        return victory = new VictoryChecker(false);
    }

    public static VictoryChecker diagTLBRVictory(Cases[][] casesList) {
        // Vérification des victoires sur une diagonale "haut-gauche/bas-droite

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i + 1][j + 1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i + 2][j + 2].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i + 3][j + 3].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    return victory = new VictoryChecker(true, casesList[i][j], casesList[i + 1][j+1], casesList[i + 2][j+2], casesList[i + 3][j+3]);
                }
            }
        }
        return victory = new VictoryChecker(false);
    }

    public static VictoryChecker diagTRBLVictory(Cases[][] casesList) {
        // Vérification des victoires sur une diagonale "haut-droite/bas-gauche

        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i - 1][j + 1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i - 2][j + 2].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i - 3][j + 3].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    return victory = new VictoryChecker(true, casesList[i][j], casesList[i - 1][j + 1], casesList[i - 2][j + 2], casesList[i - 3][j + 3]);
                }
            }
        }
        return victory = new VictoryChecker(false);
    }

    public static boolean mainChecker(VictoryChecker vic, Cases[][] casesList, Joueur currentPlayer, Grille grille) {
        // Fonction pour vérifier si une victoire a lieu

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
            grille.affichageGrille(vic);
            System.out.println();
            System.out.println("Victoire de " + currentPlayer.getPseudo() + " en "+currentPlayer.getTurn()+ " coups\n");

            WriteFile.writeTop10(currentPlayer);

            return false;

        }

        return true;

    }


}
