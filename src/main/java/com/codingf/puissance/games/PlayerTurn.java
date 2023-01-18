package com.codingf.puissance.games;

import java.util.Scanner;

import com.codingf.puissance.modeles.Joueur;
import com.codingf.puissance.modeles.Cases;

public class PlayerTurn {

    public static boolean playerTurn(Joueur currentPlayer, Cases[][] casesList, int line) {

        Scanner input = new Scanner(System.in);

        // demander au joueur quelle colonne il veut
        System.out.println("Sélectionnez une colonne "+currentPlayer.getPseudo());
        String numColInput = input.next();

        int numCol = 0;

        try {
            numCol = Integer.parseInt(numColInput)-1;
            if (numCol < 0 || numCol > 6) {
                System.out.println("Sélectionnez une colonne entre 1 et 7");
                return false;
            }

        }
        catch (Exception e) {
            System.err.println("Veuillez entrer un nombre valide");
            return false;
        }

        try {

            while (casesList[line][numCol].getSymbol() != ' ' ) {
                line --;
            }

            casesList[line][numCol].setSymbol(currentPlayer.getSymbol());
            currentPlayer.setTurn(currentPlayer.getTurn()+1);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Choisissez une autre colonne");
            return false;
        }

        return true;

    }

}
