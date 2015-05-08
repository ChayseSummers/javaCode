/*Chayse Summers
 * CSC142 - Gandham
 * February 24th, 2015
 * ICE15
 */

import java.util.*;
public class ICE15 {

	public static void main(String[] args) {
		makeGuesses();

	}

	private static void makeGuesses() {
		 int x =(int)(Math.random()*50)+1;// Generates a random number between 1-50.
		 int counter = 0;// Variable to keep track of the number of guesses.
		 while (x<=49){// Loop continues to execute until a guess of 49 or 50.
			 System.out.printf("guess = %d\n",x);// Prints out guesses < 49.
			 x= (int)(Math.random()*50)+1;// Next guess.
			 counter = counter + 1;// Counting the number of guesses.
		 }
		 
		 // Final output of the last guess, either 49 or 50, and the number of guesses
		 //it took to get to this point.
		 System.out.printf("The final guess: %d\n",x);
		 System.out.printf("The number of guesses was: %d",counter);
		 
		
	}

}
