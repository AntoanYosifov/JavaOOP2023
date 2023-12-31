package encapsulationHomeWork.AnimalFarm_02;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);

    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;

    }

    public double productPerDay() {
        return calculateProductPerDay();
    }
// Chicken Choko (age 6) can produce 1.00 eggs per day.
    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.02f eggs per day.", this.name, this.age, productPerDay());
    }

    private double calculateProductPerDay() {
        if (this.age <= 5) {
            return 2;
        } else if (this.age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }
}
