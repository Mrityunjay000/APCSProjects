/*
 * Mrityunjay Mishra
 * Mr. Finnegan 
 * APCS - 3rd
 * 1 December 2017
 */
public class MXM6126Card {
	//instance variables
	private int face;
	private String suit;

	//constructor
	public MXM6126Card (int f, String s) {
	    // your code goes here
		face = f;
		suit = s;
	}

	//getter methods
	public String getFace(){       // returns the face of the card (A,2-10,J-K)
	    // your code goes here. You will need to use the instance variable face along with 
	    // a few if statements inorder to return (A,2-10,J-K). For example, if (face == 11) return "J";
		if(face == 1){
			return "A";
		}
		if(face == 2){
			return "2";
		}
		if(face == 3){
			return "3";
		}
		if(face == 4){
			return "4";
		}
		if(face == 5){
			return "5";
		}
		if(face == 6){
			return "6";
		}
		if(face == 7){
			return "7";
		}
		if(face == 8){
			return "8";
		}
		if(face == 9){
			return "9";
		}
		if(face == 10){
			return "10";
		}
		if(face == 11){
			return "J";
		}
		if(face == 12){
			return "Q";
		}
		if(face == 13){
			return "K";
		}
		else{
			return "";
		}
		
	}

	public int getFaceValue(){      // returns the value of the card (1-13)
	    // your code goes here
		return face;
	}

	public String getSuit(){       // returns the suit (H,D,S,C)
	    // your code goes here
		return suit;
	}


	//toString
	public String toString() {
	    return getFace() + suit;
	}
}
