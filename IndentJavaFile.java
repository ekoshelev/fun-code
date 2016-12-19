// Elizabeth Koshelev
// 12/12/15
// This program automatically indents a java file.

import java.io.*; 
import java.util.*; 

public class IndentJavaFile{
	public static final int INDENT = 4; //Change this to change the indent space.
	public static void main(String[] args) throws FileNotFoundException {//This takes the information from the user.
		System.out.println("Please enter the name of the java file."); 
		Scanner console = new Scanner(System.in);
		String one = console.next();
		Scanner two = new Scanner(new File(one));
		sortScanner(two, one);
	}
	public static void sortScanner(Scanner first, String firstfile) throws FileNotFoundException { //This indents the file.
		PrintStream out = new PrintStream(new File("out.txt"));
		int counterin=-1;
		int counterback=0;
		int resetindent=1;
		while(first.hasNextLine() ) {
			String linefirst = first.nextLine();
			for (int i=1; i<=resetindent; i++){
				while(linefirst.startsWith(" ")){
					resetindent++;
					linefirst=linefirst.substring(i,linefirst.length()+1);//This resets the line so there is no space at the beginning.
				}
			}
			for (int i=0; i<linefirst.length(); i++){//This determines how much space to go back.
			if(linefirst.charAt(i) == '}'){
				counterback++;
				}
			}
			for (int i=0; i<(counterin)*INDENT-counterback*INDENT; i++){//This sets the space.
				out.print(" ");
			}
			out.println(linefirst);
			for (int i=0; i<linefirst.length(); i++){
				if(linefirst.charAt(i)== '{'){ //This determines how much space to go forward.
				counterin++;
				}
			}
		}			
	}
}