import java.util.Arrays;
import java.util.Scanner;

public class player implements PlayerAPI{
	private int[] board;
	private int playerTrack = 0;
	private String possible = "";
	private String previousCompMoves = "";
	private String previousHumanMoves = "";
	private String opponentMove = "";
	private int lastMove;
	private int gameTracker = 0;
	private String playerType;
	private final String[] winCombos = {"012","345","678","036","147","258","048","246"};
	Scanner kb = new Scanner(System.in);
	public player (){
		checkPlayerType();
	}
	
	public int getMove() {
		gameTracker++;
		System.out.println("This is gameTracker " + gameTracker);
		if(playerType.equals("H")){
			System.out.println("What is your next move? (Please put in an answer from 0-8): ");
			int response = kb.nextInt();
			return response;
		}
		else{
			int response = 0;
			int ctr = 0;
			for(int i = 0; i < board.length; i++){
				if(board[i] == 0){
					ctr++;
				}
			}
			if(ctr == 9){
				response = 4;
				previousCompMoves = previousCompMoves + response;
				return response;
			}
			if(gameTracker == 1){
				if(lastMove == 4){
					response = 0;
					previousCompMoves = previousCompMoves + response;
					return response;
				}
			}
			
			loop3:
			for(int i = 0; i < winCombos.length; i++){
				if(opponentMove.length() == 1){
					
					//---------------------this block of code checks to see if there are any combos that may be missed due to the ordered search for the win combos. 
					if(playerTrack%2==0){
						
						for(int b = 0; b < board.length; b++){
							if(board[b] == 1 && (b!=Integer.parseInt(opponentMove))){
								possible = possible + b;
							}
						}
					}
					else{
						for(int b = 0; b < board.length; b++){
							if(board[b] == 2 && (b!=Integer.parseInt(opponentMove))){
								possible = possible + b;
							}
						}
					}
					
					loop2:
					for(int j = 0; j < possible.length(); j++){
						for(int r = 0; r < winCombos.length; r++){
							if(winCombos[r].contains(Character.toString(possible.charAt(j))) && winCombos[r].contains(opponentMove)){
								i = r;
								break loop2;
							}
						}
					}
					//------------------------
					
					if(winCombos[i].contains(Character.toString(opponentMove.charAt(0)))){
						loop:
						for(int x = 0; x < winCombos[i].length(); x++){
							String check = Character.toString(winCombos[i].charAt(x));
							if(!(check.equals(Character.toString(opponentMove.charAt(0))))){
								response = Integer.parseInt(check);
								
								for(int a = 0; a < previousCompMoves.length(); a++){
									if(check.equals(Character.toString(previousCompMoves.charAt(a)))){
										
										continue loop;
									}
								}
								
								for(int a = 0; a < previousHumanMoves.length(); a++){
									if(check.equals(Character.toString(previousHumanMoves.charAt(a)))){
										
										continue loop;
									}
								}
								previousCompMoves = previousCompMoves + response;
								return response;
							}
						}
					}
				}
				else{
					
					System.out.println("This is opponentMove " + opponentMove);
					if(winCombos[i].contains(Character.toString(opponentMove.charAt(0))) && winCombos[i].contains(Character.toString(opponentMove.charAt(opponentMove.length()-1)))){
						String fin = winCombos[i];
						
						fin = fin.replaceAll(Character.toString(opponentMove.charAt(0)), "");
					
						fin = fin.replaceAll(Character.toString(opponentMove.charAt(opponentMove.length()-1)), "");
						
						response = Integer.parseInt(fin);
						for(int a = 0; a < previousCompMoves.length(); a++){
							if(fin.equals(Character.toString(previousCompMoves.charAt(a)))){
								continue loop3;
							}
						}
						for(int a = 0; a < previousHumanMoves.length(); a++){
							if(fin.equals(Character.toString(previousHumanMoves.charAt(a)))){
								
								continue loop3;
							}
						}
						previousCompMoves = previousCompMoves + response;
						System.out.println("This happened");
						opponentMove = "";
						System.out.println("This is the second opponentMove " + opponentMove);
						return response;
					}
				}
			}
			return 0;
		}
		
	}
	

	public void checkPlayerType() {
		System.out.println("Is the player human or CPU? (H or C): ");
		playerType = kb.nextLine().toString();
		
	}
	public String returnPlayerType() {
		return playerType;
	}
	public void getBoard(int[] a, int z, int c) {
		
		board = new int[9];
		for(int i = 0; i < a.length; i++){
			board[i] = a[i];
		}
		lastMove = z;
		System.out.println("this is z " + z);
		if(z!=0){
			opponentMove = "" + opponentMove + z;
		}
		previousHumanMoves = previousHumanMoves + z;
		playerTrack = c;
		
		
		
		
	}

	
	
}
