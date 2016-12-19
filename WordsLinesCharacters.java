import java.io.*; 
import java.util.*;
// Elizabeth Koshelev
// 12/12/15
// This program returns the number of words, lines, and characters of a text document.
public class WordsLinesCharacters{
	public static void main(String[] args) throws FileNotFoundException { //This gets the information from the user.
		System.out.println("Please enter the name of the file."); 
		Scanner console = new Scanner(System.in);
		String name = console.next();
		Scanner input = new Scanner(new File(name));
		printStats(input);
	}
	public static void printStats(Scanner input){ //This method determines the statistics.
		int countwords = 0;
		int countlines = 0;
		int countchars = 0;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			countlines++; //This tallies the lines.
			while(lineScan.hasNext()){
				String word = lineScan.next();
				countchars+=word.length(); //This tallies the characters in each word, including punctuation. It counts every set of symbols as a word.
				countwords++;
			}
		}	
		System.out.println("There are " + countchars + " characters. \n There are " + countwords + " words. \n There are " + countlines + " lines." );
	}
}