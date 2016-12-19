
// Elizabeth Koshelev
// 11/1/15
// This uses a student's grades on homework, a midterm exam, and a final exam to calculate a final grade, as well as what grade they need on the final to get the grade they want.
import java.util.*;
public class GradeCalculator {
	public static void main(String[] args) {
		System.out.println("This program accepts your homework and exam scores as input, and computes your grade in the course or indicates what grade you need to earn on the final exam. \n"); //This describes the program.
		System.out.println("Homework:");
		
		Scanner findhomeworkweight= new Scanner(System.in); //This scans for the homeworkweight.
		System.out.print("    What is its weight (0-100)? ");			
		int homeworkweight = findhomeworkweight.nextInt(); 
		
		Scanner findhowmanyhomeworks= new Scanner(System.in); //This cans for how many homeworks.
		System.out.print("    How many homeworks? ");			
		int howmanyhomework = findhowmanyhomeworks.nextInt(); 
		
		int numberofhomeworks= howmanyhomework;
		double totalhomeworkscores=0;
		int totalhomeworknumerator=0;
		int totalhomeworkdenomenator=0;
		for(int i=1; i<= howmanyhomework; i++){
			Scanner homeworkscores= new Scanner(System.in);
			System.out.print("    Homework " + i + " score and max score: ");	// This loops the number of homeworks, then determines total score and total possible points.
			int firstscore = homeworkscores.nextInt(); 
			int secondscore =  homeworkscores.nextInt(); 
			totalhomeworknumerator+= firstscore;
			totalhomeworkdenomenator+=secondscore;
		}	
		double weightedhomeworkscore= calculateWeightedGrade(totalhomeworknumerator, 0, totalhomeworkdenomenator, homeworkweight); //This calls the static method to describe the weighted homework score.
		System.out.printf("    Weighted homework score:  %.2f \n \n", weightedhomeworkscore);
		
		System.out.println("Midterm Exam:"); //This set of scanners acquires the information for the midterm exam.
		Scanner findmidtermweight = new Scanner(System.in);
		System.out.print("    What is its weight (0-100)? ");			
		int midtermweight = findmidtermweight.nextInt(); 
		
		Scanner findmidtermscore= new Scanner(System.in);
		System.out.print("    Exam score: ");			
		int midtermscore = findmidtermscore.nextInt(); 
		
		Scanner findmidtermcurve = new Scanner(System.in);
		System.out.print("    Was there a curve? (1 for yes, 2 for no) ");			
		int midtermcurve = findmidtermcurve.nextInt(); 
		int midtermcurvevalue=0;
		if (midtermcurve == 1) {
			Scanner findmidtermcurvevalue = new Scanner(System.in);
			System.out.print("    How much was the curve? ");			
			midtermcurvevalue = findmidtermcurvevalue.nextInt(); 
		}
		double weightedmidtermscore = weightedmidtermscore= calculateWeightedGrade(midtermscore, midtermcurvevalue, 100, midtermweight); 
		System.out.printf("   Weighted exam score: %.1f \n \n", weightedmidtermscore);
		
		System.out.println("Final exam:"); //This set of scanners acquires information for the final exam.
		Scanner findfinal = new Scanner(System.in);
		System.out.print("    Have you taken the final exam? (1 for yes, 2 for no) ");			
		int ffinal = findfinal.nextInt(); 
		
		Scanner findfinalweight= new Scanner(System.in);
		System.out.print("    What is its weight (0-100)? ");			
		int finalweight = findfinalweight.nextInt(); 

		if (ffinal==1) {
		Scanner findfinalscore= new Scanner(System.in);
		System.out.print("    Exam score: ");			
		int finalscore = findfinalscore.nextInt(); 
		
		Scanner findfinalcurve= new Scanner(System.in);
		System.out.print("    Was there a curve? (1 for yes, 2 for no) ");			
		int finalcurve = findfinalcurve.nextInt(); 
		int finalcurvevalue=0;
		if (finalcurve==1) {
		Scanner findfinalcurvevalue= new Scanner(System.in);
		System.out.print("    How much was the curve? ");			
		finalcurvevalue = findfinalcurvevalue.nextInt(); 
		}
		
		double weightedfinalexamscore = calculateWeightedGrade(finalscore, finalcurvevalue, 100, finalweight); //This calls the static method to calculate the weighted final score.
		double totalgrade= calculateTotalGrade(weightedhomeworkscore, weightedmidtermscore, weightedfinalexamscore); //This calls a static method to calculate the total grade.
		System.out.printf("    Weighted exam score:  %.2f \n \n    Your course grade is %.2f \n", weightedfinalexamscore,totalgrade);
		//*FIND TOTAL SCORE
		
		}
		
		if (ffinal==2) {
			Scanner findtotalpercent= new Scanner(System.in);
			System.out.print("    What percentage would you like to earn in the course? ");			
			int totalpercent = findtotalpercent.nextInt(); 
			double scoreneed= calculateScoreNeed(totalpercent, weightedhomeworkscore, weightedmidtermscore, finalweight);
			double highestscoreget= calculateTotalGrade((double)finalweight, weightedmidtermscore, weightedhomeworkscore);
			if(scoreneed<100) {
				System.out.printf("    You need a score of %.2f on the final exam.", scoreneed);
			}
			else {
				System.out.printf("    You need a score of %.2f on the final exam. \n    Sorry, it is impossible to achieve this percentage. \n    The highest percentage you can get is %.2f.", scoreneed, highestscoreget);
			}
		}
	}
		public static double calculateWeightedGrade(int x1, int x2, int x3, int x4) { //This calculates a weighted grade.
			double weightedgrade=((double)x1+(double)x2)/(double)x3*(double)x4;
			return weightedgrade;
		}
		public static double calculateTotalGrade(double y1, double y2, double y3) { //This calculates the total grade.
			double totalgrade= y1 + y2 + y3;
			return totalgrade;
		}
		public static double calculateScoreNeed(int z1, double z2, double z3, int z4){ //This calculates the score needed to get a certain grade.
			double scoreneed= ((double)z1 - z2 - z3)/((double)z4)*100;
			return scoreneed;
		}
}