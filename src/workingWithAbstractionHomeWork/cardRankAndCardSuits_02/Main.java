package workingWithAbstractionHomeWork.cardRankAndCardSuits_02;
import java.util.Scanner;
public class Main {
    enum CardSuits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    enum CardRanks {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public static void main(String[] args) {

      String command = new Scanner(System.in).nextLine();
      if(command.equals("Card Suits")){
          System.out.println("Card Suits:");
          printEnumOrdinalsAndNames(CardSuits.values());
      } else if(command.equals("Card Ranks")){
          System.out.println("Card Ranks:");
          printEnumOrdinalsAndNames(CardRanks.values());
      }
    }

    static <E extends Enum<E>> void printEnumOrdinalsAndNames(Enum<E>[] values) {
        for (Enum<E> value : values) {
            System.out.print("Ordinal value: " + value.ordinal() + "; ");
            System.out.print("Name value: " + value);
            System.out.println();
        }
    }
}
