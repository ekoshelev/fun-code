// Elizabeth Koshelev
// 11/12/15
// This program strategically plays rock paper scissors. With a quick google search, a good strategy is to assume that if the user wins, there is a high probability they will repeat the action, and the computer will adjust to that. Another strategy is to do multiple sets of each component, so that the user does not expect it.

import java.util.*;

public class RockPaperScissors{
	public static void main(String[] args) {
		playGames(); //This calls the method that plays the actual games.
	}
	
	public static void playGames(){
		int playagain=1;
		while (playagain==1) {
			Scanner type= new Scanner(System.in); 
			System.out.println("Choose a mode: random, easy, medium, or impossible: (1 for random, 2 for easy, 3 for medium, 4 for impossible) You'll play 3 rounds of each.");			
			int choosemode = type.nextInt(); //This allows the user to choose a mode.
			if (choosemode == 1 || choosemode == 4){
				for (int i = 1; i<=3; i++){
					Scanner keyboard= new Scanner(System.in); 
					System.out.println("Rock, paper, or scissors?");			
					String usermove = keyboard.next(); 
						if (choosemode==1){ //This plays mode one, which chooses a random counterattack.
							playMode(usermove, modeOne());
						} else if (choosemode==4) {
							playMode(usermove, modeFour(usermove)); //This plays mode four, which is the impossible mode that always wins.
						}
				}
			} else if (choosemode ==2 || choosemode ==3){//This plays easy and medium modes.	
				Scanner keyboardtwo= new Scanner(System.in); 
				System.out.println("Rock, paper, or scissors?");		
				String usermovetwo = keyboardtwo.next(); 
					if (choosemode==2){	
						modeTwo(usermovetwo);				
					}
					if (choosemode==3){
						modeThree(usermovetwo);
					}
			}
			Scanner input= new Scanner(System.in); 
			System.out.println("Play again? (1 for yes, 2 for no)");			
			playagain = input.nextInt(); 		
		}
	}
	
	public static void playMode(String x1, String x2){ //This is the method that determines a win, tie, or loss and prints the result.
		System.out.println("I choose " + x2);
		if (checkWin(x1, x2) == 3){
			System.out.println("You win.");
		} else if (checkWin(x1, x2)== 1){
			System.out.println("You lose.");
		} else {
			System.out.println("It's a tie.");
		}
	}
	
	public static String modeOne(){ //This prints a random counterattack.
		Random rand = new Random();
		int r = rand.nextInt(3);
		int temp = r;
		if (temp==0) {
			return "Rock";
		} else if (temp==1) {
			return "Paper";
		} else {
			return "Scissors";
		}
	}		
	
	public static void modeTwo(String x1){  //This mode is easy. It assumes the common pattern that the user will reuse whatever they won with and the computer will lose if they do.
		String firstmove = modeOne();
		playMode(x1, firstmove);
		Scanner keyboardthree= new Scanner(System.in); 			
		System.out.println("Rock, paper, or scissors?");			
		String usermovethree = keyboardthree.nextLine(); 	
		if (checkWin((x1), firstmove)==3){ //If the user won the first bout,
			playMode(usermovethree,firstmove); // Make the same move you did before
			System.out.println("Rock, paper, or scissors?");			
			String usermovefour = keyboardthree.nextLine(); 
			playMode(usermovefour, modeOne()); //After, make a random move.
		} else {
			String secondmove = modeOne(); //If the user lost the first bout,
			playMode(usermovethree,secondmove); //Play a random one.
			System.out.println("Rock, paper, or scissors?");			
			String usermovefive = keyboardthree.nextLine();
			if (checkWin(usermovethree, secondmove)==3){			//If the user lost the first but won the second, play the same thing for the third bout. 		
				playMode(usermovefive,modeFour(secondmove));
			} else {
				playMode(usermovefive, modeOne()); //Otherwise, choose a random counterattack.
			}
		}			
	}		
	
	public static void modeThree(String x1){ //This mode is easy. It assumes the common pattern that the user will reuse whatever they won with and the computer will lose if they do.
		String firstmove = modeOne();
		playMode(x1, firstmove);
		Scanner keyboardthree= new Scanner(System.in); 			
		System.out.println("Rock, paper, or scissors?");			
		String usermovethree = keyboardthree.nextLine(); 	
		if (checkWin((x1), firstmove)==3){ //If the user won the first bout,
			playMode(usermovethree,modeFour(x1)); //Play the opposite of what they won with
			System.out.println("Rock, paper, or scissors?");			
			String usermovefour = keyboardthree.nextLine(); 
			playMode(usermovefour, modeOne()); //The last bout is random
		} else {
			String secondmove = modeOne();
			playMode(usermovethree,secondmove);
			System.out.println("Rock, paper, or scissors?");			
			String usermovefive = keyboardthree.nextLine();
			if (checkWin(usermovethree, secondmove)==3){			 //If the user lost the first bout but won the second, play the opposite of what they won with for the third.		
				playMode(usermovefive,modeFour(usermovethree));
			} else {
				playMode(usermovefive, modeOne()); //Otherwise, choose a random counterattack.
			}
		}
	}	
	
	public static String modeFour(String x1){ //This mode automatically wins.
		if (x1.equalsIgnoreCase("Scissors")) {
			return "Rock";
		} else if (x1.equalsIgnoreCase("Rock")) {
			return "Paper";
		} else {
			return "Scissors";
		}
	}
	
	public static int checkWin(String x1, String x2){ //This method checks if you won or not.
		if (x1.equalsIgnoreCase("Scissors")&& x2.equalsIgnoreCase("Rock") || x1.equalsIgnoreCase("Rock") && x2.equalsIgnoreCase("Paper") || x1.equalsIgnoreCase("Paper") && x2.equalsIgnoreCase("Scissors")){
			return 1;
		}
		else if (x1.equalsIgnoreCase(x2) ) {
			return 2;
		}
		else {
			return 3;
		}
	}
}