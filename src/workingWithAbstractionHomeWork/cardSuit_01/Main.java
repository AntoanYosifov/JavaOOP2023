package workingWithAbstractionHomeWork.cardSuit_01;

public class Main {

    enum CardSuits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public static void main(String[] args) {

        System.out.println("Card Suits:");

        for (CardSuits value : CardSuits.values()) {
            System.out.print("Ordinal value: " + value.ordinal() + "; ");
            System.out.print("Name value: " + value);
            System.out.println();
        }

    }
}