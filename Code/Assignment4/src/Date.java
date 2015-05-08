/*Chayse Summers
 * CSC142 - Gandham
 * March 19th, 2015
 * Assignment 4
 */

	// This was a very interesting assignment. It has opened up a whole new way to think about programming.
//Object oriented coding is where it's at. It makes complete sense once you understand how this type of coding works.
//We are creating Date objects and then using that object to find info or test info or to modify the Date objects.
//This project took me around 6-7 hours total to complete. I worked with a few other guys to get the general understanding
//of how object oriented programming works, but was able to figure out the specific details for the methods on my own.
//I really liked this program because it was challenging, but also because it gave me something tangible/useable in the
//end. The sections that gave me more trouble was in the advanceTo and getDayOfWeek methods. This is only because at first
//I thought it was working correctly, upon further testing however I discovered it wasn't. A little bit of tracing 
//what was happening with the code and thorough testing of many different dates I was able to get it on track and 
//even clean up the code a bit making it more efficient. Thanks for a great quarter, I had fun! See you next quarter!

public class Date {
	//Fields (class constants)
	private int y;
	private int m;
	private int d;
	private int count = 0;
	
//Constructor: creates new Date objects.	
	public Date(int month, int day, int year) {
		y = year;
		m = month;
		d = day;
	}
	
//Actions: methods to use on created Date objects.
	public int getYear(){// Returns the year of Date object if valid.
		if(y>=1753&&y<=9999){
			return y;
		}
		else{
			System.out.println("Error: Invalid Year.");
			return y;
		}
		
	}

	public int getMonth() {// Returns the month of Date object if valid.
		if(m>=1&&m<=12){
			return m;
		}
		else{
			System.out.println("Error: Invalid Month.");
			return m;
		}
		
	}
	
	public int getDay() {// Returns day of Date object if valid.
		if(d>=1&&d<=31){
			return d;
		}
		else{
			System.out.println("Error: Invalid Day.");
			return d;
		}
	}
	
	public String toString() {// Prints Date object in year/month/day format.
		return (y+"/"+m+"/"+d);
	}
	
	public boolean equals(Date d2){// Method to check if the two dates are the same.
		//**Must be called before advanceTo method in order output correctly.**
		
		return(this.y == d2.y && this.d == d2.d && this.m == d2.m);	
	}
	
	public boolean isLeapYear() {// Checks a Date object to see if it's in a leap year.
		boolean type = false;
		if (y%4 == 0){
			if (y % 100 == 0){
				if (y % 400 == 0){
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
	
	public void nextDay(){// Advances Date object to the next day.
		if (m == 1||m == 3||m == 5||m == 7||m == 8||m == 10||m == 12 ){
			if(d==31 && m < 12){
				d = 1;
				m = m + 1;
			}
			else if(d==31 && m == 12){
				d = 1;
				m = 1;
				y = y + 1;
			}
			else{
				d = d + 1;
			}
		}
		else if(m == 4||m == 6||m == 9||m == 11){
			if(d==30){
				d = 1;
				m = m + 1;
			}
			else{
				d = d + 1;
			}
		}
		
		else if (m==2){

			if(isLeapYear()==true && d==29 || isLeapYear() == false && d == 28){
				d = 1;
				m = m + 1;
			}
			else{
				d = d + 1;
			}
		}
			
		else{
			System.out.println("Invalid entry: Month not applicable.");
		}
	}
	
	public int advanceTo(Date endDay){// Returns a count of the days to go from date1 to date2 provided that 
		//date1<date2.
		
		if(this.y>endDay.y||this.y==endDay.y && this.m>endDay.m||this.y==endDay.y &&this.m==endDay.m && this.d>endDay.d){
			System.out.println("Error: Invalid Entry! Cannot travel back in time! Haha!");
		}
		while(this.y<endDay.y||this.m<endDay.m||this.d<endDay.d){
			if(this.y<endDay.y||this.m<endDay.m||this.m==endDay.m&&this.d<=endDay.d){
				++count;
				this.nextDay();
			}
			else{
				System.out.println("Stuck in loop!");//Check in place when working out bugs.
			}
		}
		
		return count;
	}
	
	public String getDayOfWeek(){// Returns what day of the week a Date object is by checking it against 
		//the source Date object using the nextDay() method which utilizes the isLeapYear() method.
		
		Date source = new Date(01,01,1753);
		String[] day = {"Monday.","Tuesday.","Wednesday.","Thursday.","Friday.","Saturday.","Sunday."};
		int i = 0;
		String currentDay = day[i];
		while(source.y<this.y||source.m<this.m||source.d<this.d){
			source.nextDay();
			i++;
			if(i==7){
				i=0;
			}
			currentDay = day[i];
		}
		return currentDay;
	}

}
