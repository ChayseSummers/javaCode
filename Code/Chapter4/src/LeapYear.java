import java.util.*;
public class LeapYear {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a year: ");
		int year = console.nextInt();
		boolean answer = isLeapYear(year);
		if (answer == true){
			System.out.printf("The year %d is a leap year!",year);
		}
		else{
			System.out.printf("The year %d is not a leap year.",year);
		}
		
		console.close();
	}

	public static boolean isLeapYear(int year) {
		boolean type = false;
		if (year%4 == 0){
			if (year % 100 == 0){
				if (year % 400 == 0){
					type = true;// year = 2000
				}
				else{
					type = false;// year = 1900
				}
			}
			else{
				type = true;// year = 2016
			}
		}
		return type;
	}

}
