import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Chapter10Problems {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList <String> names = new ArrayList<String>();
		Scanner datafile = new Scanner(new File("E:/CSC142_143/DataFiles/sometext.txt"));
		loadData(names, datafile);
		System.out.println(names);
		retainTokesn(names, "and", "end");
		System.out.println(names);
//		System.out.println(names.size()); // Starts with 100 for this example;
//		removeEvenLength(names);
//		System.out.println(names);
//		System.out.println(names.size()); // 35 after removing even lengths.
		
		Integer x = 3; //Integer objects. Boxing with Integer class wrapper.
		Integer i = 100;
		int k = i; //Unboxing. This is done through auto-boxing a part of Java since 6.0.
		
		ArrayList<Double> list = new ArrayList<Double>(); //How you box an array list.
		
		String s1 = "other string", s2 = "some string";
		if (s1.compareTo(s2) == 0){
			System.out.println("Strings are identical.");
		}
		else if(s1.compareTo(s2)<0)
			System.out.println("s1 is alphabetically before s2.");
		else
			System.out.println("s1 is alphabetically after s2.");
		
		
//		names.add("Darian");
//		names.add("Nick");
//		names.add("Regis");
//		names.add("Duy");
//		names.add("Murcury");
//		names.add(0, "Alex");
//		System.out.println(names);
//		names.remove("Darian");
//		System.out.println(names);
//		names.add(names.size(),"Patrick");
//		System.out.println(names.indexOf("Patrick"));
//		
//		names.add(names.size(),"Greg"); 
//		//can only add at names.size() or less, cannot add at names.size()+1.
//		
//		names.remove(names.size()-1);
//		//can only remove from < names.size().
//		
//		System.out.println(names.get(names.size()-1));
//		//can only get from < names.size() or specified index.
//		
//		names.set(0, "Lily");
//		names.set(names.size()-2, "Duy");
//		// set will override the object at specified index with new object. Cannot set at names.size().
//		
//		System.out.println(names.lastIndexOf("Duy"));
//		System.out.println(names);
//		
	}
	

	
	private static void retainTokesn(ArrayList<String> list, String s1, String s2){
		int i = 0;
		String test = list.get(i);
		while(i<list.size())
			if(s1.compareToIgnoreCase(list.get(i))<=0 && s2.compareToIgnoreCase(list.get(i))>=0){
				list.remove(i);
			}
			else{
				i++;
			}
	}
		

//	private static void retainTokesn(ArrayList<String> tokens, String begin,
//			String end) {
//		int i = 0;
//		while(i<tokens.size()){
//			if(!inRange(tokens.get(i), begin, end)){
//				tokens.remove(i);
//			}
//			else{
//				i++;
//			}
//		}
//		
//	}



	private static boolean inRange(String token, String begin, String end) {
		return (begin.compareToIgnoreCase(token)<=0 && end.compareToIgnoreCase(token)>=0);
	}



	private static void removeEvenLength(ArrayList<String> names) {
		int i = 0;
		while(i<names.size()){
			String n = names.get(i);
			if(n.length()%2==0){ //even length
				names.remove(i);
			}
			else{
				i++;
			}
		}
		
	}

	private static void loadData(ArrayList<String> names, Scanner datafile) {
		System.out.print("Loading data");
		while(datafile.hasNext()){
			names.add(datafile.next());
			System.out.print(".");
		}
		System.out.println("done");
		
	}

}
