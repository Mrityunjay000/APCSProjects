/*
 * Mrityunjay Mishra
 * Mr. Finnegan 
 * APCS - 3rd
 * 1 December 2017
 */
import java.util.Arrays;
import java.util.Collections;

public class MXM6126Deck {
	//instance variables
	private MXM6126Card [] deck;
	private static final String[] SUITS = {"H", "D", "S", "C"};

	//constructor
	public MXM6126Deck() {
	    buildDeck();
	}

	//Fills the deck array with card objects
	private void buildDeck() { 
	    deck = new MXM6126Card[52];
	    int j = 0;
	    for (int i = 0; i < 4; i++) {
	        for (int k = 0; k < 13; k++) {
	            deck[j++] = new MXM6126Card(k+1, SUITS[i]);
	        }
	    }
	}

	//Displays the entire deck in 4 rows with 13 cards in each row.
	public void showDeck(){
	    // your code goes here. 
		int j = 0;
		for (int i = 0; i < 4; i++) {
	        for (int k = 0; k < 13; k++) {
	            System.out.print(deck[j++] + " ");
	        }
	        System.out.println();
	    }
	}

	//Shuffles the array
	public void shuffleDeck(){
	    //Collections.shuffle(Arrays.asList(deck));
		System.out.println();
	    Collections.shuffle(Arrays.asList(deck));
	}
}
