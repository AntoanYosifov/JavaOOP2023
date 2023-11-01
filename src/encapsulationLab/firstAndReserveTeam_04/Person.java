package encapsulationLab.firstAndReserveTeam_04;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age);
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }


    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {

        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double actualBonus = bonus;
        if (this.age < 30) {
            actualBonus /= 2;
        }
        double newSalary = this.salary * (1 + (actualBonus / 100));
        setSalary(newSalary);
    }


    //  @Override
//    public String toString() {
//        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
//    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0##");
        String formattedSalary = df.format(this.salary);
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, formattedSalary);
    }
}
