package com.codingf.puissance.modeles.ia;

import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.VictoryChecker;

public class IALvl2 extends IALvl1{

    public IALvl2(String pseudo, char symbol, int turn) {
        super(pseudo, symbol, turn);
    }

    public static int columnPlacement(Cases[][] casesList) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                //System.out.println(casesList[i][j].getSymbol() + " + " + casesList[i+1][j].getSymbol() + " + " + casesList[i+2][j].getSymbol());
                if (casesList[i][j].getSymbol() != casesList[i + 1][j].getSymbol() &&
                        casesList[i + 1][j].getSymbol() == casesList[i + 2][j].getSymbol() &&
                        casesList[i + 1][j].getSymbol() == casesList[i + 3][j].getSymbol() &&
                        casesList[i][j].getSymbol() == ' ') {
                    System.out.println("faut mettre a la colonne " + j);
                    return j;
                }
            }
        }
        return iaPlay();
    }

}
