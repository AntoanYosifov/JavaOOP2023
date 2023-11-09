package inheritanceLab.randomArrayList_03;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> randomNums = new RandomArrayList<>();
        randomNums.add(42);
        randomNums.add(13);
        randomNums.add(69);

        System.out.println(randomNums.getRandomElement());
    }
}
