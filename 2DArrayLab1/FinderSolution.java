//package pkg2dexamreviewsolution;

public class FinderSolution {

    public static void main(String[] args) {

        char[][] array = new char[10][];
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray();
        }
        System.out.println(formatArray(array));

        String letters = "abcdefg";
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            System.out.println(findPairs(array, c) + " pairs of '" + c + "' found.");
        }
        System.out.println("Two sequential letters in a row: " + findTwoInRow(array));
        System.out.println("Two sequential letters in a col: " + findTwoInCol(array));
    }

    public static int findPairs(char[][] array, char c) {
        int count = 0;
        boolean found = false;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == c && found) {
                    count++;
                    found = false;
                } else if (array[row][col] == c) {
                    found = true;
                }

            }
        }
        /*int ctr = 0;
        for(int r = 0; r < array.length; r++){
        	for(int col = 0; col < array[r].length; col++){
        		if(Character.toString(array[r][col]).equals("a")){
        			ctr++;
        		}
        	}
        }
        System.out.println(ctr);*/
        return count;
    }

    public static String findTwoInRow(char[][] array) {
        String str = "";
        for (int i = 97; i < 122; i++) {
            for (int r = 0; r < array.length; r++) {
                for (int c = 0; c < array[r].length - 1; c++) {
                    if (array[r][c] == i && array[r][c + 1] == (i + 1)) {
                        str += "" + (char) i + (char) (i + 1) + " ";
                    }
                }
                for (int c = array[r].length - 1; c > 0; c--) {
                    if (array[r][c] == i && array[r][c - 1] == (i + 1)) {
                        str += "" + (char) i + (char) (i + 1) + " ";
                    }
                }
            }
        }
        return str;
    }

    public static String findTwoInCol(char[][] array) {
        String str = "";
        for (int i = 97; i < 122; i++) {
            for (int c = 0; c < array[0].length; c++) {
                for (int r = 0; r < array.length - 1; r++) {
                    if (array[r][c] == i && array[r + 1][c] == (i + 1)) {
                        str += "" + (char) i + (char) (i + 1) + " ";
                    }
                }
                for (int r = array.length - 1; r > 0; r--) {
                    if (array[r][c] == i && array[r - 1][c] == (i + 1)) {
                        str += "" + (char) i + (char) (i + 1) + " ";
                    }
                }
            }
        }
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
