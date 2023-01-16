package com.codingf.puissance.fonctions;

import com.codingf.puissance.modeles.Cases;

public class Victoire {

    //private

    int count = 0;

    public boolean lineVictory(Cases[][] casesList) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i][j+1].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i][j+2].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i][j+3].getSymbol() &&
                    casesList[i][j].getSymbol() != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean columnVictory(Cases[][] casesList) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (casesList[i][j].getSymbol() == casesList[i+1][j].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i+2][j].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i+3][j].getSymbol() &&
                    casesList[i][j].getSymbol() != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagTLBRVictory(Cases[][] casesList) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i+1][j+1].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i+2][j+2].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i+2][j+3].getSymbol() &&
                    casesList[i][j].getSymbol() != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagTRBLVictory(Cases[][] casesList) {

        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i-1][j+1].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i-2][j+2].getSymbol() &&
                    casesList[i][j].getSymbol() == casesList[i-3][j+3].getSymbol() &&
                    casesList[i][j].getSymbol() != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

}
