import java.util.*;
public class mapProblems {

	public static void main(String[] args) {
		//First String is the key, second is the value. Values can be duplicate, keys cannot.
		Map<String, String> m1 = new HashMap<String, String>(); //Can switch between HashMap and TreeMap and code will still work.
		
		m1.put("Darian", "Engineering");
		m1.put("Chayse", "Computer Science");
		m1.put("Max", "Computer Science");
		m1.put("Tommy","Electrical Engineering");
		
		System.out.println(m1); //Tree stores alphabetically. Maps use key/value pairs.
		
		System.out.println(m1.get("Tommy")); //returns value using key. If key doesn't exist returns null.
		
		m1.put("Tommy", "Physics"); //Adding a new value using the same key will replace the previous value.
		System.out.println(m1);
		
		System.out.println(m1.keySet()); //Returns keys for collection.
		System.out.println(m1.values()); //Returns values for collection.
		
		System.out.println();
	}

}
