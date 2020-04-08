package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ALL implements Strategy {
    Scanner scan = new Scanner(System.in);

    @Override
    public void printData(Map<String, List<Integer>> people, Map<Integer, String> peopleByInd) {
        System.out.println("Enter a name or email to search all suitable people.");
        String[] keyWords = scan.nextLine().split(" ");
        Map<Integer, String> newMap = new HashMap<>();
        for (int i : peopleByInd.keySet()) {
            int counter = 0;
            for (String word : keyWords) {
                String[] mapWords = peopleByInd.get(i).split(" ");
                for (String noIdeaForNames : mapWords) {
                    if (noIdeaForNames.equals(word)) {
                        counter++;
                    }
                }
            }
            if (counter == keyWords.length) {
                newMap.put(i, peopleByInd.get(i));
            }
        }

        if (newMap.isEmpty()) {
            System.out.println("No matching people found");
        } else {
            int size = newMap.size();
            System.out.println(size + " persons found:");

            for (int num : newMap.keySet()) {
                System.out.println(newMap.get(num));
            }
        }
    }
}