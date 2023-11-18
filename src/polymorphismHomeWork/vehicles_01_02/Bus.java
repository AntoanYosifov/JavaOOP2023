package polymorphismHomeWork.vehicles_01_02;

public class Bus extends Vehicle {
    boolean nextDriveIsEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected double getExtraFuelConsumption() {
        if (nextDriveIsEmpty) {
            return 0;
        }
        return 1.4;
    }

    @Override
    public Double drive(double distance) {
        Double result = super.drive(distance);
        nextDriveIsEmpty = false;
        return result;
    }

    public void setupEmptyDrive() {
        nextDriveIsEmpty = true;
    }
}
