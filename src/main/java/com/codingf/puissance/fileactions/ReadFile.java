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

            }

            List sortedKeys=new ArrayList(top.values());
            List sortedGrid = SortFile.tri_insertion(sortedKeys);

            List<String> nameList = new ArrayList<>();
            List<Integer> numList = new ArrayList<>();

            int iterator = 0;

            for (Object key : sortedGrid) {

                String thing = "";

                for (Map.Entry mapentry : top.entrySet()) {

                    if (mapentry.getValue().equals(key)) {
                        if (!nameList.contains(mapentry.getKey().toString())) {
                            thing = mapentry.getKey().toString();
                            nameList.add(mapentry.getKey().toString());
                            numList.add((int)mapentry.getValue());
                            break;
                        }
                    }
                }
                iterator++;
                System.out.println(iterator + " : " + thing + " a gagné en " + key + " coups");
                System.out.println(nameList);
                if (iterator > 2) {
                    if (!numList.get(iterator-2).equals(numList.get(iterator-3))) {
                        nameList.clear();
                    }
                }

                if (iterator == 10) {
                    break;
                }
            }

        }
        catch (IOException e) {
            System.out.println("NON");
        }

    }

}
