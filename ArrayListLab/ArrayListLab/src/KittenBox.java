/*
 * Mrityunjay Mishra
 * Mr. Finnegan
 * AP Computer Science - 3rd 
 * 23 January 2018
 */


import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.*;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/*class Runner {

    public static void main(String[] args) {
        KittenBox box = new KittenBox();
    }
}*/

class BoxGUI extends JFrame {

    JFrame frame;
    JButton[] button;
    private int delay = 20;

    public void createGUI(int r, int c, int start, int exit, int numKittens) {
        frame = new JFrame();
        button = new JButton[r * c];
        for (int i = 0; i < r * c; i++) {
            button[i] = new JButton("0");
            button[i].setFont(new Font("Arial", Font.PLAIN, 30));
            frame.add(button[i]);
        }
        button[start].setText("" + numKittens);
        button[start].setOpaque(true);
        button[start].setBackground(new Color(0, 255, 51));
        button[exit].setOpaque(true);
        button[exit].setBackground(new Color(255, 51, 51));
        frame.setLayout(new GridLayout(r, c));
        frame.setSize(c * 80 + 20, r * 80 + 20);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateGUI(int[] table) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == 0) {
                button[i].setText("");
            } else {
                button[i].setText("" + table[i]);
            }
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
        }
    }
}

public class KittenBox extends BoxGUI {

    Collection<Kitten> kitten;
    ArrayList<Kitten> holder;
    private int rows  = 8;
    private int cols  = 8;
    private int start = 9;
    private int exit  = 54;
    private int numKittens = 200;

    public KittenBox() {  // KittenBox constructor
        
        // Initialize the kitten ArrayList
        // Use a loop to cread and add Kitten objects to the kitten ArrayList
        // The number of kittens to add is numKittens 
    	holder = new ArrayList<>();
    	kitten = new ArrayList<>(numKittens);
    	for(int i = 0; i < numKittens; i++){
    		kitten.add(new Kitten(rows,cols,start));
    	}
    	/*for(int i = 0; i < numKittens; i++){
    		holder.add()
    	}*/
        
        createGUI(rows, cols, start, exit, numKittens);
        play();
    }

    private void play() {
    	int moveCtr = 0;
        
        // Outer Loop. 
        // Keep looping while you have kitten objects in your ArrayList
        while(kitten.size()>0){
        	
            int[] table = new int[rows * cols]; //needed for GUI
            
            // Inner loop that loops once through your array list getting each 
            // kittens new location (square).
            for(Kitten k: kitten){
            //int i = 0; i < kitten.size(); i++
            /**
             * Your code should loop through your kitten ArrayList and ask 
             * each kitten for their next move. When the kitten moves to the
             * exit square then remove the kitten from the ArrayList. You should
             * increment the element in the table array whose index matches the
             * kittens move (or square).  For example;  
             * A 3x4 box would contain the following squares. 0   1   2   3
             *                                                4   5   6   7
             *                                                8   9   10  11
             * If a kitten moves to square 5 then increment table[5] by 1.
             * 
             * Keep count of the number of times the outer loop has run and
             * print a message containing the number of kittens remaining and
             * the number of moves that have occurred.  For example;
             * "31 kittens remaining after 318 moves."
             * "30 kittens remaining after 319 moves."
            */
            	
            //int move = kitten.get(i).move();
            int move = k.move();
            if(move == exit){
            	//kitten.remove(i);
            	//i--;
            	
            	//kitten.remove(k);
            	//System.out.println("hello");
            	holder.add(k);
            	//holder.add(k);
            	
            	//moveCtr++;
            	//System.out.println(kitten.size() + " kittens remaining after " + moveCtr + " moves.");
            }
            else{
            	table[move]++;
            	//moveCtr++;
            	//System.out.println(kitten.size() + " kittens remaining after " + moveCtr + " moves.");
            }
            
            
            
            //super.updateGUI(table);
            
        }
        kitten.removeAll(holder);
        //kitten.remove(k);
        moveCtr++;
        System.out.println(kitten.size() + " kittens remaining after " + moveCtr + " moves."); ///--- where do i put this??
        super.updateGUI(table);
        
        
        

    }
        super.updateGUI(new int[rows * cols]);
        System.out.println("All kittens have escaped.");
        
}

class Kitten {
    /**
     * You may change any of the code in the Kitten class except the 
     * constructor parameters. The method move() has no parameters and 
     * must must return an int where 0 is the top left square and 
     * (rows * cols - 1) is the bottom right square. See the example below.
    */
    
    private int rows, cols, currentSquare;
    
    public Kitten(int r, int c, int startingSquare) { // Kitten constructor
        rows = r;
        cols = c;
        currentSquare = startingSquare;
    }

    public int move() {
        int newSquare = currentSquare;
        
        
        /** 
         * Add code so that this kitten will move in a random direction (up, 
         * down, left, or right) by 1 square. Return the integer value of the 
         * new square. Check your boundary conditions since a kitten cannot 
         * move through walls. For example;
         * A 4x4 box would contain the following squares. 0   1   2   3
         *                                                4   5   6   7
         *                                                8   9   10  11
         *                                                12  13  14  15
         * A kitten in square 11 could only move up, down, or left (not right).
         * A kitten in square 13 could only move left, up, or right (not down).
         * A kitten in square 0 could only move right or down (not left or up).
         * 
         * Return the the kitten's new square.
        */
        while(true){
        	int randMoveSelector = (int)((Math.random() * 4) + 1); // 1 - right; 2 - left; 3 - up; 4 - down;
        	//checking boundary conditions rn.
        	if((currentSquare - cols == 0) || (currentSquare - cols < 0)){
        		if(randMoveSelector == 3){
        			continue;
        		}
        	}
        	if((currentSquare + cols == (rows*cols-1)) || (currentSquare + cols > (rows*cols-1))){
        		if(randMoveSelector == 4){
        			continue;
        		}
        	}
        	if(currentSquare%cols == 0){
        		if(randMoveSelector == 2){
        			continue;
        		}
        	}
        	if((currentSquare+1)%cols == 0){
        		if(randMoveSelector == 1){
        			continue;
        		}
        	}
        	//all boundary conditions met. Now going to play the random move as defined by the randMoveSelector. 
            if(randMoveSelector == 1){
            	newSquare++;
            	break;
            }
            else if(randMoveSelector == 2){
            	newSquare--;
            	break;
            }
            else if(randMoveSelector == 3){
            	newSquare = newSquare - cols;
            	break;
            }
            else if(randMoveSelector == 4){
            	newSquare = newSquare + cols;
            	break;
            }
        }
        
        
        currentSquare = newSquare;
        return currentSquare;
    }
}
}
