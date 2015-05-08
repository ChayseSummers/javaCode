/*Chayse Summers
 * CSC142 - Gandham
 * February 13th, 2014
 * In Class Exercise 12
 * 
 *  This was a challenging assignment, once I managed to figure out some tools to use by referring
 *  back to the text book it became more clear as to how to make the program work correctly.
 *  Now I can have it skip any number of spaces input by the user into this program and return a count
 *  of the actual words, regardless of where the spaces are in the phrase. It was giving me so much
 *  trouble originally as it would count a space placed anywhere in the phrase if it had another space
 *  next to it, or if the space came at the front of the string. I worked out eventually that it wasn't 
 *  actually identifying the space as " " or as a char ' ' but instead as "". Once I discovered this
 *  using println statements throughout the loop, it became so much more clear how to identify
 *  the spaces I wanted to skip. Now this program looks nice and tidy, just how we like it.
 */ 


import java.util.*;
public class ICE12 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter word(s) to return a count of the number of words: ");
		String line = console.nextLine();// Collecting the phrase or "String"
		console.close();
		int num = wordCount(line);
		
		System.out.printf("The number of words is in the phrase: \"%s\" equals to %d.\n",line,num);
		System.out.println(wordCount("hellow there"));
		String[] face = line.split("\\s+");
		int length = line.length();
		System.out.printf("The number of words in the phrase is: %d\n",length);
		
	}

	public static int wordCount(String phrase) {
		String[] fresh = phrase.split(" ");// Creating a split list of the string.
		String space = "";// Creating argument of how to split the list.
		int counter = 0;
		for(int i = 0; i < fresh.length; i++){// Loop that runs the length of the list.
			if (fresh[i].matches(space) != true){// Checking for spaces in list.
					counter = counter + 1;
			}
		}
		return counter;
	}
	
	// Using a \\s+ also discounts spaces, and works better than " " because it wouldn't need 
	//the for loop.

}
