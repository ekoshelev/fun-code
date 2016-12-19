
// Elizabeth Koshelev
// 11/1/15
// This prompts for two people’s birthday, and the current day. The program figures out how many days remain until each user’s
//birthday and which birthday is sooner. 
import java.util.*;
public class BirthdayDistance {
	public static void main(String[] args) {
		System.out.println("Give me two birthdays and I'll tell you which one is sooner, assuming it is not a leap year!"); //This series of scanners obtains the dates from the user.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Write the day of the first person's birthday:");			
		int day1 = keyboard.nextInt();
		
		Scanner console= new Scanner(System.in);
		System.out.println("Write the month (in number form) of the first person's birthday:");			
		int month1 = console.nextInt();
		
		Scanner type = new Scanner(System.in);
		System.out.println("Write the day of the second person's birthday:");			
		int day2 = type.nextInt();
		
		Scanner hi= new Scanner(System.in);
		System.out.println("Write the month (in number form) of the second person's birthday:");			
		int month2 = hi.nextInt();
		
		Scanner typetwo= new Scanner(System.in);
		System.out.println("Write the current day:");			
		int day3 = typetwo.nextInt();
		
		Scanner newkeyboard= new Scanner(System.in);
		System.out.println("Write the current month:");			
		int month3 = newkeyboard.nextInt();
		
		int totaldays1; //This declares the integers before the loop.
		int totaldays2;
		if(month3 <= month1){
			totaldays1 = Math.abs(totalMonthDays(day1,month1) - totalMonthDays(day3,month3)) ; //This determines the case in which the current day is before the birthday.
		}
		else{
			totaldays1= 365-Math.abs(totalMonthDays(day1,month1)-totalMonthDays(day3,month3)); //This determines the case in which the current day is after the birthday.
		}
		if(month3 <= month2){
			totaldays2 =  Math.abs(totalMonthDays(day2,month2) - totalMonthDays(day3,month3)); //Same as above for second birthday.
		}			
		else{
			totaldays2 = 365-Math.abs(totalMonthDays(day2,month2)-totalMonthDays(day3,month3));
		}
		System.out.println("There are " + totaldays1 + " days until the first person's birthday! There are " + totaldays2 + " days until the second person's birthday!");	
		
		if (totaldays1 > totaldays2){ //This if statement determines which birthday is sooner.
			System.out.println("The second person's birthday is sooner!");			
		}
		else {
				System.out.println("The first person's birthday is sooner!");
		}
}
		public static int findMonthDays(int x1){ //This determines the number of days in each month.
			if (x1==1 || x1==3 || x1==5 || x1==7 || x1==8 || x1==10 || x1==12){
				return 31; }
			else if (x1==4 || x1==6 || x1==9 || x1 == 11){
				return 30;
			} else  {
					return 28;
				}
			}
			
		public static int totalMonthDays(int r1, int r2){ //This method counts the days in the year, from Jan 1st, up to the day the user inputs inthe form (days, months).
			int counter = 0;
			for(int i = 1; i < r2; i++){
				counter+=findMonthDays(i);
				}
				int totaldays= r1 + counter-1;
				return totaldays;
			}
}