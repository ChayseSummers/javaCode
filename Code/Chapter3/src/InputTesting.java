import java.util.*; //This means import everything (*) in the java utility.
public class InputTesting {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);// Opens the scanner for user input.
		System.out.print("Enter your name: ");
		String name = console.nextLine();// nextLine(); is needed to read past spaces and other 
		//characters.
		
		System.out.println("Name is " + name);
		console.close();

	}

}
