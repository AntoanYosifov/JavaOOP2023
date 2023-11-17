package InterfacesAndAbstractionHomeWork.telephony_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(Arrays.asList(numbers), Arrays.asList(urls));

        String callResult = smartphone.call();
        String browseResult = smartphone.browse();

        System.out.print(callResult);
        System.out.print(browseResult);
    }
}
