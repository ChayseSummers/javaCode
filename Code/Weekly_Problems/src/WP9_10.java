import java.io.*;
import java.util.*;

/**
 * This class shows the difference between speeds when using different types of set lists.
 * The program allows the user to input which two .txt files they would like to test and then searches for the words of one book in
 * the other, while also keeping track of the time it takes to do so using different types of Tree and Hash set combinations.
 * What we find is that using a hash set with a hash set is the fastest, but using a tree set with a hash set is almost as fast.
 * The opposite also occures where a hash set over a tree is the slowest, but a tree set over a tree is just as slow or barely faster.
 * 
 * @author Chayse Summers
 * @class CSC143 - Gandham
 * @date 5/8/15
 *
 */
public class WP9_10 {
	private static Set<String> BookA_Hash = new HashSet<String>();
	private static Set<String> BookA_Tree = new TreeSet<String>();// Hash is stored linked, tree is ordered.
	private static Set<String> BookB_Hash = new HashSet<String>();
	private static Set<String> BookB_Tree = new TreeSet<String>();
	private static String a;// = "The Sign of the Four";        //Test books, commented out to allow user to input their own book pathway.
	private static String b;// = "The Return of Sherlock Holmes";
	private static long BookA_HashTimeH;
	private static long BookA_HashTimeT;
	private static long BookA_TreeTimeH;
	private static long BookA_TreeTimeT;
	private static long BookB_HashTimeH;
	private static long BookB_HashTimeT;
	private static long BookB_TreeTimeH;
	private static long BookB_TreeTimeT;

	public static void main(String[] args) { 
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter the name of the first book's file pathway. (.txt file): ");
		a = console.nextLine();
		System.out.print("Please enter the name of the second book's file pathway. (.txt file): ");
		b = console.nextLine();
		console.close();
		loadSet(BookA_Hash,a);
		loadSet(BookA_Tree,a);
		loadSet(BookB_Hash,b);
		loadSet(BookB_Tree,b);
		
		//Book A hash iterated with Book B hash and tree.
		BookA_HashTimeH = timeSet(BookA_Hash,BookB_Hash);
		BookA_HashTimeT = timeSet(BookA_Hash,BookB_Tree);
		
		//Book A tree itereated with Book B hash and tree.
		BookA_TreeTimeH = timeSet(BookA_Tree,BookB_Hash);
		BookA_TreeTimeT = timeSet(BookA_Tree,BookB_Tree);
		
		//Book B hash iterated with Book A hash and tree.
		BookB_HashTimeH = timeSet(BookB_Hash,BookA_Hash);
		BookB_HashTimeT = timeSet(BookB_Hash,BookA_Tree);
		
		//Book B Tree iterated with Book A hash and tree.
		BookB_TreeTimeH = timeSet(BookB_Tree,BookA_Hash);
		BookB_TreeTimeT = timeSet(BookB_Tree,BookA_Tree);
		
		//Book A output times.
		System.out.println();
		output(BookA_HashTimeH,"Hash", a, b, "Hash");
		output(BookA_HashTimeT,"Hash", a, b, "Tree");
		output(BookA_TreeTimeH,"Tree", a, b, "Hash");
		output(BookA_TreeTimeT,"Tree", a, b, "Tree");
		
		//Book B output times.
		System.out.println();
		output(BookB_HashTimeH,"Hash", b, a, "Hash");
		output(BookB_HashTimeT,"Hash", b, a, "Tree");
		output(BookB_TreeTimeH,"Tree", b, a, "Hash");
		output(BookB_TreeTimeT,"Tree", b, a, "Tree");
		//System.out.println(BookA_HashTimeH);

	}

	private static void output(long time, String type, String name, String name2, String type2) {
		System.out.printf("The time to search the words of %s (%s) is %d milliseconds when interating over %s (%s).\n",name,type,time,name2,type2);
		
	}

	private static long timeSet(Set<String> A, Set<String> B) {
		System.out.print("Starting clock... ");
		long startTime = System.currentTimeMillis();
		for(String word: A)
			B.contains(word);
			//System.out.println(B.contains(word)); //This line to check if iteration is working correctly.
			
		long endTime = System.currentTimeMillis();
		System.out.println("done.");
		return (endTime-startTime);
	}

	private static Set<String> loadSet(Set<String> set, String input) {
		try {
			Scanner fileScanner = new Scanner(new File(input));
			System.out.print("Loading text...");
			while(fileScanner.hasNext())
				set.add(fileScanner.next());
			System.out.println(" done.");
			fileScanner.close();
					
		} catch (FileNotFoundException e) {
			System.out.println("File not found! Check pathway...");
		}
		return set;
	}

}
