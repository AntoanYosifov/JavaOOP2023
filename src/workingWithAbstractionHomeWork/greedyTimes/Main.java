package workingWithAbstractionHomeWork.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContentAsString = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Integer>> bag = new LinkedHashMap<>();


        for (int i = 0; i < safeContentAsString.length; i += 2) {
            String type = safeContentAsString[i];
            int currentAmount = Integer.parseInt((safeContentAsString[i + 1]));

            String treasureType = findTreasureType(type);

            if (treasureType.equals("")) {
                continue;
            } else if (isOverCapacity(bagCapacity, bag, currentAmount)) {
                continue;
            }

            int currentGoldAmount = 0;
            if (bag.containsKey("Gold")) {
                currentGoldAmount = bag.get("Gold").values().stream().mapToInt(e -> e).sum();
            }
            int currentGemAmount = 0;
            if (bag.containsKey("Gem")) {
                currentGemAmount = bag.get("Gem").values().stream().mapToInt(e -> e).sum();
            }
            int currentCashAmount = 0;
            if (bag.containsKey("Cash")) {
                currentCashAmount = bag.get("Cash").values().stream().mapToInt(e -> e).sum();
            }

            switch (treasureType) {
                case "Gem":
                    if (!bag.containsKey("Gold")) {
                        continue;
                    } else if (currentGemAmount + currentAmount > currentGoldAmount) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey("Gem")) {
                        continue;
                    } else if (currentCashAmount + currentAmount > currentGemAmount) {
                        continue;
                    }
                    break;
            }

            fillTheBag(bag, type, currentAmount, treasureType);
        }

        printBagContent(bag);
    }

    private static void printBagContent(Map<String, LinkedHashMap<String, Integer>> bag) {
        for (var x : bag.entrySet()) {
            int sumValues = x.getValue().values().stream().mapToInt(value -> value).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static void fillTheBag(Map<String, LinkedHashMap<String, Integer>> bag, String type, int currentAmount, String treasureType) {
        if (!bag.containsKey(treasureType)) {
            bag.put(treasureType, new LinkedHashMap<>());
        }

        if (!bag.get(treasureType).containsKey(type)) {
            bag.get(treasureType).put(type, 0);
        }

        bag.get(treasureType).put(type, bag.get(treasureType).get(type) + currentAmount);
    }

    private static boolean isOverCapacity(long bagCapacity, Map<String, LinkedHashMap<String, Integer>> bag, int currentAmount) {
        return bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + currentAmount > bagCapacity ;
    }

    private static String findTreasureType(String type) {

        if (type.length() == 3) {
            return "Cash";
        }
        if (type.length() > 3 && type.toLowerCase().endsWith("gem")) {
            return "Gem";
        }
        if (type.toLowerCase().equals("gold")) {
            return "Gold";
        }
        return "";
    }
}