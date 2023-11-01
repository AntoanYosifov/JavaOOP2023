package encapsulationLab.sortByNameAndAge_01.Person;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private  double salary;
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Person(String firstName, String lastName, int age, double salary){
        this(firstName, lastName, age);
        this.salary = salary;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public int getAge(){
        return this.age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        double actualBonus = bonus;
        if(this.age < 30){
            actualBonus /= 2;
        }
        this.salary = this.salary * (1 + (actualBonus / 100));
    }
// Angel Harizanov is 44 years old.

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
