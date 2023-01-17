package com.codingf.puissance.fileactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

    public static void readTop10() {
        try {
            BufferedReader top10 = new BufferedReader(new FileReader("top10.txt"));
            Scanner fileScan = new Scanner(top10);

            while (fileScan.hasNextLine()) {
                String topInfo = fileScan.nextLine();
                String[] infos = topInfo.split(" : ");
                System.out.println(infos[0] + " a gagné en " + infos[1] + " coups");
            }

        }
        catch (IOException e) {
            System.out.println("NON");
        }

    }

}
