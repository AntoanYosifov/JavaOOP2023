package polymorphismHomeWork.vehicles_01_02;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapcity) {
        super(fuelQuantity, fuelConsumption, tankCapcity);

    }

    @Override
    protected double getExtraFuelConsumption() {
        return 0.9;
    }

}
