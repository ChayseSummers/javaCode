import java.util.*;
public class ArrayListClient {

	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		CSC143ArrayList <Integer> ourList = new CSC143ArrayList<Integer>();
		CSC143ArrayList <String> ourStrList = new CSC143ArrayList<String>();
		ourStrList.add("Chayse");
		ourStrList.add("Ravi");
		ourStrList.add("Jaz");
		ourStrList.add("Renaldo");
		System.out.println(ourStrList);
		System.out.println(ourStrList.remove(0));
		System.out.println(ourStrList);
		for(int i = 0; i<=14; i++){
			ourList.add(i);
		}
		System.out.println(ourList);
		System.out.println(ourList.get(14));
	}

}
