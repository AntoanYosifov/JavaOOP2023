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


        int rand = this.random.nextInt(super.size());


        return super.get(rand);
    }
}
