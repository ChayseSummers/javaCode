import java.util.*;


public class dateValidifier {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a date in format month<space>day<space>year: ");
		int month = console.nextInt();
		int day = console.nextInt();
		int year = console.nextInt();
		console.close();
		boolean type = validate(month,day,year);
		if (type == true){
			System.out.printf("The date %s/%s/%s is valid.",month,day,year);
		}
		else{
			System.out.printf("Error, the date %s/%s/%s is not valid.",month,day,year);
		}
	}

	private static boolean validate(int month, int day, int year) {
		boolean type = false;
		if (year >= 1900 && year <= 2100){
			if (month >= 1 && month <= 12){
				if (day >= 1 && day<= maxDays(month,year)){
					type = true;
				}
			}
		}	
		return type;
	}

	private static int maxDays(int month, int year) {
		int max;
		if (month == 1||month == 3||month==5||month == 7||month == 8||month == 10||month == 12 ){
			max = 31;
		}
		else if(month == 4||month == 6||month == 9||month == 11){
			max = 30;
		}
		else{
			if (isLeapYear(year)==true){
				max = 29;
			}
			else{
				max = 28;
			}
			
		}
		return max;
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
