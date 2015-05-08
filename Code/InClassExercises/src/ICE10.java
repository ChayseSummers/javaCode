import java.util.*;
public class ICE10 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a month by its number to see how many days are in that month: ");
		int month = console.nextInt();
		int days = daysInMonth(month);
		if (month<1){
			System.out.println("Error, this is not a valid month number.");
		}
		else if (month > 12){
			System.out.println("Error, this is not a valid month number.");
		}
		else{
			System.out.printf("Month %d contains %d days this year.",month,days);
		}
		console.close();
		
	}

	private static int daysInMonth(int A) {
		int numDays = 0;
		
		if (A==2){
			numDays = 28;
		}
		
		else if (A<8){
			if (A % 2 != 0){
				numDays = 31;
			}
			else{
				numDays = 30;
			}
		}
		
		else if (A<13){
			if (A % 2 != 0){
				numDays = 30;
			}
			else{
				numDays = 31;
			}
		}
		
		return numDays;
	}

}
