/*
 * Name    : Mishra, Mrityunjay
 * User ID : mxm6126
 * Lab #   : 2 (Recursion)
 */

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

public class Maze {

    public static void main(String[] args) {
        MazeGUI maze = new MazeGUI();
    }
}

class MazeGUI {

    JFrame frame;
    JButton[] button;
    int numRows, numCols;
    private final int delay = 100;
    private String mazeFile = "maze3.txt";
    private char[][] grid;      // 2D char array
    private int[] start;        // starting square {row, col}
    private int[] exit;         // exiting square {row, col}
    private char wall = 'X';    // character that represents a wall
    private char crumb = 'o';   // breadcrumb used to mark the path

    public MazeGUI() {
        start = new int[2];     // start[0] = row, start[1] = col
        exit = new int[2];      // exit[0]  = row, exit[1]  = col
        readMaze(mazeFile);     // load maze file
        createGUI(grid, start, exit, wall);
        if(!findPath(start[0], start[1], false)){
        	System.out.println("No Path Found");
        }
        
    }

    /**
     * The findPath method will recursively find a path through the maze. You
     * should mark your path with a crumb as you go. You need to remove crumbs
     * and replace them with spaces as you back out from dead ends. Call
     * updateGUI(grid) anytime you place or remove a crumb. The base condition
     * will be reached when you hit a dead end or when row==exit[0] and
     * col==exit[1]. You can use pathFound as one of your base conditions.
     */
    public final boolean findPath(int row, int col, boolean pathFound) {

        

        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && Character.toString(grid[row][col]).equals(" ") && pathFound == false){
        	//&& Character.toString(grid[row][col]).equals(" ") && pathFound == false
        	grid[row][col] = crumb;
            updateGUI();
            
            if (row == exit[0] && col == exit[1]) {
            	
                pathFound = true;
                System.out.println("Path Found Successfully");
                //return true;
            }
           
            else{
            	pathFound = findPath(row+1,col,pathFound);
            	//grid[row][col] = ' ';
            	pathFound = findPath(row,col+1,pathFound);
            	//grid[row][col] = ' ';
            	pathFound = findPath(row-1,col,pathFound);
            	//grid[row][col] = ' ';
            	pathFound = findPath(row,col-1,pathFound);
            	//grid[row][col] = ' ';
            	if (!pathFound){
                	grid[row][col] = ' ';
                }
            	
            }
        }
        
        return pathFound;
        
        /*
        else if(grid[row+1][col] == ' '){
        	pathFound = findPath(row+1,col,pathFound);
        	//System.out.println(pathFound);
        }
        else if(grid[row][col+1] == ' '){
        	pathFound = findPath(row,col+1,pathFound);
        }
        else if(grid[row-1][col] == ' '){
        	pathFound = findPath(row-1,col,pathFound);
        }
        else if (grid[row][col-1] == ' '){
        	findPath(row,col-1,pathFound);
        }
        if (!pathFound){
        	grid[row][col] = ' ';
        }*/
        
        
        
        

        // your code goes here
        
        
        
        
        
        
    }

    /**
     * The findOpenings method finds the two openings (start & exit) in the
     * maze. The start and exit are int arrays with a size of 2. Your algorithm
     * should randomly choose which of the two openings is the start and which
     * is the exit. There will be only two openings and they can be on any of
     * the four sides. There will NOT be an opening in a corner.
     */
    public void findOpenings() {
    	
    	
    	
    	int[] openOne = new int[2];
    	int [] openTwo = new int [2];
    	loop:
    	for(int i = 0; i < 2; i++){
    		for(int a = 0; a < grid[0].length; a++){//top row
    			if(Character.toString(grid[0][a]).equals(" ")){
    				if(i == 0){
    					openOne[0] = 0;
    					openOne[1] = a;
    				}
    				else{
    					openTwo[0] = 0;
    					openTwo[1] = a;
    					break loop;
    				}
    			}
    		}
    		for(int a = 0; a < grid[grid.length-1].length; a++){//bottom row
    			if(Character.toString(grid[grid.length-1][a]).equals(" ")){
    				if(i == 0){
    					openOne[0] = grid.length-1;
    					openOne[1] = a;
    				}
    				else{
    					openTwo[0] = grid.length-1;
    					openTwo[1] = a;
    					break loop;
    				}
    			}
    		}
    		for(int a = 0; a < grid.length; a++){//left row
    			if(Character.toString(grid[a][0]).equals(" ")){
    				if(i == 0){
    					openOne[0] = a;
    					openOne[1] = 0;
    				}
    				else{
    					openTwo[0] = a;
    					openTwo[1] = 0;
    					break loop;
    				}
    			}
    		}
    		for(int a = 0; a < grid.length; a++){//right row
    			if(Character.toString(grid[a][grid[0].length-1]).equals(" ")){
    				if(i == 0){
    					openOne[0] = a;
    					openOne[1] = grid[0].length - 1;
    				}
    				else{
    					openTwo[0] = a;
    					openTwo[1] = grid[0].length - 1;
    					break loop;
    				}
    			}
    		}
    	}
    	
    	int assign = (int)((Math.random()*2)+1);
    	//System.out.println(Arrays.toString(openOne));
    	//System.out.println(Arrays.toString(openTwo));
    	
    	
    	
    	if(assign == 1){
    		if((openOne[0] == openTwo[0]) && (openOne[1] == openTwo[1])){
    			//System.out.println("entered 1");
    			//System.out.println("" + start[0] + " " + exit[0]);
    			start[0] = openTwo[0];
        		start[1] = openTwo[1];
        	}
    		else{
    			start[0] = openTwo[0];
        		start[1] = openTwo[1];
        		exit[0] = openOne[0];
        		exit[1] = openOne[1];
    		}
    		
    	}
    	else{
    		if((openOne[0] == openTwo[0]) && (openOne[1] == openTwo[1])){
    			//System.out.println("entered 2");
    			start[0] = openOne[0];
        		start[1] = openOne[1];
        	}
    		else{
    			start[0] = openOne[0];
        		start[1] = openOne[1];
        		exit[0] = openTwo[0];
        		exit[1] = openTwo[1]; 
    		}
    		
    	}
    	
    	
    	
    	/*if(assign == 1){
    		start[0] = openTwo[0];
    		start[1] = openTwo[1];
    		exit[0] = openOne[0];
    		exit[1] = openOne[1];
    	}
    	else{
    		start[0] = openOne[0];
    		start[1] = openOne[1];
    		exit[0] = openTwo[0];
    		exit[1] = openTwo[1]; 
    	}*/
    	
    	/*if(start[0] == exit[0] && start[1] == exit[1]){
    		start[0] = exit[0];
    		start[1] = exit[1];
    	}*/
    	
    	
    	
    	
    	/*// replace with your algorythym to find these values
    	int row = grid.length-1;
    	int x = 0; //a control variable for the while loop.
    	//int[] holder = new int[4]; //will hold rand values that have already been generated. Will be compared to, and if rand==holder, then code will go back to generating a new rand.
    	//System.out.println("looping loop");
    	loop:
    	while (x == 0) {
    		int rand = (int)((Math.random()*4)+1);// will determine which row or col to check in order to find the start/end.
    		System.out.println("rand = " + rand);
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
            				//holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        		else if(rand == 4) {// checks bottom row
        			for(int i = 0; i < grid[row].length; i++) {
            			if(Character.toString(grid[row][i]).equals(" ")) {
            				start[0] = row; 
            				start[1] = i;
            				//holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        	}
        	else {
        		if(rand == 1) {// checks first column
        			for(int i = 0; i < row; i++) {
            			if(Character.toString(grid[i][0]).equals(" ")) {
            				start[0] = i; 
            				start[1] = 0;
            				//holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        		else if(rand == 3) {// checks last column
        			for(int i = 0; i < row; i++) {
            			if(Character.toString(grid[i][grid[0].length-1]).equals(" ")) {
            				start[0] = i; 
            				start[1] = grid[0].length-1;
            				//holder[rand-1] = rand;
            				break loop;
            			}
            		}
        		}
        	}
    	}
    	
    	//System.out.println("looping loop2");
    		loop2:	
    		while (x == 0) {
        		int rand2 = (int)((Math.random()*4)+1);// will determine which row or col to check in order to find the start/end.
        		System.out.println("rand2 = " + rand2);
        		//System.out.println(Arrays.toString(holder));
        		for(int i = 0; i < holder.length; i++) {
        			if(rand2 == holder[i]) {
        				continue loop2;
        			}
        		}
            	if(rand2%2==0) {
            		if(rand2 == 2) {
            			//ystem.out.println("check 1");
            			Loop1:
            			for(int i = 0; i < grid[0].length; i++) { //checks top row
                			if(Character.toString(grid[0][i]).equals(" ")) {
                				if((0 == start[0]) && (i == start[1])){
                					continue Loop1;
                				}
                				exit[0] = 0; 
                				exit[1] = i;
                				//holder[rand2-1] = rand2;
                				break loop2;
                			}
                		}
            		}
            		else if(rand2 == 4) {
            			//System.out.println("check 2");
            			Loop2:
            			for(int i = 0; i < grid[row].length; i++) { // checks bottom row
                			if(Character.toString(grid[row][i]).equals(" ")) {
                				if((row == start[0]) && (i == start[1])){
                					continue Loop2;
                				}
                				exit[0] = row; 
                				exit[1] = i;
                				//holder[rand2-1] = rand2;
                				break loop2;
                			}
                		}
            		}
            	}
            	else {
            		if(rand2 == 1) {
            			//System.out.println("check 3");
            			Loop3:
            			for(int i = 0; i < grid.length; i++) { //checks first column
            				//System.out.println("inside for loop");
                			if(Character.toString(grid[i][0]).equals(" ")) {
                				if((i == start[0]) && (0 == start[1])){
                					continue Loop3;
                				}
                				exit[0] = i; 
                				exit[1] = 0;
                				//holder[rand2-1] = rand2;
                				break loop2;
                			}
                		}
            		}
            		else if(rand2 == 3) {
            			//System.out.println("check 4");
            			Loop4:
            			for(int i = 0; i < grid.length; i++) { //checks last column
                			if(Character.toString(grid[i][grid[0].length-1]).equals(" ")) {
                				if((i == start[0]) && (grid[0].length-1 == start[1])){
                					continue Loop4;
                				}
                				exit[0] = i; 
                				exit[1] = grid[0].length-1;
                				//holder[rand2-1] = rand2;
                				break loop2;
                			}
                		}
            		}
            	}
        	}
    	
    	*/
    	
    	
    	//System.out.println("exited loop2");
    	
    	
        //start[0] = 0; start[1] = 1;  // replace with your code
        //exit[0] = 11; exit[1] = 13;  // replace with your code

    
    
    
    
    	/*int rand1 = (int)((Math.random()*4)+1);//determines which row/col to start at
    	int rand2 = (int)((Math.random()*2)+1);//determines if check will be run cloclwise or counterclockwise
    	
    	
    	if(rand1 == 1){//top row
    		if(rand2 == 1){
    			
    		}
    		else{
    			
    		}
    	}
    	else if(rand1 == 2){//right col
    		if(rand2 == 1){
    			
    		}
    		else{
    			
    		}
    	}
    	else if(rand1 == 3){//bottom row
    		if(rand2 == 1){
    			
    		}
    		else{
    			
    		}
    	}
    	else{//left col
    		if(rand2 == 1){
    			
    		}
    		else{
    			
    		}
    	}*/
        
        
        // your code goes here.  Use the code from the labyrinth lab.
        
        
        
        
    }

    public final void readMaze(String file) {
        try {
            Scanner read = new Scanner(new File(file));
            int rows = read.nextInt();
            grid = new char[rows][];
            read.nextLine();
            for (int i = 0; i < rows; i++) {
                grid[i] = read.nextLine().toCharArray();
            }
            numRows = grid.length;
            numCols = grid[0].length;
            findOpenings();
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file: " + file);
        }
    }

    public final void createGUI(char[][] grid, int[] start, int[] exit, char c) {
        frame = new JFrame("Maze");
        button = new JButton[numRows * numCols];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].setFont(new Font("Arial", Font.BOLD, 20));
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
        frame.setSize(numCols * 45 + 45, numRows * 45 + 45);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public final void updateGUI() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                button[row * numCols + col].setText("" + grid[row][col]);
            }
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
        }
    }
}