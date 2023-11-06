package inheritanceLab.animal;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();


        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
