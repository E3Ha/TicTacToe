import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static int COL = 3;
    private static String board [][] = new String[ROW][COL];
    public static void main(String[] args) {
        //initialize variables
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int row;
        int col;
        String playerMove = "";
        boolean validMove;

        //Clear the board
        clearBoard();
        //Display the Board
        display();

        //Player X starts first
        playerMove = "X";
        //Get Row and Column (subtract 1 for the array)
        row = (SafeInput.getRangedInt(scan, "Row: ", 1, ROW)) - 1;
        col = (SafeInput.getRangedInt(scan, "Column: ", 1, COL)) - 1;
        validMove = isValidMove(row, col);
        if (validMove = false){
            do {
                
            }
            while (validMove = false);
        }
        //Notes:
        //for loops for win conditions - 1 for row 1 for column
        //hard code diagonal win conditions

        //check for tie, if 2 different moves in a row/column it = tie
        //if 9 moves have been made and no one wins yet it = a tie

        //Player toggling - if X exists flip it to O once Player X has run through loop


    }
    //Method for Valid Move - returns true if there is a space at given move coordinates
    private static boolean isValidMove(int row, int col){
        if (board[row][col] == "-"){
            return true;
        }
        return false;
    }
    //Method for win conditions - checks to see if there is a win state on current board for specified
    //player (X || O) - calls 3 additional methods that break down 3 kinds of wins that are possible
/*
    private static boolean isWin(String player){

    }
*/

    //Method for checking for col win for specified player
/*
    private static boolean isColWin(String player){

    }
*/
    //Method for checking for row win for specified player
/*
    private static boolean isRowWin(String player){

    }
*/
    //Method for checking for diagonal win for specified player
/*
    private static boolean isDiagonalWin(String player){

    }
*/
    //Method for Ties - checks for a tie condition: all spaces on board are filled ||
    //there is an X && O in every win vector
/*
    private static boolean isTie(){

    }
*/

    //Method for Displaying Board
    private static void display(){
        for (int row = 0; row < ROW; row++){
            System.out.println("| ");
            for (int col = 0; col < COL; col++){
                System.out.println(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
    //Method for Clearing Board
    private static void clearBoard(){
        for (int row = 0; row < ROW; row++){
            for (int col = 0; col < COL; col++){
                board[row][col] = "-";
            }
        }
    }




}