/*
 * Mrityunjay Mishra, Aarya Atluri
 * Mr. Finnegan
 * AP Computer Science 
 * 17 January 2018
 * 
 */
import java.util.Arrays;
//move specific. 
public class game implements GameAPI {
	private static int[] gameBoard;
	private static int x = -1;
	private int answer = 0;
	private int numMoves = 0; //for tracking how many moves have been made. moves is defined as the sum of every decision made by each player. 
	public game(){
		gameBoard = new int[9];
		Player2 p1 = new Player2();
		Player2 p2 = new Player2();
		int tracker = 1;
		while(x!=1){
			numMoves++;
			startGame(p1, tracker, numMoves);
			tracker++;
			if(x==1){
				System.out.print("This is the final game board: p1 wins!   \n");
				System.out.println(printBoard());
				break; 
			}
			if(x==2){
				System.out.println("Tie Game");
				System.out.println(printBoard());
				break; 
			}
			numMoves++;
			startGame(p2, tracker, numMoves);
			tracker++;
			if(x==1){
				System.out.print("This is the final game board: p2 wins!   \n");
				System.out.println(printBoard());
				break; 
			}
			if(x==2){
				System.out.println("Tie Game");
				System.out.println(printBoard());
				break; 
			}
		}
		
	}
	
	public int[] getGameBoard(){
		int[] copyGameBoard = new int[gameBoard.length];
		for(int i = 0; i < gameBoard.length; i++){
			copyGameBoard[i] = gameBoard[i];
		}
		return copyGameBoard;
	}
	
	private String printBoard()
	{
		String output = "" + gameBoard[0] + gameBoard[1] + gameBoard[2] + "\n" + gameBoard[3] + gameBoard[4] + gameBoard[5] + "\n" + gameBoard[6] + gameBoard[7] + gameBoard[8] + "\n";
		return output;
	}
	private void startGame(Player2 p, int y, int z){
		String player = p.returnPlayerType();
		if(player.equals("H")){
			System.out.println(printBoard());
			int ans = p.getMove();
			answer = ans;
			//System.out.println(answer + " " + ans);
			if(y%2!=0){
				gameBoard[ans] = 1;
				//System.out.println(printBoard());
			}
			else{
				gameBoard[ans] = 2;
			}
			if(y>=5){
				if(checkGame()){
					x = 1;
				}
			}
			
		}
		else{
			//System.out.println("now im here");
			//////////////System.out.println(printBoard()); //just to see what the computer is doing.
			p.getBoard(gameBoard, y, z);
			int ans = p.getMove();
			answer = ans;
			if(y%2!=0){
				//System.out.println("ans = " + ans);
				gameBoard[ans] = 1;
			}
			else{
				gameBoard[ans] = 2;
			}
			if(y>=5){
				if(checkGame()){
					x = 1;
					//System.out.println("check game");
				}
			}
		}
		
	}
	private boolean checkGame(){
		if(gameBoard[0]!=0 && gameBoard[1]!=0 && gameBoard[2]!=0){
			if(gameBoard[0]==gameBoard[1] && gameBoard[1]==gameBoard[2]){
				//System.out.println("check 1");
				return true;
			}	
		}
		if(gameBoard[3]!=0 && gameBoard[4]!=0 && gameBoard[5]!=0){
			if(gameBoard[3]==gameBoard[4] && gameBoard[4]==gameBoard[5]){
				//System.out.println("check 2");
				return true;
			}
		}
		if(gameBoard[6]!=0 && gameBoard[7]!=0 && gameBoard[8]!=0){
			if(gameBoard[6]==gameBoard[7] && gameBoard[7]==gameBoard[8]){
				//System.out.println("check 3");
				return true;
			}
		}
		if(gameBoard[0]!=0 && gameBoard[3]!=0 && gameBoard[6]!=0){
			if(gameBoard[0]==gameBoard[3] && gameBoard[3]==gameBoard[6]){
				//System.out.println("check 4");
				return true;
			}
		}
		if(gameBoard[1]!=0 && gameBoard[4]!=0 && gameBoard[7]!=0){
			if(gameBoard[1]==gameBoard[4] && gameBoard[4]==gameBoard[7]){
				//System.out.println("check 5");
				return true;
			}
		}
		if(gameBoard[2]!=0 && gameBoard[5]!=0 && gameBoard[8]!=0){
			if(gameBoard[2]==gameBoard[5] && gameBoard[5]==gameBoard[8]){
				//System.out.println("check 6");
				return true;
			}
		}
		if(gameBoard[0]!=0 && gameBoard[4]!=0 && gameBoard[8]!=0){
			if(gameBoard[0]==gameBoard[4] && gameBoard[4]==gameBoard[8]){
				//System.out.println("check 7");
				return true;
			}
		}
		if(gameBoard[2]!=0 && gameBoard[4]!=0 && gameBoard[6]!=0){
			if(gameBoard[2]==gameBoard[4] && gameBoard[4]==gameBoard[6]){
				//System.out.println("check 8");
				return true;
			}
		}
		if(numMoves == 9){
			/*int ctr = 0;
			for(int i = 0; i < gameBoard.length; i++){
				if(gameBoard[i]!=0){
					ctr++;
				}
			}
			if(ctr==9){
				x=2;
			}
			return false;*/
			//System.out.println("I entered this loop. numMoves = " + numMoves);
			x = 2;
			return false;
		}
		return false;
	}
}
