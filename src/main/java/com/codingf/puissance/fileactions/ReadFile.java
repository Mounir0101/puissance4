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

            HashMap<String, Integer> top = new HashMap<>();

            while (fileScan.hasNextLine()) {

                String topInfo = fileScan.nextLine();

                String[] infos = topInfo.split(" : ");

                boolean add = false;

                while (!add) {

                    if (top.containsKey(infos[0])) {
                        //System.out.println(infos[0] + "bonjour");
                        infos[0] = " " + infos[0];
                        //top.put(infos[0], Integer.valueOf(infos[1]));
                        //System.out.println(infos[0] + "bonjour");
                        //if (top.get(infos[0]) > Integer.parseInt(infos[1])) {
                        //    top.put(infos[0], Integer.valueOf(infos[1]));
                        //}
                    }
                    else {
                        top.put(infos[0], Integer.valueOf(infos[1]));
                        add = true;
                    }

                }

            }

            if (top.size() != 0) {

                List sortedKeys = new ArrayList(top.values());
                List sortedGrid = SortList.tri_insertion(sortedKeys);

                List<String> nameList = new ArrayList<>();

                int iterator = 0;

                System.out.println("Voici le top 10");

                for (Object key : sortedGrid) {

                    String thing = "";

                    for (Map.Entry mapentry : top.entrySet()) {

                        if (mapentry.getValue().equals(key)) {
                            if (!nameList.contains(mapentry.getKey().toString())) {
                                thing = mapentry.getKey().toString();
                                nameList.add(mapentry.getKey().toString());
                                break;
                            }
                        }
                    }
                    iterator++;
                    System.out.println(iterator + " : " + thing.trim() + " a gagné en " + key + " coups");

                    if (iterator == 10) {
                        break;
                    }
                }
            }

            else {
                System.out.println("Il n'y a aucun score enregistré");
            }

        }
        catch (IOException e) {
            System.out.println("NON");
        }

    }

}
