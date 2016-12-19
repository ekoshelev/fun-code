
// Elizabeth Koshelev
// 11/1/15
// The user inputs a number and it is displayed in roman numerals, given that it is below 5000.;

import java.util.*;
public class FindRomanNumeral {
		public static void main(String[] args) {
			Scanner keyboard= new Scanner(System.in); //This scanner allows the user to input the number of choosing.
			System.out.println("Write an integer:");			
			int number = keyboard.nextInt();
			int r = number;			
			if (number >= 1000) { //This series of if statements and loops determines the number of 1000s, 900s, 500s, 400s, 100s, 90s, 50s, 40s, 10s, 5s, and 1s and prints the appropriate symbol.
				for (int i=1; i <= r/1000; i++) {
					System.out.print("M");
				}
			}
			r-= 1000*(r/1000); //This takes the remainer of the number from values previously calculated.
			if (number >= 900) {
				for (int i=1; i <= r/900 ; i++) {
					System.out.print("CM");
				}
			}	
			r-= 900*(r/900);
			if (number >= 500){
				for (int i=1; i <=r/500; i++){
					 System.out.print("D");
				}
			}
			r-= 500*(r/500);
			if (number >= 400) {
				for (int i=1; i <= r/400 ; i++) {
					System.out.print("CD");
				}
			}
			r-= 400*(r/400);
			if (number >= 100) {
				for (int i=1; i <= r/100; i++) {
					System.out.print("C");
				}	
			}
			r-= 100*(r/100);
			if (number >= 90) {
				for (int i=1; i <= r/90 ; i++) {
					System.out.print("XC");
				}
			}
			r-= 90*(r/90);
			if (number >= 50) {
				for (int i=1; i <= r/50; i++) {
					System.out.print("L");
				}
			}
			r-= 50*(r/50);
			if (number >= 40) {
				for (int i=1; i <= r/40; i++) {
					System.out.print("XL");
				}
			}
			r-= 40*(r/40);
			if (number >= 10) {
				for (int i=1; i <= r/10; i++) {
					System.out.print("X");
				}
			}
			r-= 10*(r/10);
			if (number >= 9) {
				for (int i=1; i <= r/9 ; i++) {
					System.out.print("IX");
				}
			}
			r-= 9*(r/9);
			if (number >= 5) {
				for (int i=1; i <= r/5 ; i++) {
					System.out.print("V");
				}
			}
			r-= 5*(r/5);
			if (number >= 4) {
				for (int i=1; i <= r/4 ; i++) {
					System.out.print("IV");
				}
			}
			r-= 4*(r/4);
			for (int i=1; i <= r ; i++) {
				System.out.print("I");
			}
	}
}	