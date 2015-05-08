import java.util.*;
public class ICE7 {
	
	// This exercise allows you to print the number of the instance that loop is on. 
	//By inputing an integer number into the call sequence, you will receive back a sequence
	//starting at one and ending with the chosen number. At first this program seemed a little
	//difficult, but then I realized I was trying to do something that we haven't quite gotten
	//to yet. After that I realized very quickly how this could work. Took me about fifteen
	//minutes to complete.
	
	

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		printNumbers(15);
		printNumbers(5);
		
		System.out.print("Please enter a number >=1:");// Modified first set up to now take in a 
		//user designated number on the console to run through the module. Added about ten
		//minutes to the time to complete.
		
		int a = x.nextInt();// Forms a space for a variable and collects it from the console.
		printNumbers(a);// Calls the method using user designated variable.
		x.close();// Closes scanner of console.

	}
	
	public static void printNumbers(int a){
		for (int i = 1; i<=a; i++){
			System.out.print("["+i+"]");// Loop that prints the number of the instance
			//the loop is currently on in between [].
		}
		System.out.println();// Moves to the next line to so that the next step in main method
		//can be carried out cleanly.
				
	}

}

// About thirty minutes of work all together with comments and scanner set up. I had fun
//with this one and it helped reiterate how to use the scanner and methods.
