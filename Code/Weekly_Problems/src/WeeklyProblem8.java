import java.io.*;
import java.util.*;
/**
 * This program can take in any number of books (in plain .txt format) and give back a count of the lines,
 * words and characters in each book. 
 * 
 * @author Chayse Summers
 *
 */
public class WeeklyProblem8 {
	
	//Class constants to capture the lists of counts for each type of count.
	private static ArrayList<Integer> lineCount = new ArrayList<Integer>();
	private static ArrayList<Integer> wordCount = new ArrayList<Integer>();
	private static ArrayList<Integer> characterCount = new ArrayList<Integer>();
	private static ArrayList<Integer> characterCountNoSpace = new ArrayList<Integer>();
	private static int x = 1;
	
//		Files used for testing.
//		C:/Users/Womenin/Desktop/TheSignoftheFour.txt
//		C:/Users/Womenin/Desktop/TheReturnOfSherlockHolms.txt	

	/**
	 * Main method in which file pathway is gathered
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		ArrayList <File> books = new ArrayList<File>();
		System.out.println("Welcome, this program can return the counts for lines, words and characters of a plain text document.");
		while(x!=0){
			System.out.print("Please enter the file pathway: ");
			books.add(new File(console.next()));
			System.out.print("Would you like to add another file? Enter 1 to add another file, 0 to continue: ");
			x = console.nextInt();
		}
		console.close();
		

		
		lineCount(books);
		wordCount(books);
		charCount(books);
		charCountNoSpace(books);
		output(lineCount);
		output(wordCount);
		output(characterCount);
		output(characterCountNoSpace);

	}

	/**
	 * Output method used to output data from a processed file, depending on which type of data it is, the output
	 * will change accordingly.
	 * 
	 * @param countList ArrayList containing the counts of either the number of lines, the number of words, or the
	 * number of characters.
	 */
	private static void output(ArrayList<Integer> countList) {
		for(int count: countList){
			if(countList == lineCount){
				System.out.printf("Line count for book #%d: %d\n",countList.indexOf(count)+1, count);
			}
			else if(countList == wordCount){
				System.out.printf("Word count for book #%d: %d\n",countList.indexOf(count)+1, count);
			}
			else if(countList == characterCount){
				System.out.printf("Character count for book #%d: %d (with spaces).\n",countList.indexOf(count)+1, count);
			}
			else if(countList == characterCountNoSpace){
				System.out.printf("Character count for book #%d: %d (without spaces).\n",countList.indexOf(count)+1, count);
			}
			else{
				System.out.println("Invalid count list...");
			}
		}
	}

	/**
	 * charCount method allows for the sum of all characters, including spaces, in a text file. Method can process
	 * multiple files through the use of an ArrayList.
	 * 
	 * @param books ArrayList of the files to be processed.
	 * @throws FileNotFoundException
	 */
	private static void charCount(ArrayList<File> books) throws FileNotFoundException {
		
		for(File book:books){
			Scanner x = new Scanner(book);
			ArrayList<String> tempBook = new ArrayList<String>();
			ArrayList<Character> tempCh = new ArrayList<Character>();
			while(x.hasNext()){
				tempBook.add(x.nextLine()); //Change this line to tempBook.add(x.next()); to calculate without spaces.
			}
			for(String word: tempBook){
				String tempWord = word;
				char[] tempArray = tempWord.toCharArray();
				for(char ch:tempArray){
					tempCh.add(ch);
				}
			}
			characterCount.add(tempCh.size());
			x.close();
		}
		
	}
	
	/**
	 * This method is the same as the one above (charCount) but dones't include spaces. I added this method
	 * because I wanted to be able to output the character count both with and without spaces.
	 * @param books
	 * @throws FileNotFoundException
	 */
private static void charCountNoSpace(ArrayList<File> books) throws FileNotFoundException {
		
		for(File book:books){
			Scanner x = new Scanner(book);
			ArrayList<String> tempBook = new ArrayList<String>();
			ArrayList<Character> tempCh = new ArrayList<Character>();
			while(x.hasNext()){
				tempBook.add(x.next()); //Change this line to tempBook.add(x.nextLine()); to calculate with spaces.
			}
			for(String word: tempBook){
				String tempWord = word;
				char[] tempArray = tempWord.toCharArray();
				for(char ch:tempArray){
					tempCh.add(ch);
				}
			}
			characterCountNoSpace.add(tempCh.size());
			x.close();
		}
		
	}

	/**
	 * wordCount method allows for the sum of all words in text files. Method can process multiple files through 
	 * the use of an ArrayList.
	 * 
	 * @param books ArrayList of files to be processed.
	 * @throws FileNotFoundException
	 */
	private static void wordCount(ArrayList<File> books) throws FileNotFoundException {
		
		for(File book:books){
			Scanner x = new Scanner(book);
			ArrayList<String> tempBook = new ArrayList<String>();
			while(x.hasNext()){
				tempBook.add(x.next());
			}
			x.close();
			wordCount.add(tempBook.size());
		}
		
	}

	/**
	 * lineCount method allows for the sum of all the lines in a text file. Method can process multiple files through
	 * the use of an ArrayList.
	 * 
	 * @param books ArrayList of files to be processed.
	 * @throws FileNotFoundException
	 */
	private static void lineCount(ArrayList<File> books) throws FileNotFoundException {
		for(File book:books){
			Scanner x = new Scanner(book);
			ArrayList<String> tempBook = new ArrayList<String>();
			while(x.hasNextLine()){
				tempBook.add(x.nextLine());
			}
			x.close();
			lineCount.add(tempBook.size());
			
		}
	}


}
