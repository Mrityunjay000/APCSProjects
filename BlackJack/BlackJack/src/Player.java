//package BlackJack;

import java.util.Scanner;

public class Player {

    private Card[] hand;
    private int playerNumber;
    private int numCards;
    private int numAces;
    private int total;
    private Boolean isComputer;
    private Scanner kb;

    public Player(int num, boolean computer) {
        playerNumber = num;
        hand         = new Card[10];
        numCards     = 0;
        numAces      = 0;
        total        = 0;
        isComputer   = computer;
        kb = new Scanner(System.in);
    }

    public void getCard(Card c) {
        hand[numCards] = c;
        total += hand[numCards].getValue();

        // count the number of Aces
        if (hand[numCards].getValue() == 11) {
            numAces++;
        }

        // change Ace value from 11 to 1 if player is over 21
        if (total > 21 && numAces > 0) {
            total -= 10;
            numAces--;
        }
        numCards++;
    }

    // player automatically hits if they have less than 17
    public boolean isHit() {
        if (isComputer) 
            return (total < 17);
        System.out.println(toString());
        System.out.print("press 'H' to hit or 'S' to stay: ");
        String move = kb.next();

        return (move.equals("H") || move.equals("h"));
    }

    // returns the total value for all the players cards
    public int getTotal() {
        return total;
    }

    // reset players hand for a new game
    public void resetPlayer() {
        numCards = 0;
        numAces  = 0;
        total    = 0;
    }

    // check to see if player has BlackJack win ( "A" and 10)
    public boolean hasBlackJack() {
        return ((hand[0].getValue() == 11 && hand[1].getValue() == 10)
                || (hand[0].getValue() == 10 && hand[1].getValue() == 11));
    }

    // returns all the players cards as a String
    @Override
    public String toString() {
        String s = "Player " + playerNumber + ":\tCards: ";
        for (int i = 0; i < numCards; i++) {
            s += hand[i].toString() + " ";
        }
        return s;
    }
}
