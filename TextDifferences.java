// Elizabeth Koshelev
// 12/12/15
// This program prints the differences in two text files.

import java.io.*; 
import java.util.*;

public class TextDifferences{
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Please enter the name of the first file, then the second file."); //This takes the information from the user.
		Scanner console = new Scanner(System.in);
		String firstfile = console.next();
		String secondfile = console.next();
		Scanner one = new Scanner(new File(firstfile));
		Scanner two = new Scanner(new File(secondfile));
		findDifferences(one, two);	
	}
	public static void findDifferences(Scanner first, Scanner second){ //This finds and prints the differences.
		int counter=0;
		System.out.println("Differences found:");
		while(first.hasNextLine() && second.hasNextLine()) {
			String linefirst = first.nextLine();
			String linesecond = second.nextLine();
			counter++;
			if(!linefirst.equals(linesecond)){ //If one line does not equal another, print them.
				System.out.println("Line " + counter + ": \n < " + linefirst + " \n >" + linesecond);
			}
		}
	}
}