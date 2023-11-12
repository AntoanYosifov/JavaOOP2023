package inheritanceHomeWork.needForSpeed_04;

public class Vehicle {
    public static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double fuelToConsume = kilometers * this.getFuelConsumption();
        if (fuelToConsume > getFuel()) {
            throw new IllegalStateException("Not enough fuel to drive " + kilometers + " kilometers.");
        }

        this.setFuel(this.getFuel() - fuelToConsume);
    }
}
