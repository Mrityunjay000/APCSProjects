//package blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackRunner {

    public static void main(String args[]) {

        BlackJackGame game = new BlackJackGame();
        do {
            game.playGame();
        } while (playAgain());
    }

    public static boolean playAgain() {
        Scanner kb = new Scanner(System.in);
        do {
            try {
                System.out.print("\n\nPlay again (y or n)? ");
                String ans = kb.next();
                System.out.println("");
                return (ans.equals("Y") || ans.equals("y"));
            } catch (InputMismatchException e) {
                kb.nextLine();
            }
            System.out.println("Please try again.");
        } while (true);
    }
}
