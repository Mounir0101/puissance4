package com.codingf.puissance.fileactions;

public class SortFile {

    public int[] tri_insertion (int[] tableau) {

        for (int i = 1; i <tableau.length; i++) {
            int lacase = tableau[i];
            int j = i-1;
            while (j >= 0 && tableau[j] > lacase) {
                tableau[j+1] = tableau[j];
                j = j - 1;
            }
            tableau[j+1] = lacase;
        }
        return tableau;
    }

}
