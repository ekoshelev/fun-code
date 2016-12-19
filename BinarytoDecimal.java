// Elizabeth Koshelev
//10/9/15
// This converts a 4 digit binary number to decimal.
import java.util.*;

public class BinarytoDecimal {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Write a four digit binary number:");
		String s1 = console.nextLine();
		char character; //This isolates each character in the string.
		char first = s1.charAt(0); 
		char second = s1.charAt(1); 
		char third = s1.charAt(2); 
		char fourth = s1.charAt(3);
		int firstdigit = digitTotal((int)first); //This calls a static method to convert the character to an int.
		int seconddigit = digitTotal((int)second);
		int thirddigit = digitTotal((int)third);
		int fourthdigit = digitTotal((int)fourth);
		int fulldecimal = decimalTotal(firstdigit,seconddigit,thirddigit,fourthdigit);  //This calls a static method to find the decimal version of the number.
		System.out.println("The decimal version is " + fulldecimal+ "."); //This prints the decimal.
	}
	//The following static method converts the character of binary into it's corresponding integer, using the java API as a reference.
	public static int digitTotal(int x1){
		int digit = x1 - 48;
		return digit;
	} 
	//The following calculates the final decimal number.
	public static int decimalTotal(int y1, int y2, int y3, int y4){
		int decimal = y1*8+y2*4+y3*2+y4*1;
		return decimal;
	} 
}