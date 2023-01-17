package com.codingf.puissance.fileactions;

import java.util.List;

public class SortFile {

    public static List tri_insertion (List tableau) {

        for (int i = 1; i <tableau.size(); i++) {
            int lacase = (int) tableau.get(i);
            int j = i-1;
            while (j >= 0 && (int)tableau.get(j) > lacase) {
                tableau.set(j+1, tableau.get(j));
                j = j - 1;
            }
            tableau.set(j+1, lacase);
        }
        return tableau;
    }

}
