/**
 * @author Chayse Summers
 * CSC143 - Gandham
 * @version 1.1
 * @since 4/8/15
 */
import java.util.*;
public class WP2 {

	/**
	 * This is the main method where the program is initialized.
	 * Calls upon all other methods.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String query = intro(console);
		int processed = weightCalc(query);
		int requiredDigit = lastDigit(processed);
		boolean test = validateDigit(requiredDigit, query);
		output(test,query);
		console.close();
	}

	/**
	 * Output method to display for the user whether or not the EAN-13 number is valid.
	 * @param test Boolean used to determine which output to select.
	 * @param EAN13 Used in output to confirm with user the number entered and processed.
	 */
	private static void output(boolean test,String EAN13) {
		if(test == true){
			System.out.printf("The EAN-13 number %s is valid.",EAN13);
		}
		else
			System.out.printf("Invalid EAN-13 number. Please check to confirm the number %s is correct...",EAN13);
	}

	/**
	 * Method to validate whether the last digit of the entered EAN-13 number is equal to the weighted sum of the 
	 * first twelve digits of the number minus the next highest multiple of ten.
	 * @param RequiredDigit is digit required to be the 13th digit of the EAN-13 number in order to be a valid EAN-13 number.
	 * @param Query is the actual user entered number. Used to check what the last digit is against the required number.
	 * @return Will return true or false depending if the last digit of the users number is equal to the requiredDigit.
	 */
	private static boolean validateDigit(int requiredDigit, String query) {
		if(Character.getNumericValue(query.charAt(query.length()-1))==requiredDigit){
			return true;
		}
		return false;
	}

	/**
	 * Method to determine what a valid last digit should be for the weighted sum of the first 12 digits.
	 * @param processed Weighted total of the first 12 numbers of users EAN-13 number.
	 * @return Integer number that will be checked with the actual 13th number of the user entered EAN-13.
	 */
	private static int lastDigit(int processed) {
		int lastDigitTest = 0;
		if(processed%10==0){
			lastDigitTest = processed + 10;
		}
		else{
			lastDigitTest = processed;
			while(lastDigitTest%10!=0){
				lastDigitTest = lastDigitTest + 1;
			}
		}
		int lastDigit = lastDigitTest - processed;
		return lastDigit;
	}

	/**
	 * Method to calculate the weighted sum of the first 12 digits of the users EAN-13 number.
	 * @param query String based entry from user of EAN-13 number.
	 * @return Integer of weighted sum of first 12 digits of users EAN-13 number.
	 * @throws StringIndexOutOfBoundsException Is thrown if EAN-13 is not the correct amount of digits.
	 */
	private static int weightCalc(String query) {
		int total = 0;
		try{
			for(int i = 0; i<12;i++){
				int current = Character.getNumericValue(query.charAt(i));
				switch(i%2){
				case 0:
					total = total + current;
					break;
				default:
					total = total + (current * 3);
				}
			}
		}
		catch(StringIndexOutOfBoundsException ob){
			System.out.println("Error! Not enough digits to be an EAN-13 number...");
		}
		return total;
	}

	/**
	 * Method to collect EAN-13 number from user
	 * @param console
	 * @return String based EAN-13 number.
	 */
	private static String intro(Scanner console) {
		System.out.println("This program checks EAN-13 numbers.");
		System.out.print("Please enter the EAN-13 number to check for validity: ");
		String entry = console.next();
		return entry;
	}

}
