package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class ANY implements Strategy {
    Scanner scan = new Scanner(System.in);

    @Override
    public void printData(Map<String, List<Integer>> people, Map<Integer, String> peopleByInd) {
        System.out.println("Enter a name or email to search all suitable people.");
        String[] keyWords = scan.nextLine().split(" ");
        List<String> names = new ArrayList<>();
        for (String word : keyWords) {
            for (String anotherWord : people.keySet()){
                if (word.equals(anotherWord)) {
                    for (int i : people.get(anotherWord)) {
                        names.add(peopleByInd.get(i));
                    }
                }
            }
        }

        if (names.isEmpty()) {
            System.out.println("No matching people found");
        } else {
            int size = names.size();
            System.out.println(size + " persons found:");

            for (String name : names) {
                System.out.println(name);
            }
        }

    }
}
