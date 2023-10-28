package workingWithAbstractionHomeWork.cardRank_02;

public class Main {
    enum CardRanks{

        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        for (CardRanks value : CardRanks.values()) {

            System.out.print("Ordinal value: " + value.ordinal() + "; ");
            System.out.print("Name value: " + value);
            System.out.println();
        }
    }
}
