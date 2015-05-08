
/**
 * Chayse Summers
 * CSC142 - Gandham
 * January 22, 2015
 * In Class Exercise 6
 */

// This was a very interesting problem. I liked figuring out how to reflect the image from
//the right side to the left. Took me about thirty to forty minutes to complete, started out
//writing code on paper.

public class ICE6 {

	public static void main(String[] args) {
		String x = "*";
		
		for (int i = 1; i<=5; i++){
			// Main loop here is to set how many lines will be printed, or rather how
			//large our structure becomes.
			
			for (int star = i; star<=i; star++){
				System.out.print(x);
				
				// This first loop inside the main loop will be to print stars for the left side
				//of the structure.
			}
			
			for (int space = (10-i); space >= i; space--){
				System.out.print(" ");
				
				// This second loop inside the main loop will be to print the spaces
				//for the left side of the structure.
				//
				// By changing the parameter for this loop from 10-i to 9-i
				//would take away the space in between the two sides on the bottom line. 	
			}
			
			for (int space = (9-i); space >= i; space--){
				System.out.print(" ");
				
				// This third loop inside the main loop will print the spaces needed for the
				//right side of the structure.
			}
			
			for (int star = i; star<=i; star++){
				System.out.println(x);
				
				x = x + "**";
				
				// This fourth and last loop inside the main loop will print the stars for the
				//right side of the structure, after which it updates variable x to be ready
				//to print the next line starting back at the top of the inside of the main loop.
			}
		
			// System.out.println(); was able to get rid of this line by changing the last
			//loop inside the main loop to have a println statement instead of a print statement.
			
		}
		
	}
}
