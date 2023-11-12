package inheritanceHomeWork.restaurant_05;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Coffee coffee = new Coffee("esp", 50);
        System.out.println(coffee.getCaffeine());
        System.out.println(coffee.getName());
        Beverage beverage = new Beverage("cola", new BigDecimal(5), 52);
        System.out.println(beverage.getMilliliters());
        HotBeverage hotBeverage = new HotBeverage("tea", new BigDecimal(7), 42);
        System.out.println(hotBeverage.getMilliliters());
        System.out.println(hotBeverage.getName());
        System.out.println(beverage.getName());

    }
}
