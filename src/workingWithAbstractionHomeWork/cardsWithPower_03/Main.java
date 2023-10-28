package workingWithAbstractionHomeWork.cardsWithPower_03;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
        String stringRank = scanner.nextLine();
        String stringSuit = scanner.nextLine();

        Card.Rank rank = Card.Rank.valueOf(stringRank);
        Card.Suit suit = Card.Suit.valueOf(stringSuit);
        
        Card card = new Card(rank, suit);

        System.out.println("Card name: "+ card.getName() + "; Card power: " + card.getPower());

    }

}
