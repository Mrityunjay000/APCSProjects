//package blackjack;

public class Card {

    //instance variables
    private String suit;
    private int face;

    //constructor
    public Card(int f, String s) {
        face = f;
        suit = s;
    }
   
    public int getValue(){
        if (face == 1)
            return 11;
        else if (face > 10)
            return 10;
        else
            return face;
    }

    public String getFace() {
        switch (face) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return face + "";
        }
    }
    
    @Override
    public String toString() {
        return getFace() + suit;
    }
}
