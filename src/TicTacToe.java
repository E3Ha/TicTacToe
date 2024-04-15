import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    //Global Board setup
    private static final int ROW = 3;
    private static int COL = 3;
    private static String board [][] = new String[ROW][COL];

    //Global imports
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    //Global player move location
    private static int userRow;
    private static int userCol;
    public static void main(String[] args) {
        //initialize variables
        boolean xWin = false;
        boolean oWin = false;
        boolean playAgain = true;
        boolean tie = false;

        //Clear the board
        clearBoard();
        //Display the Board
        display();
        do {
            do {
                //Player X makes move
                makeMove("X");
                //Display Board
                display();
                //Check for a tie or win
                tie = isTie();
                xWin = isWin("X");
                //Break loop if player X wins
                if(xWin){
                    break;
                }
                //Player O makes move
                makeMove("O");
                //Display Board
                display();
                //Check for a tie or win
                tie = isTie();
                oWin = isWin("O");
            }
            //Exit loop if someone has won or a tie has occurred
            while (!xWin && !oWin && !tie);
            //Output to user who won or if tie happened
            if (xWin) {
                System.out.println("Player X has Won.");
            } else if (oWin) {
                System.out.println("Player O has Won");
            } else if (tie) {
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
    //Method for win conditions - checks to see if there is a win state on current board for specified
    //player (X || O) - calls 3 additional methods that break down 3 kinds of wins that are possible
    private static boolean isWin(String player){
        if (player == "X"){
            //if player is X && any win type is true, return true
            if (isColWin("X") || isRowWin("X") || isDiagonalWin("X")){
                return true;
            }
        }
        else if (player == "O"){
            //if player is O && any win type is true, return true
            if (isColWin("O") || isRowWin("O") || isDiagonalWin("O")){
                return true;
            }
        }
        return false;
    }


    //Method for checking for col win for specified player
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

    //Method for checking for diagonal win for specified player
    private static boolean isDiagonalWin(String player) {
        //if player is X
        if (player == "X") {
            //Hardcode check for diagonal win with Xs & return true if true
            //Left to Right
            if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") {
                return true;
            }
            //Right to Left
            else if (board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") {
                return true;
            }
            return false;
        }
        //if player is O
        else if (player == "O"){
            //Hardcode check for diagonal win with Os & return true if true
            //Left to Right
            if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") {
                return true;
            }
            //Right to Left
            else if (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") {
                return true;
            }
            return false;
        }
        return false;
    }

    //Method for Ties - checks for a tie condition
    private static boolean isTie(){
        for (int i = 0; i < ROW; i++){
            //if all spaces are filled = tie
            if ((board[i][0] != "-" && board[i][1] != "-" && board[i][2] != "-") && (board[0][i] != "-" && board[1][i] != "-" && board[2][i] != "-")){
                return true;
            }
        }
        return false;

    }

    //Method for making a move on the board
    private static void makeMove(String player){
        //Get Row and Column (subtract 1 for the array)
        userRow = (SafeInput.getRangedInt(scan, "Row: ", 1, ROW)) - 1;
        userCol = (SafeInput.getRangedInt(scan, "Column: ", 1, COL)) - 1;
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
