package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> people = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Map<Integer, String> peopleByInd = new HashMap<>();
        int[] tab = new int[5];
        tab.

        fillFile(new File("C:/Users/Kuba/IdeaProjects/test/src/com/company/text.txt"), people, peopleByInd);
        Context context = new Context();

        boolean check = true;
        while (check) {
            printMenu();
            int choice = Integer.parseInt(scan.nextLine());
            check = outsideSwitch(choice, scan, context, people, peopleByInd, check);
        }
    }

    public static void printAllPeople(Map<Integer, String> mapByInd) {
        int mapSize = mapByInd.size();
        for (int i = 0; i < mapSize; i++) {
            System.out.println(mapByInd.get(i));
        }
    }

    public static void showAllData(String[] person) {
        for (int i = 0; i < person.length - 1; i++) {
            System.out.print(person[i] + " ");
        }
        System.out.println(person[person.length - 1]);
    }

    public static void foundPeople(List<String[]> people, String keyWord) {
        int counter = 0;
        for (String[] person : people) {
            for (String prs : person) {
                if (prs.toLowerCase().trim().contains(keyWord)) {
                    showAllData(person);
                    counter++;
                    break;
                }
            }
        }
        if (counter == 0) {
            System.out.println("No matching people found.");
        }
    }

    public static void printMenu() {
        System.out.printf("=== Menu ===%n" +
                "1. Find a person%n" +
                "2. Print all people%n" +
                "0. Exit%n");
    }

    public static void fillFile(File file, Map<String, List<Integer>> people, Map<Integer, String> peopleByInd) {
        try (Scanner scanFile = new Scanner(file)) {
            int counter = 0;
            while (scanFile.hasNext()) {
                String wordToMap = scanFile.nextLine();
                String[] words = wordToMap.split(" ");
                peopleByInd.put(counter, wordToMap);
                for (String word : words) {
                    if (people.containsKey(word)) {
                        people.get(word).add(counter);
                    } else {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(counter);
                        people.put(word, newList);
                    }
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static boolean outsideSwitch(int choice, Scanner scan, Context context, Map<String, List<Integer>> people,
                                     Map<Integer, String> peopleByInd, boolean check) {
        switch (choice) {
            case 1:
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                String chosenStrategy = scan.nextLine();
                switch (chosenStrategy) {
                    case "ALL":
                        context.setStrategy(new ALL());
                        context.printData(people, peopleByInd);
                        break;
                    case "ANY":
                        context.setStrategy(new ANY());
                        context.printData(people, peopleByInd);
                        break;
                    case "NONE":
                        context.setStrategy(new NONE());
                        context.printData(people, peopleByInd);
                        break;
                    default:
                        System.out.println("Wrong option");
                        break;
                }
                break;
            case 2:
                System.out.println("=== List of people ===");
                printAllPeople(peopleByInd);
                break;
            case 0:
                System.out.println("Bye!");
                check = false;
                break;
            default:
                System.out.println("Incorrect option! Try again.");
                break;

        }
        return check;
    }
}






