/*
 * Mrityunjay Mishra
 * Mr. Finnegan
 * APCS - 3rd
 * 21 February 2018
 */

import static java.lang.System.*;

import java.util.Arrays;

public class BottomRightColumnRow implements Cipher {
	private String[][] codeBox;
	
	 public String encode(String original) {
		 	double len = Math.ceil(Math.sqrt((double)original.length())); 
		 	int length = (int) len;
		 	//String alt = original;
		 	codeBox = new String [length][length];
		 	for(int r = 0; r < codeBox.length; r++){
		 		for(int c = 0; c < codeBox[r].length; c++){
		 			if(!(original.equals(""))){
		 				codeBox[r][c] = Character.toString(original.charAt(0));
		 			}
		 			else{
		 				codeBox[r][c] = "*";
		 			}
		 			
		 			if(original.length()>1){
		 				original = original.substring(1);
		 			}
		 			else{
		 				original = "";
		 			}
		 		}
		 		//alt = original.substring(r+length);
		 	}
		 	//int row = codeBox.length - 1;
		 	String ans = "";
		 	for(int cols = length-1; cols >=0; cols-- ){//accesses cols first
		 		//System.out.println("cols = " + cols);
		 		for(int r = codeBox.length-1; r >= 0; r--){//accesses rows second.
		 			//System.out.println("rows = " + r);
		 			ans += codeBox[r][cols];
		 		}
		 	}
	        return ans;
	    }

	    public String decode(String encoded) {
	    	String response = "";
	    	double len = Math.sqrt(encoded.length());
	    	int length = (int)len;
	    	codeBox = new String [length][length];
		 	for(int r = 0; r < codeBox.length; r++){
		 		for(int c = 0; c < codeBox[r].length; c++){
		 			codeBox[r][c] = Character.toString(encoded.charAt(0));
		 			if(encoded.length()>1){
		 				encoded = encoded.substring(1);
		 			}
		 			else{
		 				encoded = "";
		 			}
		 		}
		 		//alt = original.substring(r+length);
		 	}
		 	
		 	for(int cols = length-1; cols >=0; cols-- ){//accesses cols first
		 		//System.out.println("cols = " + cols);
		 		for(int r = codeBox.length-1; r >= 0; r--){//accesses rows second.
		 			//System.out.println("rows = " + r);
		 			if(!(codeBox[r][cols].equals("*"))){
		 				response += codeBox[r][cols];
		 			}
		 			
		 		}
		 	}
	        return response;
	    }

}
