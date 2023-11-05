package encapsulationHomeWork.classBox_01;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, width, height);

        System.out.printf("Surface Area - %.02f\n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.02f\n" , box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.02f\n" , box.calculateVolume());
    }
}
