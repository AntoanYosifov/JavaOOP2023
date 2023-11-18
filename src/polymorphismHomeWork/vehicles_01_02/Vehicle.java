package polymorphismHomeWork.vehicles_01_02;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;


    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Double drive(double distance) {
        double fuelRequired = distance * (fuelConsumption + getExtraFuelConsumption());

        if (fuelRequired > fuelQuantity) {
            return null;
        }
        fuelQuantity -= fuelRequired;
        return distance;

    }

    protected abstract double getExtraFuelConsumption();

    public void refuel(double litters) {
        if(litters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(this.fuelQuantity + litters > this.tankCapacity ){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += calculateRefuelLittersAfterLoss(litters);
    }

    protected double calculateRefuelLittersAfterLoss(double litters) {
        return litters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }
}
