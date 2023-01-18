package com.codingf.puissance.fonctions;

import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.VictoryChecker;

public class Victoire {

    static VictoryChecker victory;

    public static VictoryChecker lineVictory(Cases[][] casesList) {

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

}
