// Elizabeth Koshelev
//12/1/15
// This program plays tic tac toe with the user.
import java.util.*;
public class TicTacToe{
	public static void main(String[] args) {
		int play=1;
		while (play==1){ //This sets up the loop to play the game.
		System.out.println("Let's play tic tac toe! ");
		String[][] board = {{"  "," | ","  "," | ","  "},{"-----------"},{"  ", " | ","  "," | ","  "},{"-----------"},{"  "," | ","  "," | ", "  "}};
		Scanner console =new Scanner(System.in);
		System.out.println("Do you want to go first or second? (1 for first, 2 for second)"); //This lets the user pick if they go first or second.
		int move= console.nextInt();
		if(move==1){
		playFirstMove(board); //This calls the game if they want to go first.
		} else {
		playSecondMove(board); //This calls the game if they want to go second.
		}
		System.out.println("Do you want to play again? (1 for yes, 2 for no)"); //This allows the user to choose if they want to play again.
		play=console.nextInt();
		}
	}
	//This method plays the game if the user wants to make the first move.
	public static void playFirstMove(String[][] board){ 
		int totalmoves = 0;
		do{
			System.out.println("Make your move! Use coordinates (1-3) where first number is the column (1 is left, 3 is right) and second is rows (1 is top, 3 is bottom) and put it in the form 1 1. ");
			Scanner console = new Scanner(System.in); //User input coordinates.
			int x = console.nextInt();
			int y = console.nextInt();
			if (checkTaken(board, (y-1) * 2, (x-1) * 2)==false){ //If the spot is taken, the user is asked for another spot.
				System.out.println("Choose an empty space, please.");
			
			} else {
				board[(y-1) * 2][(x-1) * 2]="X"; //This converts the coordinates to fit my array, which contains the board.
				totalmoves++;
				print(board);
				if (checkWin(board) == 1) { //If the user wins, terminate the game.
				System.out.println("You win!");
				} else if (totalmoves<9){ //If the board is not full, continue.
					totalmoves++;
					System.out.println("My move:"); 
					if(checkWin1(board, "O")==true) { //If there are 2 O's in a row, win the game.
						board = fillThird(board, "O");
						print(board);
					} else if (checkWin1(board, "X")==true) { //If there are 2 X's in a row, block the user.
						board = fillThird(board, "X");
						print(board);
					}else {
						int temp1 = randomCoord(); //Else, pick a random free space.
						int temp2 = randomCoord();
						while (checkTaken(board,temp1,temp2)==false){
						temp1 = randomCoord();
						temp2 = randomCoord();
						}
						board[temp1][temp2] = "O";
						print(board);
					}
					if (checkWin(board) == 2) { //If the computer won, print I win.
					System.out.println("I win!");
					}
				}
			}
		} while (checkWin(board) ==3 && totalmoves<9);
		if (totalmoves==9){
			System.out.println("It's a draw!"); //Print it's a draw if the board is filled.
		}
	}
	//This is the same as the previous method, but the user goes after the computer makes a move.
	public static void playSecondMove(String[][] board){ 
		int totalmoves = 0;
		do{
			totalmoves++;
			System.out.println("My move:");
			if(checkWin1(board, "O")==true) {
				board = fillThird(board, "O");
				print(board);
			} else if (checkWin1(board, "X")==true) {
				board = fillThird(board, "X");
				print(board);
			}else {
				int temp1 = randomCoord();
				int temp2 = randomCoord();
				while (checkTaken(board,temp1,temp2)==false){
				temp1 = randomCoord();
				temp2 = randomCoord();
				}
			
				board[temp1][temp2] = "O";
				print(board);
			}
			if (checkWin(board) == 2) {
				System.out.println("I win!");
			}
			if (checkWin(board) != 2 && totalmoves<9){
				System.out.println("Make your move! Use coordinates (1-3) where first number is the column (1 is left, 3 is right) and second is rows (1 is top, 3 is bottom) and put it in the form 1 1. ");
				Scanner console = new Scanner(System.in);
				int x = console.nextInt();
				int y = console.nextInt();
				if (checkTaken(board, (y-1) * 2, (x-1) * 2)==false){
					System.out.println("Choose an empty space, please.");
				
				} else {
					board[(y-1) * 2][(x-1) * 2]="X";
					totalmoves++;
					print(board);
					if (checkWin(board) == 1) {
					System.out.println("You win!");
					}
				}
			}
		} while (checkWin(board) == 3 && totalmoves<9);
			if (totalmoves==9){
				System.out.println("It's a draw!");
		}
	}
	//This checks if a spot is blank or not.
	public static boolean checkTaken(String[][] arr, int x, int y){ 
			if (arr[x][y].equals("X") || arr[x][y].equals("O") ){
			return false;
		} else {
			return true;
		}
	}
	//This checks for a win using coordinates.
	public static int checkifWin(String[][] board, int x, int y, String z){ 
	int h =0;
	String[][] tempboard= board;
	if (checkTaken(tempboard, x, y)==true){
	tempboard[x][y] = z;
		if (checkWin(tempboard) == 1){
		h= 1;
		} else if (checkWin(tempboard)==2){
			h= 2;
			
		} else {
			h= 3;
		}
	}
	return h;
		}
	//This provides random coordinates.
	public static int randomCoord(){
		Random rand = new Random();
		int coord =rand.nextInt(3);
		int temp= (coord)*2;
		return temp;
	}
	//The following method checks if either side can win by checking all possibilities of two in a row. 
	public static boolean checkWin1(String[][] board, String z){ 
		boolean t = false;
		if((board[0][0].equals(board[0][2])&& board[0][2].equals(z) && board[0][4].equals("  "))|| (board[0][0].equals(board[0][4])&& board[0][4].equals(z) && board[0][2].equals("  ")) || (board[0][2].equals(board[0][4])&& board[0][2].equals(z) && board[0][0].equals("  ")) 
			||(board[0][0].equals(board[2][0]) && board[2][0].equals(z)&& board[4][0].equals("  ") )||( board[2][0].equals(board[4][0]) && board[2][0].equals(z) && board[0][0].equals("  "))|| (board[0][0].equals(board[4][0]) && board[0][0].equals(z) && board[2][0].equals("  "))
			||(board[2][0].equals(board[2][2])&& board[2][2].equals(z)) && board[2][4].equals("  ") || (board[2][0].equals(board[2][4])&& board[2][0].equals(z)&& board[2][2].equals("  ")) || (board[2][2].equals(board[2][4])&& board[2][2].equals(z) && board[2][0].equals("  "))
			||(board[0][2].equals(board[2][2]) && board[2][2].equals(z) && board[4][2].equals("  ") )||( board[2][2].equals(board[4][2]) && board[2][2].equals(z) && board[0][2].equals("  "))|| (board[0][2].equals(board[4][2]) && board[0][2].equals(z) && board[2][2].equals("  "))
			||(board[4][0].equals(board[4][2])&& board[4][2].equals(z)) && board[4][4].equals("  ")|| (board[4][0].equals(board[4][4])&& board[4][0].equals(z)&& board[4][2].equals("  ")) || (board[4][2].equals(board[4][4])&& board[4][2].equals(z) && board[4][0].equals("  ")) 
			||(board[0][4].equals(board[2][4]) && board[2][4].equals(z) && board[4][4].equals("  "))||( board[2][4].equals(board[4][4]) && board[2][4].equals(z) && board[0][4].equals("  "))|| (board[0][4].equals(board[4][4]) && board[0][4].equals(z) && board[2][4].equals("  "))
			||(board[0][0].equals(board[2][2]) && board[2][2].equals(z) && board[4][4].equals("  "))||( board[2][2].equals(board[4][4]) && board[2][2].equals(z) && board[0][0].equals("  "))|| (board[0][0].equals(board[4][4]) && board[4][4].equals(z) && board[2][2].equals("  "))
			||(board[0][4].equals(board[2][2]) && board[2][2].equals(z) && board[4][0].equals("  "))||( board[2][2].equals(board[4][0]) && board[2][2].equals(z) && board[0][4].equals("  "))|| (board[0][4].equals(board[4][0]) && board[0][4].equals(z)) && board[2][2].equals("  ")){
		t = true;
		
		} 
	return t;
	}
	//This will fill the third space if there are two in a row. Originally, I wrote a for loop. However, it was unsuccessfull so I wrote out all the possibilities instead.
	public static String[][] fillThird(String[][] board, String z){ 
		if((board[0][0].equals(board[0][2])&& board[0][2].equals(z) && board[0][4].equals("  "))|| (board[0][0].equals(board[0][4])&& board[0][4].equals(z) && board[0][2].equals("  ")) || (board[0][2].equals(board[0][4])&& board[0][2].equals(z) && board[0][0].equals("  ") ) ){
				if (checkTaken(board,0,0) == true) { board[0][0] = "O";}
				else if (checkTaken(board,0,2) == true) { board[0][2] = "O";}
				else if (checkTaken(board,0,4) == true) { board[0][4] = "O";}
				return board;
		} else if((board[0][0].equals(board[2][0]) && board[2][0].equals(z)&& board[4][0].equals("  ") )||( board[2][0].equals(board[4][0]) && board[2][0].equals(z) && board[0][0].equals("  "))|| (board[0][0].equals(board[4][0]) && board[0][0].equals(z) && board[2][0].equals("  ")) ){
				if (checkTaken(board,0,0) == true) { board[0][0] = "O";}
				else if (checkTaken(board,2,0) == true) { board[2][0] = "O";}
				else if (checkTaken(board,4,0) == true) { board[4][0] = "O";}
				return board;
		} else if((board[2][0].equals(board[2][2])&& board[2][2].equals(z)) && board[2][4].equals("  ") || (board[2][0].equals(board[2][4])&& board[2][0].equals(z)&& board[2][2].equals("  ")) || (board[2][2].equals(board[2][4])&& board[2][2].equals(z) && board[2][0].equals("  ") ) ){
				if (checkTaken(board,2,0) == true) { board[2][0] = "O";}
				else if (checkTaken(board,2,2) == true) { board[2][2] = "O";}
				else if (checkTaken(board,2,4) == true) { board[2][4] = "O";}
				return board;
		} else if((board[0][2].equals(board[2][2]) && board[2][2].equals(z) && board[4][2].equals("  ") )||( board[2][2].equals(board[4][2]) && board[2][2].equals(z) && board[0][2].equals("  "))|| (board[0][2].equals(board[4][2]) && board[0][2].equals(z) && board[2][2].equals("  ")) ){
				if (checkTaken(board,0,2) == true) { board[0][2] = "O";}
				else if (checkTaken(board,2,2) == true) { board[2][2] = "O";}
				else if (checkTaken(board,4,2) == true){ board[4][2] = "O";}
				return board;
		} else if((board[4][0].equals(board[4][2])&& board[4][2].equals(z)) && board[4][4].equals("  ")|| (board[4][0].equals(board[4][4])&& board[4][0].equals(z)&& board[4][2].equals("  ")) || (board[4][2].equals(board[4][4])&& board[4][2].equals(z) && board[4][0].equals("  ") ) ){
				if (checkTaken(board,4,0) == true) { board[4][0] = "O";}
				else if (checkTaken(board,4,2) == true) { board[4][2] = "O";}
				else if (checkTaken(board,4,4) == true)  { board[4][4] = "O";}
				return board;
		}else if((board[0][4].equals(board[2][4]) && board[2][4].equals(z) && board[4][4].equals("  "))||( board[2][4].equals(board[4][4]) && board[2][4].equals(z) && board[0][4].equals("  "))|| (board[0][4].equals(board[4][4]) && board[0][4].equals(z) && board[2][4].equals("  ")) ){
				if (checkTaken(board,0,4) == true) { board[0][4] = "O";}
				else if (checkTaken(board,2,4) == true) { board[2][4] = "O";}
				else  if (checkTaken(board,4,4) == true){ board[4][4] = "O";}
				return board;
		} 	else if((board[0][0].equals(board[2][2]) && board[2][2].equals(z) && board[4][4].equals("  "))||( board[2][2].equals(board[4][4]) && board[2][2].equals(z) && board[0][0].equals("  "))|| (board[0][0].equals(board[4][4]) && board[4][4].equals(z) && board[2][2].equals("  "))){
				if (checkTaken(board,0,0) == true) { board[0][0] = "O";}
				else if (checkTaken(board,2,2) == true) { board[2][2] = "O";}
				else if (checkTaken(board,4,4) == true) { board[4][4] = "O";}
				return board;
		}	else if((board[0][4].equals(board[2][2]) && board[2][2].equals(z) && board[4][0].equals("  "))||( board[2][2].equals(board[4][0]) && board[2][2].equals(z) && board[0][4].equals("  "))|| (board[0][4].equals(board[4][0]) && board[0][4].equals(z)) && board[2][2].equals("  ")){
				if (checkTaken(board,0,4) == true) { board[0][4] = "O";}
				else if (checkTaken(board,2,2) == true) { board[2][2] = "O";}
				else if (checkTaken(board,4,0) == true) { board[4][0] = "O";}
				return board;
			}
			return board;
		}
	//This prints the board each time.
	public static void print(String[][] arr){
		for (int r=0; r<arr.length; r++){
			for (int c=0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] );
			}
			System.out.println();
		}
	}
	//Checks win and returns if x or os won.
	public static int checkWin(String[][] arr){ 
		int h = 3;
		String[][] tempboard=arr;
		if (arr[0][0].equals("X") && arr[0][2].equals("X") && arr[0][4].equals("X") 
		|| arr[2][0].equals("X") && arr[2][2].equals("X") && arr[2][4].equals("X") 
		|| arr[4][0].equals("X") && arr[4][2].equals("X") && arr[4][4].equals("X")
		|| arr[0][0].equals("X") && arr[2][0].equals("X") && arr[4][0].equals("X")
		|| arr[0][2].equals("X") && arr[2][2].equals("X") && arr[4][2].equals("X")
		|| arr[0][4].equals("X") && arr[2][4].equals("X") && arr[4][4].equals("X")
		|| arr[0][0].equals("X") && arr[2][2].equals("X") && arr[4][4].equals("X")
		|| arr[0][4].equals("X") && arr[2][2].equals("X") && arr[4][0].equals("X")){
		h=1;
		}	else if (arr[0][0].equals("O") && arr[0][2].equals("O") && arr[0][4].equals("O") 
		|| arr[2][0].equals("O") && arr[2][2].equals("O") && arr[2][4].equals("O") 
		|| arr[4][0].equals("O") && arr[4][2].equals("O") && arr[4][4].equals("O")
		|| arr[0][0].equals("O") && arr[2][0].equals("O") && arr[4][0].equals("O")
		|| arr[0][2].equals("O") && arr[2][2].equals("O") && arr[4][2].equals("O")
		|| arr[0][4].equals("O") && arr[2][4].equals("O") && arr[4][4].equals("O")
		|| arr[0][0].equals("O") && arr[2][2].equals("O") && arr[4][4].equals("O")
		|| arr[0][4].equals("O") && arr[2][2].equals("O") && arr[4][0].equals("O")){
		h=2;
		}	else {
		h=3;
		}
		arr=tempboard;
		return h;
	}
}