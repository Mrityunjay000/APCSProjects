//package blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackGame {

    private static final int MAXPLAYERS = 5;
    private Deck deck;
    private int numPlayers;
    private Player[] player;

    public BlackJackGame() {
        deck = new Deck();
        deck.shuffleDeck();
        createPlayers();
    }

    public void playGame() {

        resetGame();
        int winningHand = 0;

        // Deal first two cards to each player
        for (int i = 0; i < numPlayers; i++) {
            player[i].getCard(deck.dealCard());
            player[i].getCard(deck.dealCard());
            System.out.print(player[i].toString() + "\n");
        }

        // Check for BlackJack winner Ace & 10
        System.out.println();
        String blackJackWinner = checkForBlackJackWin();
        if (blackJackWinner.length() > 0) {
            System.out.print(blackJackWinner);
            return;
        }

        // Ask each player of they want to hit or stay (get an additional card(s) )
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + (i + 1) + ":\t");
            while (player[i].getTotal() < 21 && player[i].isHit()) {
                System.out.print("hit, ");
                player[i].getCard(deck.dealCard());
            }
            System.out.print("stay\n");

            // show each players cards, totals and if they bust (went over 21)
            System.out.print(player[i].toString() + "\tTotal = " + player[i].getTotal());
            if (player[i].getTotal() > 21) {
                System.out.print(" - Bust");
            } else if (player[i].getTotal() > winningHand) {
                winningHand = player[i].getTotal();
            }
            System.out.println("\n");
        }

        // Output winners (closed to 21 without going over)
        if (winningHand == 0) {
            System.out.println("All Players Bust.");
        } else {
            System.out.print("WINNER(s):\t");
            for (int i = 0; i < numPlayers; i++) {
                if (player[i].getTotal() == winningHand) {
                    System.out.print("Player " + (i + 1) + "\t");
                }
            }
        }

    }

    private void resetGame() {
        deck.shuffleDeck();
        for (int i = 0; i < numPlayers; i++) {
            player[i].resetPlayer();
        }
    }

    private String checkForBlackJackWin() {
        String output = "";
        for (int i = 0; i < numPlayers; i++) {
            if (player[i].hasBlackJack()) {
                output += "BLACKJACK!\tPlayer " + (i + 1) + "\n";
            }
        }
        return output;
    }

    private void createPlayers() {
        System.out.println("Weclcome to BlackJack");
        numPlayers = getNumberOfPlayers(MAXPLAYERS) + 1;

        player = new Player[numPlayers];
        player[0] = new Player(1, false);           // human player   
        for (int i = 1; i < numPlayers; i++) {
            player[i] = new Player(i + 1, true);    // computer player(s)
        }
    }

    private int getNumberOfPlayers(int maxNum) {
        Scanner kb = new Scanner(System.in);
        do {
            try {
                System.out.print("Please enter the number of computer players (1-" + maxNum + "): ");
                int num = kb.nextInt();
                if (num > 0 && num <= maxNum) {
                    return num;
                }
            } catch (InputMismatchException e) {
                kb.nextLine();
            }
            System.out.println("Please try again.");
        } while (true);
    }

}
