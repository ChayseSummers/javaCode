import java.util.*;
import java.io.*;
public class SentimentReport {
	private static ArrayList<File> books = new ArrayList<File>();

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		try {
			intro(console);
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
		}
		//BookAnalyzer x = new BookAnalyzer(positive, negative, books);
		

	}

	private static void intro(Scanner console) throws FileNotFoundException {
		String positive;
		String negative;
		System.out.println("Welcome!\nThis program is designed to analyze a book (in the form of a text file) and return a report of what type of book it is.");
		System.out.println("We will first need to gather info from you, the user.");
		books = gatherBookList(console);
		System.out.println("Next please enter the pathway for the list of positive words.");
		positive = gatherPathway(console);
		System.out.println("Next please enter the pathway for the list of negative words.");
		negative = gatherPathway(console);
		}

	private static String gatherPathway(Scanner console2) {
		//Scanner console = new Scanner(System.in);
		System.out.print("Enter pathway now: ");
		String x = console2.next();
		console2.reset();
		return x;
	}

	private static ArrayList<File> gatherBookList(Scanner console2) throws FileNotFoundException {
		//Scanner console = new Scanner (System.in);
		int x = 1;
		ArrayList<File> list = new ArrayList<File>();
		while(x!=0){
			System.out.print("\tPlease enter the file pathway: ");
			String title = console2.next();
			File book = new File(title);
			list.add(book);
			System.out.println("\tWould you like to add another book?");
			System.out.print("Enter 0 to finish adding to list of books, enter 1 to continue adding to list of books: ");
			x = console2.nextInt();
		}
		
		console2.reset();
		return list;
		
	}

}
