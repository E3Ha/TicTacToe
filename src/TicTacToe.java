import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    //Global Board setup
    private static final int ROW = 3;
    private static int COL = 3;
    private static String board [][] = new String[ROW][COL];

    //Global imports
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //initialize variables
        boolean win = false;
        boolean playAgain = true;
        boolean tie = false;
        String player;
        int moves = 0;

        //Clear the board
        clearBoard();
        do {
            //Display the Board
            display();
            moves = 0;
            do {
                //Checking whose turn it...
                if (moves % 2 == 0){
                    player = "X";
                } else{
                    player = "O";
                }
                //Make move on board
                makeMove(player);
                //Display Board
                display();
                //Check for a tie or win
                win = isWin(player);
                tie = isTie(moves, win);
                //Add to number of moves
                moves ++;
            }
            //Exit loop if someone has won or a tie has occurred
            while (!win && !tie);
            //Output to user who won or if tie happened
            if (win) {
                System.out.println("Player " + player + " has Won.");
            }
            else if (tie) {
                System.out.println("There is a Tie.");
            }
            //Ask player if they want to play again
            playAgain = SafeInput.getYNConfirm(scan, "Play Again?");
            //If user wants to play again, clear board
            if (playAgain) {
                clearBoard();
            }
        }
        while (playAgain);

    }
    //Method for Valid Move - returns true if there is a space at given move coordinates
    private static boolean isValidMove(int row, int col){
        //If space is not filled, return true
        if (board[row][col] == "-"){
            return true;
        }
        return false;
    }
    //Method for win conditions - checks to see if there is a win state on current board
    //--calls 3 additional methods that break down 3 kinds of wins that are possible--
    private static boolean isWin(String player){
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)){
            return true;
        }
        return false;
    }

    //Method for checking for col win
    private static boolean isColWin(String player){
        for (int i = 0; i < COL; i++){
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
        }
        return false;
    }

    //Method for checking for row win
    private static boolean isRowWin(String player){
        for (int i = 0; i < ROW; i++){
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
        return false;
    }

    //Method for checking for diagonal win
    private static boolean isDiagonalWin(String player) {
        //Hardcode check for diagonal win
        //Left to Right
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        //Right to Left
        else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    //Method for Ties - checks for a tie condition based on how many moves have been made and if someone has won
    private static boolean isTie(int moves, boolean win){
        if (moves == 8 && !win){
            return true;
        }
        return false;
    }

    //Method for making a move on the board
    private static void makeMove(String player){
        int userRow;
        int userCol;
        //Get Row and Column (subtract 1 for the array)
        userRow = (SafeInput.getRangedInt(scan, "Row " + "[" + player + "]: ", 1, ROW)) - 1;
        userCol = (SafeInput.getRangedInt(scan, "Column " + "[" + player + "]: ", 1, COL)) - 1;
        System.out.println();
        //if spot is taken (validMove is false)...
        if (!isValidMove(userRow,userCol)){
            //loop until user gives a valid location
            do {
                System.out.println();
                System.out.println("Invalid Move. Try Again.");
                userRow = (SafeInput.getRangedInt(scan, "Row: ", 1, ROW)) - 1;
                userCol = (SafeInput.getRangedInt(scan, "Column: ", 1, COL)) - 1;
            }
            while (!isValidMove(userRow,userCol));
        }
        //Make move if valid
        board[userRow][userCol] = player;
    }

    //Method for Displaying Board
    private static void display(){
        for (int row = 0; row < ROW; row++){
            System.out.print("| ");
            for (int col = 0; col < COL; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    //Method for Clearing Board
    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = "-";
            }
        }
    }

}
