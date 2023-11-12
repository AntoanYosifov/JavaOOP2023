package inheritanceHomeWork.needForSpeed_04;

public class RaceMotorcycle extends Motorcycle{
    public static final double DEFAULT_FUEL_CONSUMPTION = 8;
    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
