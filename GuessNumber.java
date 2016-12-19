
// Elizabeth Koshelev
// 11/12/15
// This guesses a number that the user inputs between 1 and 1000.

import java.util.*;
public class GuessNumber {
	public static void main(String[] args) {
		int lower = 1; //This sets the initial condition for the lower bound
		int higher = 1000; //This sets the initial condition for the higher bound
		int startguess = (higher+lower)/2; //This sets the initial guess. The initial guess is halfway between the higher and lower bound because it eliminates the highest amount of possibilities 100% of the time.
		int startcounter=1;
		guessingGame(lower,higher,startguess,startcounter);
	}
	
	public static void guessingGame(int lowerbound, int higherbound, int guess, int counter){
		System.out.println("Think of a number 1 to 1000 and I'll guess it in 10 guesses!");
		int check = 1;
		for (int i=1; i <= counter; i++) {
			Scanner keyboard= new Scanner(System.in); 
			System.out.println("Is " + guess + " your number? (1 if yes, 2 if no)");			
			int number = keyboard.nextInt();  //This allows the user to deny or confirm if it is indeed their number.
			if (number==1) {
				System.out.println("I knew it!");
				System.out.print("That only took me " + counter + " guesses!");	
			} 
			if(number!=1 && counter<=10) {
				Scanner keyboardtwo= new Scanner(System.in); 
				System.out.println("Is it lower or higher? (1 for lower, 2 for higher)");	//This allows the user to state whether the number is higher or lower.	
				int guesshigherorlower = keyboardtwo.nextInt(); 	
				if (guesshigherorlower==2) { //This determines the case if it's higher.
					lowerbound= guess; //This sets the higher bound to the previous guess.
					guess = guessnumber(lowerbound, higherbound); //This calls a method to guess the next number halfway between what the user entered and the higher bound, which eliminates the most possibilities.
					counter++;
				} else{ //This determine's the case if it's lower.
					higherbound= guess; //This sets the higher bound to the previous guess.
					guess = guessnumber(lowerbound,higherbound);//This calls a method to guess the next number halfway between what the user entered and the lower bound, which eliminates the most possibilities.
					counter++;
				}
				if (counter > 10){
					counter=10;
					System.out.print("Did you change your number? Rethink of one and start the program again.");
				} 
			}
			}

	}
	
	public static int guessnumber(int x1, int x2){ //This calculates the number halfway between the previous two numbers.
		int guessone = (x1+x2) / 2;
		return guessone;
	}
}