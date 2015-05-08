import java.util.*;
public class SwitchStatements {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		char grade = intro(console);
		double gpa = 0;
		try{
			gpa = findGPA(grade);
			System.out.printf("GPA is: %.1f%n",gpa);
			int k = 10, j = 0;
			int x = k/j;
		}
		catch(IllegalArgumentException ie){
			System.out.println(ie.getMessage());
		}
		catch(ArithmeticException ae){
			System.out.println("Invalid! "+ae.getMessage());
		}
		console.close();
	}
	
	private static char intro(Scanner console) {
		System.out.print("Please enter grade to see GPA: ");
		char grade = console.next().toUpperCase().charAt(0);
		return grade;
	}

	public static double findGPA(char grade){
//		if(grade=='A')
//			return 4.0;
//
//		else if (grade == 'B')
//			return 3.5;
//		
//		else if (grade == 'C')
//			return 2.5;
//		else
//			return 0.0;
		
		//or use switch statement
		double gpa = 0.0;
		switch (grade){
		case 'A':
			gpa = 4.0;
			break;
		case 'B':
			gpa = 3.0;
			break;
		case 'C': case 'c': //can collapse multiple cases to account for this type of thing.
			gpa = 2.0;
			break;
		case 'D':
			gpa = 1.0;
			break;
		case 'F':
			gpa = 0.0;
			break;
		default:
			//System.out.println("Invalid entry!"); //This is a tempting way of including an error message
			//however you won't know if this code would work across devices.
			
			throw new IllegalArgumentException("Invalid Entry!");//This is a better method for error message.
		}
		return gpa;
	}

}
