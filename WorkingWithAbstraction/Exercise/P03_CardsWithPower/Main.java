package WorkingWithAbstraction.Exercise.P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        CardRanks cardRanks = CardRanks.valueOf(rank);
        CardSuits cardSuits = CardSuits.valueOf(suit);

        int power = cardRanks.getPower() + cardSuits.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d%n", rank, suit, power);
    }
}
