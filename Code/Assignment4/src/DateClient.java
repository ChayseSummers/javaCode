/*Chayse Summers
 * CSC142 - Gandham
 * March 19th, 2015
 * Assignment 4
 */
import java.util.*;
public class DateClient {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Please enter todays date in [month day year] format: ");
		Date current = new Date(console.nextInt(),console.nextInt(),console.nextInt());
		
		System.out.print("Please enter your birth date in [month day year] format: ");
		Date bday = new Date(console.nextInt(),console.nextInt(),console.nextInt());
		console.close();
		
//		System.out.println("Are these two dates the same?: "+current.equals(bday));
//		
//		System.out.println("The current year is: "+current.getYear());
//		System.out.println("The current month is: "+current.getMonth());
//		System.out.println("The current day is: "+current.getDay());
//		System.out.println("The current date is: "+current);
//		System.out.println("Is the current date in a leap year?: "+current.isLeapYear());
//		
//		System.out.println("The birth year is: "+bday.getYear());
//		System.out.println("The birth month is: "+bday.getMonth());
//		System.out.println("The birth day is: "+bday.getDay());
//		System.out.println("The birth date is: "+bday);
//		System.out.println("Is the birth date in a leap year?: "+bday.isLeapYear());
//		
//		Date test = new Date(9,20,2010);
//		Date testAdvance = new Date(9,29,2010);
//		System.out.println(test.advanceTo(testAdvance));
//
//		current.nextDay();
//		System.out.println("The next day is: "+current);
		
		System.out.println("You were born on "+bday+", which was a "+bday.getDayOfWeek());
		System.out.println("You are "+bday.advanceTo(current)+" days old.");	
	}

}
