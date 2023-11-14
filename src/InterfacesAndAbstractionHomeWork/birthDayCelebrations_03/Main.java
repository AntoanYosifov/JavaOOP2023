package InterfacesAndAbstractionHomeWork.birthDayCelebrations_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
       List<Birthable> birthableList = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] parameters = input.split("\\s+");
            switch (parameters[0]) {
                case "Citizen":
                    Birthable citizen = new Citizen(parameters[1], Integer.parseInt(parameters[2]), parameters[3], parameters[4]);
                    birthableList.add(citizen);
                    break;
                case "Pet":
                    Birthable pet = new Pet(parameters[1], parameters[2]);
                    birthableList.add(pet);
                    break;
                case "Robot":
                    Robot robot = new Robot(parameters[1], parameters[2]);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown :" + parameters[0]);
            }

            input = scanner.nextLine();
        }

        String targetYear = scanner.nextLine();

        for (Birthable b : birthableList) {
            if(b.getBirthDate().endsWith(targetYear)){
                System.out.println(b.getBirthDate());
            }
        }
    }
}

