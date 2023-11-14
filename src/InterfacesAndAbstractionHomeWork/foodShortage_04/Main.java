package InterfacesAndAbstractionHomeWork.foodShortage_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyersByName = new HashMap<>();

        int numBuyers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numBuyers; i++) {
            String[] parameters = scanner.nextLine().split("\\s+");
            if (parameters.length == 4) {
                Citizen citizen = new Citizen(parameters[0], Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
                buyersByName.put(citizen.getName(), citizen);
            } else if (parameters.length == 3) {
                Rebel rebel = new Rebel(parameters[0], Integer.parseInt(parameters[1]), parameters[2]);
                buyersByName.put(rebel.getName(), rebel);
            }
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String personToBuy = command;

            if (buyersByName.containsKey(personToBuy)) {
                buyersByName.get(personToBuy).buyFood();
            }


            command = scanner.nextLine();
        }
        System.out.println(buyersByName.values().stream().mapToInt(b-> b.getFood()).sum());
    }
}

