import java.util.*;
import java.io.*;
public class SentimentReport {
	private static ArrayList<File> books = new ArrayList<File>();
	private static String pos;
	private static String neg;
	public static final boolean TEST_MODE = false; //changing to true runs default options. Must have three required text files
	//saved in same folder as this programs src folder under the correct titles, Macbeth.txt, MuchAdoAboutNothing.txt, OliverTwist.txt. 
	

	/**
	 * Client class for Book Analyzer program. Allows the user to enter in a list of book text files and returns
	 * a report for each book file that contains the type of the book (comedy, tragedy, boring), counts and percentages for
	 * positive, negative and total number of words. The most common positive and negative words are returned along with the
	 * time taken (in milliseconds) to complete the analysis.
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException {
		intro();
		getReport(books, pos, neg);
	}

	/**
	 * Intro method used to gather input from user, the method is hard-coded for test mode using three files given for the 
	 * assignment as well as uses the default positive and negative word lists, provided in the assignments instructions.
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unused")
	private static void intro() throws FileNotFoundException {
		Scanner console = new Scanner (System.in);
		System.out.println("Welcome to Sentiment Analysis 2015!\n");
		if(TEST_MODE == true){
			String[] collection = {"Macbeth.txt","MuchAdoAboutNothing.txt","OliverTwist.txt"};
			for(String title:collection){
				stringValidifier(title,console, 1);
			}
			pos = "default";
		}
		else{
			System.out.println("Before we get started there's a few things I need to find out.");
			System.out.println("First, lets make a list of the books we want to do analysis of.");
			boolean done = false;
			while(done!=true){
				System.out.print("Please enter file pathway, enter next to move on to the next prompt: ");
				String input = console.next();
				if(input.equalsIgnoreCase("next")){
					done=true;
				}
				else{
					stringValidifier(input, console, 1);
				}
			}
			System.out.println("Next, will you be inputing your own positive and negative word lists?");
			System.out.print("Enter a yes or no: ");
			if(console.next().substring(0, 1).equalsIgnoreCase("y")){
				System.out.print("Please enter the file pathway for the positive list: ");
				String input = console.next();
				pos = stringValidifier(input, console, 2);
				System.out.print("Please enter the file pathway for the negative list: ");
				input = console.next();
				neg = stringValidifier(input, console, 2);
			}
			else{
				System.out.println("System default lists will be used for analysis.");
				pos = "default";
				neg = "default";
			}
		}
		
		console.close();
	}

	/**
	 * Method used to check and see if users input is accurate, i.e. that file does exist. If file doesn't exist
	 * user is continually re-prompted until correct pathway is entered.
	 * @param input - user entered file pathway as a string.
	 * @param console
	 * @param i 
	 * @return
	 */
	private static String stringValidifier(String input, Scanner console, int i) {
		File x = new File(input);
		if(!x.exists()){
			//boolean fixed = false;
			while(!x.exists()){
				System.out.println("Error file doesn't exist.");
				System.out.print("Please check pathway and enter again: ");
				input = console.next();
				x = new File(input);
			}
		}
		if(i == 1){
			books.add(x);
		}
		else{
			return input;
		}
		return null;
	}

	/**
	 * Method used to initiate creating the report and finishes printing it out.
	 * @param books2
	 * @param pos
	 * @param neg
	 * @throws FileNotFoundException
	 */
	private static void getReport(ArrayList<File> books2, String pos, String neg) throws FileNotFoundException {
		for(File book: books2){
			long startTime = System.currentTimeMillis();
			BookAnalyzer a = new BookAnalyzer(pos,neg,book);
			
			long endTime = System.currentTimeMillis();
			System.out.printf("\nThe book analyzed is: %s\n",book);
			a.output();
			System.out.printf("Time taken for sentiment analysis of %s: %d milliseconds.\n\n",book,(endTime-startTime));
		}
		
		
		
	}

}
