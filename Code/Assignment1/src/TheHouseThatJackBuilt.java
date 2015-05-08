
public class TheHouseThatJackBuilt {

	/**
	 * Chayse Summers
	 * CSC142 - Gandham
	 * January 16th, 2015
	 * Assignment 1 - #3.)
	 */
	
	// This program will use static methods to reproduce the lyrics to a song in order.
	//By calling methods within methods that end up paired together in the song, I was able to 
	//eliminate some redundancies. However, with the song() method it was more efficient to place
	//several of the single use sentences together while calling the methods in the correct
	//order to reproduce the song with correct spacing and verses. I thought this was fun,
	//it helped me learn how to use methods to help make my programming more efficient.
	
	public static void Jack() {
		System.out.println("That lay in the house that Jack built.");
		System.out.println();// Adding this blank print line statement allowed me to reduce 
		//five lines of code in the song() method.

	}
	
	public static void song(){
		System.out.println("This is the house that Jack built.");
		System.out.println();
		
		System.out.println("This is the malt");
		Jack();

		System.out.println("This is the rat,");
		malt();
		
		System.out.println("This is the cat,");
		rat();
		
		System.out.println("This is the dog,");
		cat();
		
		System.out.println("This is the cow with the crumpled horn,");
		dog();
		
		System.out.println("This is the maiden all forlorn");
		cow();
	}

	public static void cow(){
		System.out.println("That milked the cow with the crumpled horn,");
		dog();
	}
	
	public static void dog(){
		System.out.println("That tossed the dog,");
		cat();
	}
	
	public static void cat() {
		System.out.println("That worried the cat,");
		rat();

	}
	
	public static void rat() {
		System.out.println("That killed the rat,");
		malt();
	}
	
	public static void malt() {
		System.out.println("That ate the malt");
		Jack();
	}
	
	public static void main(String[] args) {
		song();

	}

}
