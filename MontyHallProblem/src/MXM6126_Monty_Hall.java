//Name: Mrityunjay Mishra
//Date: 9/22/17
//Lab: Monty Hall Problem

import java.util.Scanner;
import java.math.*;
public class MXM6126_Monty_Hall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int winBySwitch = 0, prize, guess, view = 0, newGuess = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter number of times you want to play: ");
		int numPlays = keyboard.nextInt();
		System.out.println("Prize\tGuess\tView\tNewGuess");
		for(int i = 0; i < numPlays; i++){
			prize = (int)(Math.random() * 3 + 1);
			guess = (int)(Math.random() * 3 + 1);
			if(prize == guess){
				if(prize == 1){
					view = (int)((Math.random()+1)*2);
				}
				if(prize == 2){
					int rand = (int)(Math.random()*2+1);
					if(rand == 1){
						view = 1;
					}
					else{
						view = 3;
					}
				}
				if(prize == 3){
					view = (int)(Math.random()*2+1);
				}
			}
			if(prize != guess){
				if(((prize==1)&&(guess==3)) || ((prize==3)&&(guess==1))){
					view = 2;
				}
				if(((prize==2)&&(guess==3)) || ((prize==3)&&(guess==2))){
					view = 1;
				}
				if(((prize==1)&&(guess==2)) || ((prize==2)&&(guess==1))){
					view = 3;
				}
			}
			
			if(((view==1)&&(guess==3)) || ((view==3)&&(guess==1))){
				newGuess = 2;
			}
			if(((view==2)&&(guess==3)) || ((view==3)&&(guess==2))){
				newGuess = 1;
			}
			if(((view==1)&&(guess==2)) || ((view==2)&&(guess==1))){
				newGuess = 3;
			}
			
			if(newGuess == prize){
				winBySwitch++;
			}
			
			System.out.println(prize+"\t"+guess+"\t"+view+"\t"+newGuess);
			
		}
		
		System.out.println("Probability of winning if you switch: "+((double)winBySwitch/numPlays));
		System.out.println("Probability of winning if you do not switch: "+(1 - ((double)winBySwitch/numPlays)));
		
		
	}

}
