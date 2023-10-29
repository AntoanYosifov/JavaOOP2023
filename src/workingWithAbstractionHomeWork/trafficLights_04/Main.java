package workingWithAbstractionHomeWork.trafficLights_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String trafficLightsLine = scanner.nextLine();
        String[] trafficLightsArray = trafficLightsLine.split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[trafficLightsArray.length];

        for (int i = 0; i < trafficLightsArray.length; i++) {
            String light = trafficLightsArray[i];
            TrafficLight.Signal signal = TrafficLight.Signal.valueOf(light);

            trafficLights[i] = new TrafficLight(signal);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateTrafficLights(trafficLights);
            printTrafficLights(trafficLights);
        }
    }

    private static void updateTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.update();
        }
    }

    private static void printTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }
}
