import java.util.Scanner; //TODO: fix this import statement to import scanner

/**********************************************************
 Using one dimensional array to implement Tic-Tac-Toe Game.

 Tic-Tac-Toe Game Outline:
 =========================

 // play game until gameOver is true
 start with player 'X'
 while (!gameOver) {
 // get current player choice, and update board value
 // display the updated board
 // switch player 'X' -> 'O' or 'O' -> 'X'
 // check for winner, draw or game is not over yet
 }


 Your tasks:
 ===========
 You need to complete the following methods
 receiveUserChoice()
 isGameOver()


 3 Sample runs:
 ==============

 1 | 2 | 3
 4 | 5 | 6
 7 | 8 | 9

 X turn, enter a position:5

 1 | 2 | 3
 4 | X | 6
 7 | 8 | 9

 O turn, enter a position:1

 O | 2 | 3
 4 | X | 6
 7 | 8 | 9

 X turn, enter a position:3

 O | 2 | X
 4 | X | 6
 7 | 8 | 9

 O turn, enter a position:5
 Invalid position!
 O turn, enter a position:3
 Invalid position!
 O turn, enter a position:4

 O | 2 | X
 O | X | 6
 7 | 8 | 9

 X turn, enter a position:7

 O | 2 | X
 O | X | 6
 X | 8 | 9

 X is the winner!

 ===================================

 1 | 2 | 3
 4 | 5 | 6
 7 | 8 | 9

 X turn, enter a position:1

 X | 2 | 3
 4 | 5 | 6
 7 | 8 | 9

 O turn, enter a position:5

 X | 2 | 3
 4 | O | 6
 7 | 8 | 9

 X turn, enter a position:7

 X | 2 | 3
 4 | O | 6
 X | 8 | 9

 O turn, enter a position:4

 X | 2 | 3
 O | O | 6
 X | 8 | 9

 X turn, enter a position:6

 X | 2 | 3
 O | O | X
 X | 8 | 9

 O turn, enter a position:2

 X | O | 3
 O | O | X
 X | 8 | 9

 X turn, enter a position:3

 X | O | X
 O | O | X
 X | 8 | 9

 O turn, enter a position:8

 X | O | X
 O | O | X
 X | O | 9

 O is the winner!

 ===================================

 1 | 2 | 3
 4 | 5 | 6
 7 | 8 | 9

 X turn, enter a position:1

 X | 2 | 3
 4 | 5 | 6
 7 | 8 | 9

 O turn, enter a position:5

 X | 2 | 3
 4 | O | 6
 7 | 8 | 9

 X turn, enter a position:3

 X | 2 | X
 4 | O | 6
 7 | 8 | 9

 O turn, enter a position:2

 X | O | X
 4 | O | 6
 7 | 8 | 9

 X turn, enter a position:8

 X | O | X
 4 | O | 6
 7 | X | 9

 O turn, enter a position:6

 X | O | X
 4 | O | O
 7 | X | 9

 X turn, enter a position:4

 X | O | X
 X | O | O
 7 | X | 9

 O turn, enter a position:7

 X | O | X
 X | O | O
 O | X | 9

 X turn, enter a position:9

 X | O | X
 X | O | O
 O | X | X

 It is a draw

 ***********************************************************/
class TicTacToe {

    public static void main(String[] args){
        Board board = new Board();
        Scanner input = new Scanner(System.in);
        Player X = new Player('X', input);
        Player O = new Player('O', input);
        Player nextPlayer = X;
        boolean gameOver = false;

        while (!gameOver) {
            // get current player choice, and update board value
            play(nextPlayer, board);
            // display the updated board
            board.displayBoard();
            // switch player 'X' -> 'O' or 'O' -> 'X'
            nextPlayer = (nextPlayer.getPlayerSymbol() == 'X') ? O : X;            // check for winner, draw or game is not over yet
            gameOver = board.isGameOver();

        }
    }
    public static void play(Player player, Board board) {
        // Step 2: make sure it is a valid position, and the position is not taken yet
        //    2.1: if it is valid input, mark the board position with the current player
        //    2.2: if it is not valid, print message repeat Step 1. until a valid input is obtained
        int input_position = -1;
        do {
            System.out.println("Enter a valid position between 1 to 9");
            input_position = player.getMove();
        } while (!board.isValid(input_position));

        board.updatePosition(input_position, player);
    }


}


class Player {
    private char playerSymbol;
    private Scanner input;

    public Player(char playerSymbol, Scanner input){
        this.playerSymbol = playerSymbol;
        this.input = input;
    }
    public char getPlayerSymbol(){
        return this.playerSymbol;
    }

    /*
      Gets player's position for the next move
     */
    public int getMove(){
        int position;
        position = this.input.nextInt();
        return position;
    }
}





// board class with all the variables needed
 class Board {
    private char board[];

    public Board(){

        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void displayBoard(){
        System.out.println("");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println("");
    }

    public  boolean isGameOver() {
        // Step 1: if there is a winner, print winner message, return true
        // Step 2: if it is a draw, print draw message, return true
        // Step 3: else the game is not over yet, return false

        String win1 = new StringBuilder().append(board[0]).append(board[1]).append(board[2]).toString();
        String win2 = new StringBuilder().append(board[3]).append(board[4]).append(board[5]).toString();
        String win3 = new StringBuilder().append(board[6]).append(board[7]).append(board[8]).toString();
        String win4 = new StringBuilder().append(board[0]).append(board[3]).append(board[6]).toString();
        String win5 = new StringBuilder().append(board[1]).append(board[4]).append(board[7]).toString();
        String win6 = new StringBuilder().append(board[2]).append(board[5]).append(board[8]).toString();
        String win7 = new StringBuilder().append(board[0]).append(board[4]).append(board[8]).toString();
        String win8 = new StringBuilder().append(board[2]).append(board[4]).append(board[6]).toString();
// these folowing if statements will check for the winning combinations
        if (win1.equals("XXX") || win2.equals("XXX") || win3.equals("XXX") || win4.equals("XXX")
                || win5.equals("XXX") || win6.equals("XXX") || win7.equals("XXX") || win8.equals("XXX")) {
            System.out.println("Player X won the game");
            return true;
        } else if (win1.equals("OOO") || win2.equals("OOO") || win3.equals("OOO") || win4.equals("OOO")
                || win5.equals("OOO") || win6.equals("OOO") || win7.equals("OOO") || win8.equals("OOO")) {
            System.out.println("Player O won the game");
            return true;
        } else if (positionsFull()) {
            System.out.println("It is a draw");
            return true;
        } else
            return false;
    }

    // Method checks if every position is full
    public boolean positionsFull() {
        for (int i = 0; i < board.length; i++) {
            if (Character.isDigit(board[i])) {
                return false;
            }
        }
        return true;
    }



    //this checks if the position entered is taken or not
    public boolean isValid(int position) {
        if (position < 1 || position > 9 ) {
            System.out.print("Invalid position entered");
            return false;
        }
        else if(board[position-1] == 'X' || board[position-1] == 'O'){
            System.out.print("Position taken.");
            return false;
        }
        else
            return true;
    }

    //A method that updates the position with player's symbol
    public void updatePosition(int position, Player player){

        board[position-1] = player.getPlayerSymbol();
    }


}
