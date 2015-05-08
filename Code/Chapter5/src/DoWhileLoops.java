import java.util.*;
public class DoWhileLoops {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean done = false;
		while(!done){
			displayMenu();
			
			char selection = console.next().toLowerCase().charAt(0);
			// Looks at the users selection (as a string) converts it to lower case
			//then looks at the first character of the string.
			
			if (selection == 'q'){
				done = true;
			}
			else if(selection == 'g'){
				playGuessingGame(console);
				
			}
			else if(selection == 'r'){
				playDiceRollGame();
			}
			else{// Catch all for bad entries.
				System.out.println("Invalid input, please try again.");
			}
		}
		console.close();
		System.out.println("Thank you for using this program!");
	}

	private static void playDiceRollGame() {
		int roll;
		int count = 0;
		do{
			int dice1 = (int)(Math.random()*6)+1;
			int dice2 = (int)(Math.random()*6)+1;
			++count;
			roll = dice1+dice2;
			System.out.printf("%d + %d = %d\n", dice1, dice2, roll);
			
		}while(roll!=7);
		//for (int i = 1;i<=10;i++){
			//System.out.println((int)(Math.random()*6)+1);
			// Generating 10 random decimal numbers between 0-1 but not including one,
			//which is times by 6 then converted to integer, 1 is added at the end to 
			//keep from getting 0.
		//}
		if(count!=1){
			System.out.printf("You won after %d rolls.\n",count);
		}
		else{
			System.out.printf("You won after %d roll.\n",count);
		}
		System.out.println();
	}

	private static void playGuessingGame(Scanner console) {
		int secret = (int)(Math.random()*100)+1;
		int counter = 0;
		System.out.print("I am the computer, I have a secret number between 1 and 100. Can you guess it? ");
		int guess;
		do{
			guess = console.nextInt();
			if(guess < secret){
				System.out.printf("That number %d is too low, try again: ", guess);
			}
			else if(guess > secret){
				System.out.printf("That number %d is too high, try again: ", guess);
			}
			++counter;
			
		}while(guess!=secret);
		
		System.out.println();
		
		if(counter !=1){
			System.out.printf("Congratulations!\n Your guess of %d is correct!\n You got it in %d guesses.\n",guess,counter);
		}
		else{
			System.out.printf("Congratulations! Your guess of %d is correct! You got it in 1 guess.\n",guess);
		}
		System.out.println();
		
		
	}

	private static void displayMenu() {
		System.out.println("Enter one of the following options:");
		System.out.println("\tG for play a guessing game");
		System.out.println("\tR for play dice roll game");
		System.out.println("\tQ to exit this program");
		System.out.print("Enter: ");
		
	}

}
