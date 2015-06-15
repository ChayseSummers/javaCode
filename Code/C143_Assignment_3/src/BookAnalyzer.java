import java.io.*;
import java.util.*;
public class BookAnalyzer {
	private Set<String> posWords;
	private Set<String> negWords;
	@SuppressWarnings("rawtypes")
	private ArrayList<List> bookWords;
	
	/**
	 * Constructor method, has ability to create a default analyzer object if client class is running in test mode.
	 * 
	 * @param positive
	 * @param negative
	 * @param book
	 * @throws FileNotFoundException
	 */
	public BookAnalyzer(String positive, String negative,
			File book) throws FileNotFoundException {
		if(positive.equalsIgnoreCase("default")){
			String[] posList = {"good", "nice", "love", "excellent", "great", "awesome", "wonderful", "fantastic", "fabulous", "like"};
			String [] negList = {"bad", "awful", "hate", "terrible", "miserable", "sad", "dislike", "atrocious", "depressed", "cry"};
			this.posWords = defaultWordSet(posList);
			this.negWords = defaultWordSet(negList);
			this.bookWords = process(book);
		}
		else{
		this.posWords = wordsSet(positive);
		this.negWords = wordsSet(negative);
		this.bookWords = process(book);
		}
	}

	/**
	 * Method used to create the default word sets when running in test mode.
	 * @param list
	 * @return
	 */
	private Set<String> defaultWordSet(String[] list) {
		Set<String> set = new HashSet<String>();
		for(String word:list){
			set.add(word);
		}
		return set;
	}

	/**
	 * Process method which begins analysis by check each word in the book and then separating it into positive, negative
	 * then creates maps for the positive and negative words to go along with the counts of how many times each word occurs
	 * throughout the book. 
	 * @param book
	 * @return
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	private ArrayList<List> process(File book) throws FileNotFoundException {
		List<String> posList = new ArrayList<String>();
		List<String> negList = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		ArrayList<List> processed = new ArrayList<List>();
		
		Scanner fileScanner = new Scanner(book);
		while(fileScanner.hasNext()){
			String x = fileScanner.next();
			if(posWords.contains(x)){
				posList.add(x);
				words.add(x);
			}
			else if(negWords.contains(x)){
				negList.add(x);
				words.add(x);
			}
			else{
				words.add(x);
			}
		}
		fileScanner.close();
		Map<String, Integer> posMap = sentimentCount(posList, words);
		Map<String, Integer> negMap = sentimentCount(negList, words);
		
		String posMax = maxFinder(posMap);
		String negMax = maxFinder(negMap);
		List<String> maxes = new ArrayList<String>();
		maxes.add(posMax);
		maxes.add(negMax);
		
		
		processed.add(posList);
		processed.add(negList);
		processed.add(words);
		processed.add(maxes);
		
		return processed;
	}

	/**
	 * Finishes process of analysis by determining the type of the book and calling upon data methods while printing output.
	 */
	@SuppressWarnings("unchecked")
	public void output(){
		
		List<String> posList = bookWords.get(0);
		List<String> negList = bookWords.get(1);
		List<String> words = bookWords.get(2);
		List<?> maxes = bookWords.get(3);
		String comPos = (String)maxes.get(0);
		String comNeg = (String)maxes.get(1);
		String type;
		if(negList.size()>posList.size()){
			type = "Tragedy";
		}
		else if(posList.size()>negList.size()){
			type = "Comedy";
		}
		else{
			type = "Bore";
		}
		
		
		
		System.out.printf("This book is a %s\n",type);
		System.out.printf("\tThe number of negative words: %d\n",negList.size());
		System.out.printf("\tThe number of positive words: %d\n",posList.size());
		System.out.printf("\tThe number of words total: %d\n",words.size());
		System.out.printf("\tThe percentage of positive words: %.2f percent\n", percent(posList, words)); //(((double)posList.size()/words.size())*100));
		System.out.printf("\tThe percentage of negative words: %.2f percent\n", percent(negList, words)); //(((double)negList.size()/words.size())*100));
		System.out.printf("\tThe most common positive word: %s\n",comPos);//posMap.get(posMax));
		System.out.printf("\tThe most common negative word: %s\n",comNeg);//negMap.get(negMax));
		
	}
	
	/**
	 * Returns percentage of the positive or negative words in book.
	 * @param list
	 * @param words
	 * @return
	 */
	private double percent(List<String> list, List<String> words) {
		double x = (((double)list.size()/words.size())*100);
		return x;
	}

	/**
	 * Returns the max used positive or negative word in book, dependent upon which map is sent as parameter.
	 * 
	 * @param map
	 * @return
	 */
	private String maxFinder(Map<String, Integer> map) {
		int x = 0;
		String max = null;
		for(String key:map.keySet()){
			if(map.get(key)>x){
				x = map.get(key);
				max = key;
			}
		}
		return max;
	}

	 /**
	  * Method to count how many times each positive or negative word is being used in book.
	  * @param sentiments
	  * @param words
	  * @return
	  */
	private Map<String, Integer> sentimentCount(List<String> sentiments, List<String> words) {
		int count = 0;
		Map<String,Integer> sMap = new HashMap<String,Integer>();
		for(String sentiment:sentiments){
			for(String word:words){
				if(sentiment==word){
					count++;
				}
			}
			sMap.put(sentiment, count);
		}
		return sMap;
	}

	/**
	 * Creates a wordlist of words from the book to be used in process.
	 * @param books
	 * @return
	 */
	private ArrayList<String> wordsList(ArrayList<File> books) {
		ArrayList<String> words = new ArrayList<String>();
		for(File book:books){
			try{
			Scanner fileScanner = new Scanner(book);
			while(fileScanner.hasNext()){
				words.add(fileScanner.next());
			}
			fileScanner.close();
		}catch(FileNotFoundException e){
			System.out.print("File not found please try again.");
			}
		}
		
		return words;
		
		
	}

	/**
	 * Creates a word set for the positive or negative word sets.
	 * @param positive
	 * @return
	 * @throws FileNotFoundException
	 */
	private Set<String> wordsSet(String positive) throws FileNotFoundException {
		Set<String> set = new HashSet<String>();
		Scanner fileScanner = new Scanner(new File(positive));
		while(fileScanner.hasNext()){
			set.add(fileScanner.next());
		}
		fileScanner.close();
		
		return set;
		
	}
}
