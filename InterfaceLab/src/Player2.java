//Aarya Atluri axa8089
/*
 * Mrityunjay Mishra, Aarya Atluri
 * Mr. Finnegan
 * AP Computer Science 
 * 17 January 2018
 * 
 */




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player2 implements PlayerAPI{
	//private List<Integer> movesLeft = new ArrayList<Integer>(); //for moves left on the board; will be amended after every turn.
	//private List <String> opponentWinCombos = new ArrayList<String>(); //for knowing combos through which the opponent can win; will be amended every time the computer goes through.
	private final String[] winCombos = {"012","345","678","036","147","258","048","246"}; //for the computer to know what possible combinations it can win through.
	//private String previousOppMoves = "";
	private String totalMovesMade = "";
	private int[] board;
	private String playerType;
	private int playerTracker = 0; //for tracking if p1 or p2 is playing.
	private int numMoves = 0; //for tracking how many moves have been made. moves is defined as the sum of every decision made by each player. 
	private String myPreviousMoves = ""; //this is basically going to keep track of the moves made by this player by accessing array board each turn.
	private String oppPreviousMoves = ""; //this is basically going to keep track of the moves made by the other player by accessing array board each turn. 
	
	
	Scanner kb = new Scanner(System.in);
	
	public Player2 (){
		checkPlayerType();
	}
	
	public int getMove() {
		int oppNum = 0;
		if(playerTracker % 2 == 0){
			oppNum = 1;
		}
		else{
			oppNum = 2;
		}
		//System.out.println("playerTracker = "+ playerTracker); --- oppNum works fine do not mess with it. 
		//System.out.println("oppNum = " + oppNum);
		if(playerType.equals("H")){
			System.out.println("What is your next move? (Please put in an answer from 0-8): ");
			int response = kb.nextInt();
			return response;
		}
		else{
			for(int i = 0; i < board.length; i++){ //this loop works do not mess with it. 
				if(board[i] != 0){
					totalMovesMade = totalMovesMade + i;
				}
			}
			int response = 0;
			//System.out.println("numMoves = " + numMoves); ---- numMoves is working correctly do not mess with it. 
			if(numMoves == 1){
				response = 4;
				//System.out.println("response 1");
				return response;
			}
			else if(numMoves == 2){
				if(board[4] == oppNum){
					response = 0; 
					//System.out.println("response 2");
					return response;
				}
			}
				
			else{
				//--------------------------------------------------------------------------------	
				//combination check for this player.
				//checking board horizontally for this player
				for(int i = 0; i < 3; i++){ // loop numbers (relation of j and g) works, do not mess with it. Logic not yet checked. 
					int g = (i*3) + 3;
					for(int j = i*3; j < g; j++){
						if((board[j] != oppNum) && (board[j] != 0)){
							myPreviousMoves = myPreviousMoves + j;
							//System.out.println("myPrevioiusMoves = " + myPreviousMoves);
							if(myPreviousMoves.length()>=2){
								//System.out.println("i entered if - 1");
								for(int x = 0; x < winCombos.length; x++){
									if((winCombos[x].contains(Character.toString(myPreviousMoves.charAt(0)))) && ((winCombos[x].contains(Character.toString(myPreviousMoves.charAt(1)))))){
										//System.out.println("winCombos[x] = " + winCombos[x]);          //--------
										String holder = winCombos[x];
										holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(0)), "");
										//System.out.println("holder = " + holder);          //--------
										holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(1)), "");
										//System.out.println("holder = " + holder);          //--------
										response = Integer.parseInt(holder);
										String resp = "" + response;
										//System.out.println("resp = " + resp);          //--------
										if(totalMovesMade.contains(resp)){
											break; //if this does not work, then break out of the outer loop.
										}
										totalMovesMade = "";
										myPreviousMoves = "";
										//System.out.println("response 3");
										return response;
									}
								}
							}
						}
					}
					myPreviousMoves = "";
				}
				
				//checking board vertically for this player
				for(int i = -3; i < 0; i++){ // loop numbers (relation of j and g) works, do not mess with it. Logic not yet checked. 
					int g = (i+3) + 7;
					for(int j = i + 3; j < g; j = j + 3){
						if((board[j] != oppNum) && (board[j] != 0)){
							myPreviousMoves = myPreviousMoves + j;
							//System.out.println("myPrevioiusMoves = " + myPreviousMoves);
							if(myPreviousMoves.length()>=2){
								//System.out.println("i entered if - 2");
								for(int x = 0; x < winCombos.length; x++){
									if((winCombos[x].contains(Character.toString(myPreviousMoves.charAt(0)))) && ((winCombos[x].contains(Character.toString(myPreviousMoves.charAt(1)))))){
										//System.out.println("winCombos[x] = " + winCombos[x]);          //--------
										String holder = winCombos[x];
										holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(0)), "");
										//System.out.println("holder = " + holder);          //--------
										holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(1)), "");
										//System.out.println("holder = " + holder);          //--------
										response = Integer.parseInt(holder);
										String resp = "" + response;
										//System.out.println("resp = " + resp);          //--------
										if(totalMovesMade.contains(resp)){
											break; //if this does not work, then break out of the outer loop.
										}
										totalMovesMade = "";
										myPreviousMoves = "";
										//System.out.println("response 4");
										return response;
									}
								}
							}
						}
					}
					myPreviousMoves = "";
				}
				//checking board diagonally (048) for this player
				if((board[0] != oppNum)&&(board[0] != 0)){
					myPreviousMoves = myPreviousMoves + 0;
				}
				if((board[4] != oppNum)&&(board[4] != 0)){
					myPreviousMoves = myPreviousMoves + 4;
				}
				if((board[8] != oppNum)&&(board[8] != 0)){
					myPreviousMoves = myPreviousMoves + 8;
				}
				if(myPreviousMoves.length()>=2){
					for(int x = 0; x < winCombos.length; x++){
						if(winCombos[x].contains(myPreviousMoves)){
							String holder = winCombos[x];
							holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(0)), "");
							holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(1)), "");
							response = Integer.parseInt(holder);
							String resp = "" + response;
							if(totalMovesMade.contains(resp)){
								break; //if this does not work, then break out of the outer loop.
							}
							totalMovesMade = "";
							myPreviousMoves = "";
							//System.out.println("response 5");
							return response;
						}
					}
				}
				else{
					//System.out.println("entered loop 3 but failed; myPreviousMoves = " + myPreviousMoves);
					myPreviousMoves = "";
				}
				//checking board diagonally (246) for this player
				if((board[2] != oppNum)&&(board[2] != 0)){
					myPreviousMoves = myPreviousMoves + 2;
				}
				if((board[4] != oppNum)&&(board[4] != 0)){
					myPreviousMoves = myPreviousMoves + 4;
				}
				if((board[6] != oppNum)&&(board[6] != 0)){
					myPreviousMoves = myPreviousMoves + 6;
				}
				if(myPreviousMoves.length()>=2){
					for(int x = 0; x < winCombos.length; x++){
						if(winCombos[x].contains(myPreviousMoves)){
							String holder = winCombos[x];
							holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(0)), "");
							holder = holder.replaceAll(Character.toString(myPreviousMoves.charAt(1)), "");
							response = Integer.parseInt(holder);
							String resp = "" + response;
							if(totalMovesMade.contains(resp)){
								break; //if this does not work, then break out of the outer loop.
							}
							totalMovesMade = "";
							myPreviousMoves = "";
							//System.out.println("response 6");
							return response;
						}
					}
				}
				else{
					//System.out.println("entered loop 4 but failed; myPreviousMoves = " + myPreviousMoves);
					myPreviousMoves = "";
				}
				//-----------------------------------------------------------------------------------
				
				//--------------------------------------------------------------------------------	
				//combination check for other player.
				//checking board horizontally for other player
				for(int i = 0; i < 3; i++){
					int g = (i*3) +3;
					for(int j = i*3; j < g; j++){ // loop numbers (relation of j and g) works, do not mess with it. Logic not yet checked. 
						if(board[j] == oppNum){
							oppPreviousMoves = oppPreviousMoves + j;
							//System.out.println("oppPrevioiusMoves = " + oppPreviousMoves);
							if(oppPreviousMoves.length()>=2){
								//System.out.println("i entered if - 3");
								for(int x = 0; x < winCombos.length; x++){
									if((winCombos[x].contains(Character.toString(oppPreviousMoves.charAt(0)))) && (winCombos[x].contains(Character.toString(oppPreviousMoves.charAt(1))))){
										//System.out.println("winCombos[x] = " + winCombos[x]);          //--------
										String holder = winCombos[x];
										holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(0)), "");
										//System.out.println("holder = " + holder);          //--------
										holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(1)), "");
										//System.out.println("holder = " + holder);          //--------
										response = Integer.parseInt(holder);
										String resp = "" + response;
										//System.out.println("resp = " + resp);          //--------
										if(totalMovesMade.contains(resp)){
											break; //if this does not work, then break out of the outer loop.
										}
										totalMovesMade = "";
										oppPreviousMoves = "";
										//System.out.println("response 7");
										return response;
									}
								}
							}
						}
					}
					oppPreviousMoves = "";
				}
				//checking board vertically for other player
				for(int i = -3; i < 0; i++){
					int g = (i+3) + 7;
					for(int j = i + 3; j < g; j = j + 3){
						if(board[j] == oppNum){
							oppPreviousMoves = oppPreviousMoves + j;
							//System.out.println("oppPrevioiusMoves = " + oppPreviousMoves);
							if(oppPreviousMoves.length()>=2){
								//System.out.println("i entered if - 4");
								for(int x = 0; x < winCombos.length; x++){
									if((winCombos[x].contains(Character.toString(oppPreviousMoves.charAt(0)))) && (winCombos[x].contains(Character.toString(oppPreviousMoves.charAt(1))))){
									//	System.out.println("winCombos[x] = " + winCombos[x]);          //--------
										String holder = winCombos[x];
										holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(0)), "");
									//	System.out.println("holder = " + holder);          //--------
										holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(1)), "");
										//System.out.println("holder = " + holder);          //--------
										response = Integer.parseInt(holder);
										String resp = "" + response;
										//System.out.println("resp = " + resp);          //--------
										if(totalMovesMade.contains(resp)){
											break; //if this does not work, then break out of the outer loop.
										}
										totalMovesMade = "";
										oppPreviousMoves = "";
										//System.out.println("response 8");
										return response;
									}
								}
							}
						}
					}
					oppPreviousMoves = "";
				}
				//checking board diagonally (048) for other player
				if(board[0] == oppNum){
					oppPreviousMoves = oppPreviousMoves + 0;
				}
				if(board[4] == oppNum){
					oppPreviousMoves = oppPreviousMoves + 4;
				}
				if(board[8] == oppNum){
					oppPreviousMoves = oppPreviousMoves + 8;
				}
				if(oppPreviousMoves.length()>=2){
					for(int x = 0; x < winCombos.length; x++){
						if(winCombos[x].contains(oppPreviousMoves)){
							String holder = winCombos[x];
							holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(0)), "");
							holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(1)), "");
							response = Integer.parseInt(holder);
							String resp = "" + response;
							if(totalMovesMade.contains(resp)){
								break; //if this does not work, then break out of the outer loop.
							}
							totalMovesMade = "";
							oppPreviousMoves = "";
							//System.out.println("response 9");
							return response;
						}
					}
				}
				else{
					//System.out.println("entered loop 7 but failed; oppPreviousMoves = " + oppPreviousMoves);
					oppPreviousMoves = "";
				}
				//checking board diagonally (246) for other player
				if(board[2] == oppNum){
					oppPreviousMoves = oppPreviousMoves + 2;
				}
				if(board[4] == oppNum){
					oppPreviousMoves = oppPreviousMoves + 4;
				}
				if(board[6] == oppNum){
					oppPreviousMoves = oppPreviousMoves + 6;
				}
				if(oppPreviousMoves.length()>=2){
					for(int x = 0; x < winCombos.length; x++){
						if(winCombos[x].contains(oppPreviousMoves)){
							String holder = winCombos[x];
							holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(0)), "");
							holder = holder.replaceAll(Character.toString(oppPreviousMoves.charAt(1)), "");
							response = Integer.parseInt(holder);
							String resp = "" + response;
							if(totalMovesMade.contains(resp)){
								break; //if this does not work, then break out of the outer loop.
							}
							totalMovesMade = "";
							oppPreviousMoves = "";
							//System.out.println("response 10");
							return response;
						}
					}
				}
				else{
					//System.out.println("entered loop 8 but failed; oppPreviousMoves = " + oppPreviousMoves);
					oppPreviousMoves = "";
				}
				//-----------------------------------------------------------------------------------
				
			}
		//so far i have done winning and countering if both the players have 2 moves in each orientation. next step is to solve if there is only 1 move by the other player. 
			for(int i = 0; i < board.length; i++){
				if((board[i] != oppNum)&&(board[i] != 0)){
					myPreviousMoves = myPreviousMoves + i;
				}
			}
			for(int i = 0; i < board.length; i++){
				if(board[i] == oppNum){
					oppPreviousMoves = oppPreviousMoves + i;
				}
			}
			/*for(int i = 0; i < board.length; i++){ //this loop works do not mess with it. 
				if(board[i] != 0){
					totalMovesMade = totalMovesMade + i;
				}
			}*/
			//System.out.println("myPreviousMoves = " + myPreviousMoves);
			//System.out.println("oppPreviousMoves = " + oppPreviousMoves);
			//System.out.println("totalMovesMade = " + totalMovesMade);
			int a = 0;
			while(a==0){
				String get = "" + ((int)((Math.random() * 8) + 1)); //this string just generates a random move; it works correctly do not mess with it.  
				//System.out.println("get = " + get);
				if(myPreviousMoves.contains(get)){
					response = Integer.parseInt(get); //converting the string to an int.
					if(response == 1){
						response = response + 1;
						get = "" + response;
						if(totalMovesMade.contains(get)){
							continue;
						}
						else{
							myPreviousMoves = "";
							oppPreviousMoves = "";
							totalMovesMade = "";
							a = 1;
							//System.out.println("response 11");
							return response;
						}
					}
					else if(response == 8){
						response = response - 1;
						get = "" + response;
						if(totalMovesMade.contains(get)){
							continue;
						}
						else{
							myPreviousMoves = "";
							oppPreviousMoves = "";
							totalMovesMade = "";
							a = 1;
							//System.out.println("response 12");
							return response;
						}
					}
					else{
						response = response  + 1;
						get = "" + response;
						if(totalMovesMade.contains(get)){
							continue;
						}
						else{
							myPreviousMoves = "";
							oppPreviousMoves = "";
							totalMovesMade = "";
							a = 1;
							//System.out.println("response 13");
							return response;
						}
					}
				}
				else if(oppPreviousMoves.contains(get)){
					response = Integer.parseInt(get); //converting the string to an int.
					if(response == 1){
						response = response + 1;
						get = "" + response;
						if(totalMovesMade.contains(get)){
							continue;
						}
						else{
							myPreviousMoves = "";
							oppPreviousMoves = "";
							totalMovesMade = "";
							a = 1;
							//System.out.println("response 14");
							return response;
						}
					}
					else if(response == 8){
						response = response - 1;
						get = "" + response;
						if(totalMovesMade.contains(get)){
							continue;
						}
						else{
							myPreviousMoves = "";
							oppPreviousMoves = "";
							totalMovesMade = "";
							a = 1;
							//System.out.println("response 15");
							return response;
						}
					}
					else{
						response = response  + 1;
						get = "" + response;
						if(totalMovesMade.contains(get)){
							continue;
						}
						else{
							myPreviousMoves = "";
							oppPreviousMoves = "";
							totalMovesMade = "";
							a = 1;
							//System.out.println("response 16");
							return response;
						}
					}
				}
				else{
					myPreviousMoves = "";
					oppPreviousMoves = "";
					totalMovesMade = "";
					response = Integer.parseInt(get);
					a = 1;
					//System.out.println("response 17");
					return response;
				}
			}
		}
		return 0;
	}
	public void checkPlayerType() {
		System.out.println("Is the player human or CPU? (H or C): ");
		playerType = kb.nextLine().toString();
		
	}
	public String returnPlayerType() {
		return playerType;
	}
	public void getBoard(int[] a, int b, int c) {
		board = new int[a.length];
		for(int i = 0; i < a.length; i++){
			board[i] = a[i];
		}
		playerTracker = b;
		numMoves = c;	
	}
}
