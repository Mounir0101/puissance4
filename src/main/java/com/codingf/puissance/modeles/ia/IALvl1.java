package com.codingf.puissance.modeles.ia;

import com.codingf.puissance.modeles.Joueur;

import java.util.Random;

public class IALvl1 extends IA{

    public IALvl1(String pseudo, char symbol, int turn) {
        super(pseudo, symbol, turn);
    }

    public static int iaPlay() {
        Random rand = new Random();
        int column = rand.nextInt(7);
        return column;
    }

}
