import java.util.*;
public class whileLoops {

	public static void main(String[] args) {
		// While loop takes a for loop and breaks it into three separate parts. 
		//Allows for indefinite loop.
		
		int num = 1;// Initializes the while loop.
		
		while(num<200){// Condition for the while loop.
			System.out.print(num+" ");
			num=num*2;// Update for the while loop.
		}
		System.out.println();
		for (int j = 1; j<=200;j=j*2){// As a for loop.
			System.out.print(j+" ");
		}
		
		System.out.println();
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Please enter a positive number (negative to quit): ");
		int number = console.nextInt();
		
		while(number>=0){
			System.out.print("Great job! Positive value entered... Enter next value: ");
			number = console.nextInt();
		}
		System.out.println("Well done... Thank you for playing!");
		console.close();

	}

}
