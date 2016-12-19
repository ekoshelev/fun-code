
// Elizabeth Koshelev
// 11/12/15
// This guesses a word that the user inputs.

import java.util.*;
public class GuessWord {
	public static void main(String[] args) {
		guessWord(); //This calls the method that guesses the word.
	}

	public static void guessWord(){ //This method guesses the word.
		Scanner keyboard= new Scanner(System.in); 
		System.out.println("Please print a word for me to guess, letters only:");			
		String word = keyboard.next();  //This allows the user to input a word.
		int counter = 0;
		String guess = guessString(word); //This calls the method to create a string of _ as long as the word the user inputs.
		String lettersused = ""; //This starts an empty string that will store all previous letters used so they are not repeated.
		while (counter < word.length()) {	//While the number of letters guessed is less than the word length...
			char temp = randomLetter();
			if (checkLetters(temp,lettersused)==true){	//This calls a method to check if the random letter has already been used. If not, then the program will run.
				lettersused += temp; //This adds the random letter to the lettersused string.
				System.out.print("I guess " + temp + ". Current state: " ); //This states the guess.
				for (int i=0; i< word.length(); i++) {
					char letter = word.charAt(i); //This defines each letter with respect to i.
					if (letter == temp) { //If the letter is equal to the random letter...
						if (guess.substring(i,i+1).equals("_")){//And the previous string guess has a blank "_" ...
							counter++;	//This counts the number of guessed letters for the while loop.
							String a = guess.substring(0,i);
							String b = guess.substring(i+1);
							guess = a + temp + b; //Replace that _ with the letter.
							
						}
					}			
				}
				System.out.println(guess);
			}
		}	
	}
	
	public static String guessString(String x1){ //This creates a string with as many "_"s as letters in the word.
		int i = x1.length();
		String n= "";
		while (i>0) {
			n+="_";
			i--;
		}
		return n;
	}
	
	public static char randomLetter(){ //This uses the java API to call random letters. Lowercase a starts at 97.
		Random rand = new Random();
		int guess =rand.nextInt(26);
		char guessletter = (char) (97+guess);
		return guessletter;
	}
	
	public static boolean checkLetters(char x1, String x2){ //This checks if the letter has already been used by checking the string of used letters with a random letter.
		for (int i=0; i<x2.length(); i++){
			if (x2.charAt(i)== x1){
				return false;
			}
		}
		return true;
	}
	
}