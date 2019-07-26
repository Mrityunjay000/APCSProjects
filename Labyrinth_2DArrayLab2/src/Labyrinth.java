/*
 * Mrityunjay Mishra
 * Mr. Finnegan
 * APCS - 3rd
 * 1 March 2018
 */
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.*;

/*class LabyrinthRunner {

    public static void main(String[] args) {
        Labyrinth lab = new Labyrinth();
        lab.readLabyrinth("data1.txt");
        lab.findPath();
    }
}*/

public class Labyrinth {
    
    JFrame frame;
    JButton[] button;
    int numRows, numCols;
    private final int delay = 250;
    
    private char[][] grid;      // 2D char array
    private int[] start;        // starting square {row, col}
    private int[] exit;         // exiting square {row, col}
    private char wall = 'x';    // character that represents a wall
    private char crumb = '*';   // breadcrumb used to mark the path
    
    private int row = 0;

    public Labyrinth() {
        start = new int[2];     //start[0] = row, start[1] = col
        exit  = new int[2];     //exit[0]  = row, exit[1]  = col  
    }
    
    /** The findPath method finds a way through the labyrinth. Since there is 
     * only one path there is no need to backup and go over previously visited
     * squares. You should use the variable crumb as a bread crumb marking your
     * path through the labyrinth. When you place a crumb in your 2D grid array
     * you should call updateGUI(grid) to display your progress.
     * Precondition:  The 2D array grid has been read in from a file and the 
     *                start and exit have been found.
     * Postcondition: A completed path should have been found.
     */
    public void findPath() {
    	//System.out.println("doing findPath()");
    	int y = 0;
        int cRow = start[0]; // set current row to starting row
        int cCol = start[1]; // set current col to starting col
        grid[cRow][cCol] = crumb;  // drop a bread crumb
        //System.out.println("entered while loop");
        while (y == 0) {//the player will check all four directions and will look for wall, crumb, and " ". When it finds a space the player will move. 
        	//checking right
        	//System.out.println("checking right");
        	if(cCol == grid[cRow].length-1) {
        		;
        	}
        	else {
        		if(Character.toString(grid[cRow][cCol + 1]).equals(" ")) {
        			cCol = cCol + 1;
        			grid[cRow][cCol] = crumb;
        			updateGUI(grid);
        			continue;
        		}
        	}
        	
        	//checking up
        	//System.out.println("checking up");
        	if(cRow == 0) {
        		;
        	}
        	else {
        		if(Character.toString(grid[cRow - 1][cCol]).equals(" ")) {
        			cRow = cRow - 1;
        			grid[cRow][cCol] = crumb;
        			updateGUI(grid);
        			continue;
        		}
        	}
        	
        	//checking left
        	//System.out.println("checking left");
        	if(cCol == 0) {
        		;
        	}
        	else {
        		if(Character.toString(grid[cRow][cCol - 1]).equals(" ")) {
        			cCol = cCol - 1;
        			grid[cRow][cCol] = crumb;
        			updateGUI(grid);
        			continue;
        		}
        	}
        	
        	//checking down
        	//System.out.println("checking down");
        	if(cRow == grid.length-1) {
        		;
        	}
        	else {
        		if(Character.toString(grid[cRow + 1][cCol]).equals(" ")) {
        			cRow = cRow + 1;
        			grid[cRow][cCol] = crumb;
        			updateGUI(grid);
        			continue;
        		}
        	}
        	
        	 // updateGUI needs to be added anytime you place a crumb.
           // updateGUI(grid);
        	
        	if((cRow == exit[0]) && (cCol == exit[1])) {
        		//System.out.println("exited while loop");
        		break;
        	}
        }
        
        //System.out.println("exited while loop");
        
        
        
        
        
        
        
        
       
    
        
    }
    
    /** The findOpenings method finds the two openings (start & exit) in the
     * labyrinth. The start and exit are int arrays with a size of 2. Your 
     * algorithm should randomly choose which of the two openings is
     * the start and which is the exit.
     * Precondition:  There will be only two openings and they can be on any of
     *                the four sides. There will NOT be an opening in a corner.
     * Postcondition: Start & exit should both contain two integers each where
     *                start[0] = row & start[1] = col of the starting square.
     *                exit[0]  = row & exit[1]  = col of the exiting square.
     */
    public void findOpenings() {
        // replace with your algorythym to find these values
    	row = grid.length-1;
    	int x = 0; //a control variable for the while loop.
    	int[] holder = new int[4]; //will hold rand values that have already been generated. Will be compared to, and if rand==holder, then code will go back to generating a new rand.
    	//System.out.println("looping loop");
    	loop:
    	while (x == 0) {
    		int rand = (int)((Math.random()*4)+1);// will determine which row or col to check in order to find the start/end.
    		for(int i = 0; i < holder.length; i++) {
    			if(rand == holder[i]) {
    				continue loop;
    			}
    		}
        	if(rand%2==0) {
        		if(rand == 2) {//checks top row
        			for(int i = 0; i < grid[0].length; i++) {
            			if(Character.toString(grid[0][i]).equals(" ")) {
            				start[0] = 0; 
            				start[1] = i;
            				holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        		else if(rand == 4) {// checks bottom row
        			for(int i = 0; i < grid[row].length; i++) {
            			if(Character.toString(grid[row][i]).equals(" ")) {
            				start[0] = row; 
            				start[1] = i;
            				holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        	}
        	else {
        		if(rand == 1) {// checks first column
        			for(int i = 0; i < row; i++) {
            			if(Character.toString(grid[row][0]).equals(" ")) {
            				start[0] = row; 
            				start[1] = 0;
            				holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        		else if(rand == 3) {// checks last column
        			for(int i = 0; i < row; i++) {
            			if(Character.toString(grid[row][grid[0].length-1]).equals(" ")) {
            				start[0] = row; 
            				start[1] = grid[0].length-1;
            				holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        	}
    	}
    	
    	//System.out.println("looping loop2");
    		loop2:	
    		while (x == 0) {
        		int rand = (int)((Math.random()*4)+1);// will determine which row or col to check in order to find the start/end.
        		//System.out.println(Arrays.toString(holder));
        		for(int i = 0; i < holder.length; i++) {
        			if(rand == holder[i]) {
        				continue loop2;
        			}
        		}
            	if(rand%2==0) {
            		if(rand == 2) {
            			//ystem.out.println("check 1");
            			for(int i = 0; i < grid[0].length; i++) {
                			if(Character.toString(grid[0][i]).equals(" ")) {
                				exit[0] = 0; 
                				exit[1] = i;
                				holder[rand-1] = rand;
                				break loop2;
                			}
                		}
            		}
            		else if(rand == 4) {
            			//System.out.println("check 2");
            			for(int i = 0; i < grid[row].length; i++) {
                			if(Character.toString(grid[row][i]).equals(" ")) {
                				exit[0] = row; 
                				exit[1] = i;
                				holder[rand-1] = rand;
                				break loop2;
                			}
                		}
            		}
            	}
            	else {
            		if(rand == 1) {
            			//System.out.println("check 3");
            			for(int i = 0; i < grid.length; i++) {
            				//System.out.println("inside for loop");
                			if(Character.toString(grid[i][0]).equals(" ")) {
                				exit[0] = i; 
                				exit[1] = 0;
                				holder[rand-1] = rand;
                				break loop2;
                			}
                		}
            		}
            		else if(rand == 3) {
            			//System.out.println("check 4");
            			for(int i = 0; i < grid.length; i++) {
                			if(Character.toString(grid[i][grid[0].length-1]).equals(" ")) {
                				exit[0] = i; 
                				exit[1] = grid[0].length-1;
                				holder[rand-1] = rand;
                				break loop2;
                			}
                		}
            		}
            	}
        	}
    	
    	//System.out.println("exited loop2");
    	
    	
        //start[0] = 0; start[1] = 1;  // replace with your code
        //exit[0] = 11; exit[1] = 13;  // replace with your code

    
    
    
    
    
    
    
    
    
    }

    public void readLabyrinth(String file) {
        try {
            Scanner read = new Scanner(new File(file));
           // System.out.println("reading file");
            int rows = read.nextInt();
            //row = rows;
            grid = new char[rows][];
            read.nextLine();
            for (int i = 0; i < rows; i++) {
                grid[i] = read.nextLine().toCharArray();
            }
            //System.out.println("reading file 2");
            findOpenings();
            
            createGUI(grid, start, exit, wall);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createGUI(char[][] grid, int[] start, int[] exit, char c) {
        numRows = grid.length;
        numCols = grid[0].length;
        frame = new JFrame("Labyrinth");
        button = new JButton[numRows * numCols];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].setFont(new Font("Arial", Font.PLAIN, 30));
            button[i].setBackground(new Color(255, 200, 150));
            if (grid[i / numCols][i % numCols] == wall) {
                button[i].setBackground(new Color(0, 25, 0));
            }
            frame.add(button[i]);
        }
        button[start[0] * numCols + start[1]].setOpaque(true);
        button[start[0] * numCols + start[1]].setBackground(new Color(0, 255, 0));
        button[exit[0] * numCols + exit[1]].setOpaque(true);
        button[exit[0] * numCols + exit[1]].setBackground(new Color(255, 0, 0));
        frame.setLayout(new GridLayout(numRows, numCols));
        frame.setSize(numRows * 60 + 15, numCols * 40 + 15);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateGUI(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 'x')
                    button[row * numCols + col].setText("");
                else
                    button[row * numCols + col].setText("" + grid[row][col]);
            }
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
        }
    }
}