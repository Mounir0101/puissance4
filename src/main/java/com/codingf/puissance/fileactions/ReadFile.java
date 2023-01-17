package com.codingf.puissance.fileactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {

    public static void readTop10() {
        try {
            BufferedReader top10 = new BufferedReader(new FileReader("top10.txt"));
            Scanner fileScan = new Scanner(top10);

            HashMap<String, Integer> top = new HashMap<String, Integer>();

            while (fileScan.hasNextLine()) {

                String topInfo = fileScan.nextLine();

                String[] infos = topInfo.split(" : ");

                top.put(infos[0], Integer.valueOf(infos[1]));

                //System.out.println(infos[0] + " a gagné en " + infos[1] + " coups");
            }

            List sortedKeys=new ArrayList(top.values());
            List sortedGrid = SortFile.tri_insertion(sortedKeys);
            //Collections.sort(sortedKeys);

            for (Object key : sortedGrid) {
                String thing = "";

                for (Map.Entry mapentry : top.entrySet()) {

                    if (mapentry.getValue().equals(key)) {
                        System.out.println(mapentry.getKey());
                        thing = mapentry.getKey().toString();
                        //top.remove(mapentry.getKey().toString());
                    }
                }
                System.out.println(thing + " a gagné en " + key + " coups");
            }

            /*SortedSet<Integer> keys = new TreeSet<>(top.keySet());
            for (Integer key : keys) {
                String value = top.get(key);
                System.out.println(value + " a gagné en " + key);
            }*/

        }
        catch (IOException e) {
            System.out.println("NON");
        }

    }

}
