package polymorphismHomeWork.vehicles_01_02;


import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";
    private static final String BUS_NAME = "Bus";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        String[] carInfoParams = scanner.nextLine().split("\\s+");
        String[] truckInfoParams = scanner.nextLine().split("\\s+");
        String[] busInfoParams = scanner.nextLine().split("\\s+");

        Map<String, Vehicle> vehiclesByName = new LinkedHashMap<>();

        vehiclesByName.put(CAR_NAME, new Car(Double.parseDouble(carInfoParams[1]), Double.parseDouble(carInfoParams[2]),
                Double.parseDouble(carInfoParams[3])));
        vehiclesByName.put(TRUCK_NAME, new Truck(Double.parseDouble(truckInfoParams[1]), Double.parseDouble(truckInfoParams[2]),
                Double.parseDouble(truckInfoParams[3])));
        vehiclesByName.put(BUS_NAME, new Bus(Double.parseDouble(busInfoParams[1]), Double.parseDouble(busInfoParams[2]),
                Double.parseDouble(busInfoParams[3])));

        int numCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String operation = command[0];
            String vehicleName = command[1];

            Vehicle vehicle = vehiclesByName.get(vehicleName);


            try {
                switch (operation) {
                    case "DriveEmpty":
                        Bus bus = (Bus) vehiclesByName.get(BUS_NAME);
                        bus.setupEmptyDrive();
                    case "Drive":
                        Double travelledKm = vehicle.drive(Double.parseDouble(command[2]));

                        if (travelledKm != null) {
                            System.out.println(vehicleName + " travelled " + decimalFormat.format(travelledKm) + " km");
                        } else {
                            System.out.println(vehicleName + " needs refueling");
                        }
                        break;
                    case "Refuel":
                        vehicle.refuel(Double.parseDouble(command[2]));
                        break;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("Car: %.2f\n", vehiclesByName.get(CAR_NAME).getFuelQuantity());
        System.out.printf("Truck: %.2f\n", vehiclesByName.get(TRUCK_NAME).getFuelQuantity());
        System.out.printf("Bus: %.2f\n", vehiclesByName.get(BUS_NAME).getFuelQuantity());

    }
}
