package inheritanceLab.randomArrayList_03;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private final Random random;

    public RandomArrayList() {
        super();
        random = new Random();
    }

    public T getRandomElement() {


        int index = this.random.nextInt(super.size());
        T element = super.get(index);
        super.remove(index);
        return element;
    }
}
