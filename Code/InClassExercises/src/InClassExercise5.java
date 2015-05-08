
public class InClassExercise5 {

	/**
	 * Chayse Summers
	 * CSC142 - Gandham
	 * January 20th, 2015
	 * ICE #5
	 */
	
	// This program took a little mental effort to figure out. Getting the loops nested correctly
	//with the correct parameters wasn't the most simple thing I've had to do, but
	//I think it has helped me learn about how to get nested loops to work the way I would like.
	//Took about thirty minutes to complete.
	
	
	public static void main(String[] args) {
		
		for (int x = 1; x<=6; x=x+1){// First loop here is to set how long the program runs
			//and at what increments.
			
			for (int i = 1; i<=7-x; i=i+1){
				System.out.print(i);
				// The first "nested" loop here runs through and 
				//prints each instance of i until reaching a designated stop at the number
				//I wish for the line to stop at.
			}
			
			System.out.println();// This line of code is to move down to the next line
			//in preparation for the spaces needed in front of the next set of numbers.
			
			for (int i = 5; i>=6-x; i=i-1){
				System.out.print(" ");
				// The second "nested" loop here print a space needed for each missing number
				//as the sequence continues.
			
			}
			
		}

	}
}
