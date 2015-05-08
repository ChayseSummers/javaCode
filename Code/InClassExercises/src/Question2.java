//ICE3
public class Question2 {

	/** Chayse Summers
	 * CSC142 - Gandham
	 * January 14th, 2015
	 * In Class Exercise 3, #2
	 */
	
	// Each static method is used to make up the different
	//parts of the pattern, when called in a specific order
	//the pattern can be replicated.
	
	public static void five() {
		System.out.println("*****");
		System.out.println("*****");

	}
	
	public static void two() {
		System.out.println(" * * ");

	}
	
	public static void one() {
		System.out.println("  *  ");

	}
	
	public static void blank() {
		System.out.println("");

	}
	
	public static void main(String[] args) {
		five();
		two();
		one();
		two();
		blank();
		five();
		two();
		one();
		two();
		five();
		blank();
		one();
		one();
		one();
		five();
		two();
		one();
		two();

	}

}
