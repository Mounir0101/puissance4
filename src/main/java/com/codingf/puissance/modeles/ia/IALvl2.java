package com.codingf.puissance.modeles.ia;

import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.VictoryChecker;
import com.codingf.puissance.modeles.Align3;

import java.util.Random;

public class IALvl2 extends IALvl1{

    public IALvl2(String pseudo, char symbol, int turn) {
        super(pseudo, symbol, turn);
    }

    public static Align3 columnPlacement(Cases[][] casesList) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (casesList[i][j].getSymbol() != casesList[i + 1][j].getSymbol() &&
                        casesList[i + 1][j].getSymbol() == casesList[i + 2][j].getSymbol() &&
                        casesList[i + 1][j].getSymbol() == casesList[i + 3][j].getSymbol() &&
                        casesList[i][j].getSymbol() == ' ') {
                    return new Align3(true, j);
                }
            }
        }
        return new Align3(false, 0);
    }


    public static Align3 linePlacement(Cases[][] casesList) {

        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (casesList[i][j].getSymbol() == casesList[i][j-1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i][j+1].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    if ((j == 1 || j == 5) && casesList[i][3].getSymbol() == ' ') {
                        return new Align3(true, 3);
                    }
                    try {
                    if (casesList[i][j - 2].getSymbol() == ' ' || casesList[i][j + 2].getSymbol() == ' ') {
                        if (casesList[i][j-2].getSymbol() == ' ') {
                            return new Align3(true, j-2);
                        } else if (casesList[i][j+2].getSymbol() == ' ') {
                            return new Align3(true, j+2);
                        }
                        /*Random rand = new Random();
                            int[] nums = new int[2];
                            nums[0] = j - 2;
                            nums[1] = j + 2;
                            int random = rand.nextInt(2);
                            return new Align3(true, nums[random]);*/
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {

                        return new Align3(false, 0);
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 5; j++) {

                if (casesList[i][j].getSymbol() == casesList[i][j-1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i][j+2].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    if (casesList[i][j+1].getSymbol() == ' ') {
                        return new Align3(true, j+1);
                    }

                }

            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 2; j < 6; j++) {

                if (casesList[i][j].getSymbol() == casesList[i][j+1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i][j-2].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    if (casesList[i][j-1].getSymbol() == ' ') {
                        return new Align3(true, j-1);
                    }
                }

            }
        }

        return new Align3(false, 0);
    }


    public static Align3 diagTLBRPlacement(Cases[][] casesList) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() != casesList[i + 1][j+1].getSymbol() &&
                        casesList[i + 1][j+1].getSymbol() == casesList[i + 2][j+2].getSymbol() &&
                        casesList[i + 1][j+1].getSymbol() == casesList[i + 3][j+3].getSymbol() &&
                        casesList[i][j].getSymbol() == ' ') {
                    return new Align3(true, j);
                }
            }
        }
        return new Align3(false, 0);
    }

    public static Align3 diagTRBLPlacement(Cases[][] casesList) {

        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if (casesList[i][j].getSymbol() == casesList[i - 1][j+1].getSymbol() &&
                        casesList[i][j].getSymbol() == casesList[i - 2][j+2].getSymbol() &&
                        casesList[i][j].getSymbol() != ' ') {
                    return new Align3(true, j+3);
                }
            }
        }
        return new Align3(false, 0);
    }



    public static int iaPlay2(Cases[][] casesList) {
        if (columnPlacement(casesList).isCheck()) {
            return columnPlacement(casesList).getColumn();
        }
        else if (linePlacement(casesList).isCheck()) {
            return linePlacement(casesList).getColumn();
        }
        else if (diagTLBRPlacement(casesList).isCheck()) {
            return diagTLBRPlacement(casesList).getColumn();
        }
        else if (diagTRBLPlacement(casesList).isCheck()) {
            return diagTRBLPlacement(casesList).getColumn();
        }
        else {
            return iaPlay();
        }

    }

}
