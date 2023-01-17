package com.codingf.puissance.fileactions;

import com.codingf.puissance.modeles.Joueur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeTop10(Joueur currentPlayer) {

        try {
            File top10 = new File("../top10.txt");
            BufferedWriter sortie;
            if (top10.exists()) {
                sortie = new BufferedWriter(new FileWriter("top10.txt"));
            } else {
                sortie = new BufferedWriter(new FileWriter("top10.txt", true));
            }
            sortie.write(currentPlayer.getPseudo() + " : " + currentPlayer.getTurn() + "\n");
            sortie.close();
        } catch (
                IOException e) {
            System.out.println("ca marche pas");
        }
    }

}
