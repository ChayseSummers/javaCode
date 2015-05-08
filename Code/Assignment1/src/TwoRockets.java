
public class TwoRockets {

	/**
	 * Chayse Summers
	 * CSC142 - Gandham
	 * January 16, 2015
	 * Assignment 1 - #2.)
	 */
	
	// This program allows for multiple static methods to be called in order to build a rocket.
	//While some redundancies can be reduced by creating different static methods for different parts,
	//other redundancies couldn't be avoided, such as creating the second rocket next to the first.
	//I found that creating the rocket was rather easy and fun, but trying to figure out how to 
	//duplicate it right next to the original without typing out another rocket proved to be 
	//unfruitful. Took me about forty five minutes, mostly due to trying to figure out if I could
	//get the function to be called multiple times to create the second ship.
	
	public static void topBottom() {
		System.out.println("   /\\   "+" "+"   /\\   ");
		System.out.println("  /  \\  "+" "+"  /  \\  ");
		System.out.println(" /    \\ "+" "+" /    \\ ");
		// This method creates both the top and bottom of the rocket.

	}
	
	public static void blank(){
		System.out.println("+------+"+" "+"+------+");
		System.out.println("|      |"+" "+"|      |");
		System.out.println("|      |"+" "+"|      |");
		System.out.println("+------+"+" "+"+------+");
		// This method creates the blank pieces of the ship.
	}
	
	public static void logo(){
		System.out.println("|United|"+" "+"|United|");
		System.out.println("|States|"+" "+"|States|");
		// This method creates the logo for the ship.
	}
	
	public static void main(String[] args) {
		topBottom();
		blank();
		logo();
		blank();
		topBottom();
		// Here each method is called in sequence in order to create the rocket ship.
	}
}
