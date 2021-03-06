import java.util.*;
import java.io.*;
public class Chapter11Problems {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File("MolbyDick"));
		
		
		Set <String> tSet = new  TreeSet<String>();
		long startTime = System.currentTimeMillis();
		loadWords(fileScanner, tSet);
		long endTime = System.currentTimeMillis();
		System.out.println(tSet.size());
		System.out.println("Time taken to load words to Tree set: "+(endTime-startTime));
		
		fileScanner.close();
		fileScanner = new Scanner(new File("MolbyDick"));
		
		Set <String> hSet = new  HashSet<String>();
		startTime = System.currentTimeMillis();
		loadWords(fileScanner, hSet);
		endTime = System.currentTimeMillis();
		System.out.println(hSet.size());
		System.out.println("Time taken to load words to Hash set: "+(endTime-startTime));
		
		
/*		List<String> aList = new ArrayList<String>();
		List<String> lnkdList = new LinkedList<String>();
		
		long startTime = System.currentTimeMillis();
		loadWords(fileScanner, aList);
		long endTime = System.currentTimeMillis();
		
		//fileScanner.reset(); doesn't work with reseting scanner, need to close and reopen.
		fileScanner.close();
		fileScanner = new Scanner(new File("MolbyDick"));
		
		System.out.println("ArrayList size: "+aList.size());
		System.out.println("Time taken to load words to Alist: "+(endTime-startTime));
		
		startTime = System.currentTimeMillis();
		loadWords(fileScanner, lnkdList);
		endTime = System.currentTimeMillis();
		
		fileScanner.close();
		
		System.out.println("LinkedList size: "+lnkdList.size());
		System.out.println("Time taken to load words to Lnklist: "+(endTime-startTime));
		//System.currentTimeMillis(); //gathers time.
		
		startTime = System.currentTimeMillis();
		removeWords(aList);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to remove words to Alist: "+(endTime-startTime));

		startTime = System.currentTimeMillis();
		removeWords(lnkdList);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to remove words to Linkedlist: "+(endTime-startTime));*/
	}

	public static void removeWords(List<String> list) {
		System.out.print("removing words... ");
		while(list.size()>0){
			list.remove(0);
		}
		System.out.println("done.");
		
	}
	
	public static void loadWords(Scanner input, Set<String> list){
		System.out.print("loading words... ");
		while(input.hasNext()){
			list.add(input.next()); //By having it add the next word to the start of the list, we are able to show
			//that the linked list is faster because it doesn't have to shuffle the contents to add to the front.
		}
		System.out.println("done.");
	}

	public static void loadWords(Scanner input, List<String> list){
		System.out.print("loading words... ");
		while(input.hasNext()){
			list.add(0,input.next()); //By having it add the next word to the start of the list, we are able to show
			//that the linked list is faster because it doesn't have to shuffle the contents to add to the front.
		}
		System.out.println("done.");
	}
}
