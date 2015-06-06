import java.util.*;
import java.io.*;
public class SentimentReport {
	private static ArrayList<File> books = new ArrayList<File>();
	private static String pos;
	private static String neg;
	public static final boolean TEST_MODE = false;
	

	public static void main(String[] args) throws FileNotFoundException {
		//File z = new File("Macbeth.txt");
		//File w = new File("MuchAdoAboutNothing.txt");
		//File u = new File("OliverTwist.txt");
		intro();
		getReport(books, pos, neg);
	}

	@SuppressWarnings("unused")
	private static void intro() throws FileNotFoundException {
		Scanner console = new Scanner (System.in);
		System.out.println("Welcome to Sentiment Analysis 2015!");
		if(TEST_MODE == true){
			String[] collection = {"Macbeth.txt","MuchAdoAboutNothing.txt","OliverTwist.txt"};
			for(String title:collection){
				File x = new File(title);
				books.add(x);
			}
			pos = "default";
		}
		else{
			System.out.println("Before we get started there's a few things I need to find out.");
			System.out.println("First, lets make a list of the books we want to do analysis of.");
			boolean done = false;
			while(done!=true){
				System.out.print("Please enter file pathway, enter true to move on to the next prompt: ");
				String input = console.next();
				if(input.equalsIgnoreCase("true")){
					done=true;
				}
				else{
					fileValidifier(input, console);
				}
			}
			System.out.println("Next, will you be inputing your own positive and negative word lists?");
			System.out.print("Enter a yes or no: ");
			if(console.next().substring(0, 1).equalsIgnoreCase("y")){
				System.out.print("Please enter the file pathway for the positive list: ");
				String input = console.next();
				pos = stringValidifier(input, console);
				System.out.print("Please enter the file pathway for the negative list: ");
				input = console.next();
				neg = stringValidifier(input, console);
			}
			else{
				System.out.println("System default lists will be used for analysis.");
				pos = "default";
				neg = "default";
			}
		}
		
		console.close();
	}

	private static String stringValidifier(String input, Scanner console) {
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
		return input;
		
	}

	private static void fileValidifier(String input, Scanner console) {
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
		books.add(x);
	}

	private static void getReport(ArrayList<File> books2, String pos, String neg) throws FileNotFoundException {
		for(File book: books2){
			long startTime = System.currentTimeMillis();
			BookAnalyzer a = new BookAnalyzer(pos,neg,book);
			
			long endTime = System.currentTimeMillis();
			System.out.printf("The book analyzed is: %s\n",book);
			a.output();
			System.out.printf("Time taken for sentiment analysis of %s: %d milliseconds.\n\n",book,(endTime-startTime));
		}
		
		
		
	}

}
