

// Elizabeth Koshelev
// 11/1/15
// This gives the day of the week when the user inputs a date.
import java.util.*;
public class DayofWeek {
		public static void main(String[] args) {
			System.out.println("Give me a date and I'll give you the day of the week!"); //The following scanners obtain the information from the user.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Write the day:");			
		int day = keyboard.nextInt();
		
		Scanner console= new Scanner(System.in);
		System.out.println("Write the month (in number form):");			
		int month = console.nextInt();
		
		Scanner type= new Scanner(System.in);
		System.out.println("Write the year:");			
		int year = type.nextInt();
		
		int totaldays = totalMonthDays(day,month,year) + findYearsDays(year); //This finds the total days from the Monday give in 1601.
		findday(totaldays); //This calls the method that determines the day of the week.
		}
		public static void findday(int c2) { //This method determines the day of the week by taking the total days mod 7.
		int dayofweek= c2%7;
			if (dayofweek==0) {
				System.out.print("It's a Monday!");
			}
			 else if (dayofweek==1) {
				System.out.print("It's a Tuesday!");
			}
			 else if (dayofweek==2) {
				System.out.print("It's a Wednesday!");
			}
			else if (dayofweek==3) {
				System.out.print("It's a Thursday!");
			}
			else if (dayofweek==4){
				System.out.print("It's a Friday!");
			}
			else if (dayofweek==5) {
				System.out.print("It's a Saturday!");
			}
			else {
				System.out.print("It's a Sunday!");
		}
		}
		public static int findMonthDays(int x1, int y1){ //This method declares the number of days in each month.
			if (x1==1 || x1==3 || x1==5 || x1==7 || x1==8 || x1==10 || x1==12){
				return 31; }
			else if (x1==4 || x1==6 || x1==9 || x1 == 11){
				return 30;
			} else  {
				if (checkLeapYear(y1) == true ){
					return 29;
				}
				else {
					return 28;
				}
			}
		}
		public static boolean checkLeapYear(int x2){ //This method checks if it is a leap year.
			if (x2%400==0){
				return true;
			}
			else if (x2%100==0){
				return false;
			}
			else if (x2%4==0){
				return true;
			}
			else {
				return false;
			}
		}
		public static int findYearsDays(int r3){ //This method determines the total number of years up to the date given from 1601, including leap years.
			int counter = 0;
		for(int i = 1601; i < r3; i++){
			if (checkLeapYear(i)==true){
				counter+=366;
				}
			else {
				counter+=365;
			}
		}
		return counter;
		}
		public static int totalMonthDays(int r1, int r2, int r3){ //This method determines the total number of days in the months up to the date given from Jan 1st.
			int counter = 0;
			for(int i = 1; i < r2; i++){
				counter+=findMonthDays(i, r3);
				}
				int totaldays= r1+ counter-1;
				return totaldays;
				}
	}