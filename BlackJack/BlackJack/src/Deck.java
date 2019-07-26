//package blackjack;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private Card[] deck;
    private int topCard;
    private static final String[] SUITS = {"H", "D", "S", "C"};

    public Deck() {
        buildDeck();
    }

    public boolean hasNextCard() {
        return (topCard < deck.length);
    }

    public Card dealCard() {
        return hasNextCard() ? deck[topCard++] : null;
    }

    public void shuffleDeck() {
        Collections.shuffle(Arrays.asList(deck));
        topCard = 0;
    }

    private void buildDeck() {
        deck = new Card[52];
        int j = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                deck[j++] = new Card(k + 1, SUITS[i]);
            }
        }
    }

}
