package com.codingf.puissance.modeles.ia;

import com.codingf.puissance.modeles.Cases;
import com.codingf.puissance.modeles.Joueur;

public class IA extends Joueur {

    public IA(String pseudo, char symbol, int turn) {
        super(pseudo, symbol, turn);
    }

    public static boolean iaTurn(Cases[][] casesList, int iaLvl, Joueur currentPlayer, int line) {
        // Fonction qui définit ce que l'ordi fait quand c'est son tour de jouer

        int iaColumn = 0;

        if (iaLvl == 1) {
            iaColumn = IALvl1.iaPlay();
        }
        else if (iaLvl == 2) {
            iaColumn = IALvl2.iaPlay2(casesList);
        }

        try {

            while (casesList[line][iaColumn].getSymbol() != ' ') {
                line--;
            }

            casesList[line][iaColumn].setSymbol(currentPlayer.getSymbol());
            currentPlayer.setTurn(currentPlayer.getTurn() + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.err.println("Choisissez une autre colonne");
            return false;
        }

        return true;

    }

}
