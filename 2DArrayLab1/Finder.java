//package pkg2dexamreview;

public class Finder {

    public static void main(String[] args) {

        char[][] array = new char[10][];
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray();
        }
        System.out.println( formatArray(array) );
        
        String letters = "abcdef";
        for (int i=0; i<letters.length(); i++){
            char c = letters.charAt(i);
            System.out.println(findPairs(array, c) + " pairs of '" + c + "' found.");
        }
        //System.out.println("Two sequential letters in a row: " + findTwoInRow(array));
        //System.out.println("Two sequential letters in a col: " + findTwoInCol(array));
    }
    
    public static int findPairs(char[][] array, char c){
    	int ctr = 0;
        for(int r = 0; r < array.length; r++){
        	for(int col = 0; col < array[r].length; col++){
        		if(Character.toString(array[r][col]).equals(Character.toString(c))){
        			ctr++;
        		}
        	}
        }
        return (ctr/2);
    }
    
    public static String findTwoInRow(char[][] array){
        String str = "";
        
        
        
        return str;
    }
    
    public static String findTwoInCol(char[][] array){
        String str = "";
        
        
        
        return str;
    }

    public static char[] newArray() {
        char[] row = new char[10];
        for (int i = 0; i < row.length; i++) {
            row[i] = (char) (int) (Math.random() * 26 + 97);
        }
        return row;
    }

    public static String formatArray(char[][] array) {
        String str = "";
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                str += array[row][col] + "  ";
            }
            str += "\n";
        }
        return str;
    }
}
