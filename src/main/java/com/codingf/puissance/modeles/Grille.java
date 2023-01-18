package com.codingf.puissance.modeles;

//import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.VictoryChecker;

public class Grille {

    Cases[][] casesList;

    public Grille(Cases[][] casesList) {
        this.casesList = casesList;
    }

    public void affichageGrille(VictoryChecker vic) {

        final String green = "\u001B[32m";
        final String reset = "\u001B[0m";

        System.out.println("  1   2   3   4   5   6   7");

        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        for (int i = 0 ; i < 6; i++ ){
            for (int j = 0 ; j < 7 ; j++){
                if (j == 0) {
                    if (vic.isVictory()) {
                        //System.out.println("C'est la victoire");
                        if (vic.getCase1().equals(casesList[i][j]) || vic.getCase2().equals(casesList[i][j]) ||
                            vic.getCase3().equals(casesList[i][j]) || vic.getCase4().equals(casesList[i][j])) {
                            System.out.print("║ " + green + casesList[i][j].getSymbol() + reset);
                        }
                        else {
                            System.out.print("║ " + casesList[i][j].getSymbol());
                        }
                    }
                    else {
                        System.out.print("║ " + casesList[i][j].getSymbol());
                    }
                }
                else {
                    if (vic.isVictory()) {
                        if (vic.getCase1().equals(casesList[i][j]) || vic.getCase2().equals(casesList[i][j]) ||
                                vic.getCase3().equals(casesList[i][j]) || vic.getCase4().equals(casesList[i][j])) {
                            System.out.print(" ║ " + green + casesList[i][j].getSymbol() + reset);
                        }
                        else {
                            System.out.print(" ║ " + casesList[i][j].getSymbol());
                        }
                    }
                    else {
                        System.out.print(" ║ " + casesList[i][j].getSymbol());
                    }

                }

            }
            System.out.println(" ║");
            if (i == 5){
                System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
            }else{
                System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }

        }

    }

    public void caseColor(Cases case1, Cases case2, Cases case3, Cases case4) {

    }

}
