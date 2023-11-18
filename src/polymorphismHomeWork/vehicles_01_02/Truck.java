package polymorphismHomeWork.vehicles_01_02;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected double getExtraFuelConsumption() {
        return 1.6;
    }

    @Override
    protected double calculateRefuelLittersAfterLoss(double litters) {
        return litters * 0.95;
    }
}
