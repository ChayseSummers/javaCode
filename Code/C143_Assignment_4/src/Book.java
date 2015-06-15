import java.util.*;
/**
 * Book object class, allows users to create book objects to be stored in book catalog.
 * @author Chayse Summers
 *
 */

public class Book {
	private String bookCode;
	private String lastName;
	private String firstName;
	private String title;
	private int yearOfPub;
	private double price;
	private Book next;
	
	/**
	 * Constructor class, requires ISBN code, authors name, title of book, year of publication and price of book.
	 */
	public Book(String code, String last, String first, String title, int date, double price, Book next){
		Scanner console = new Scanner(System.in);
		
		this.bookCode=validator(code,date, console);
		this.lastName = credentialsValidator(last, console);
		this.firstName = credentialsValidator(first, console);
		this.title = credentialsValidator(title, console);
		this.next = next;
		if(price > 0){
			this.price = price;
		}
		else{
			boolean done = false;
			while(done != true){
				System.out.println("The price for this book must be a positive non-zero number.");
				System.out.print("Please re-enter price of this book: ");
				price = console.nextDouble();
				if(price > 0){
					this.price = price;
				}
				else{
					done = false;
				}
			}
		}
	}

	/**
	 * Method takes input for authors name and title checking to make sure input is good.
	 * @param input use one of these (last name, first name, title of book)
	 * @param console
	 * @return the input if input is good, else reprompts user for correct input.
	 */
	private String credentialsValidator(String input, Scanner console) {
		if(input != null && input.charAt(0) > 64 && input.charAt(0) < 123){
			return input;
		}
		else{
			boolean ready = false;
			System.out.println("Error, credentials (first and last name, and title of book) can't begin with numbers and can't be empty.");
			while(ready != true){
				System.out.print("Please re-enter input: ");
				input = console.nextLine();
				if(input != null && input.charAt(0) > 64 && input.charAt(0) < 123){
					ready = true;
				}
				else{
					ready = false;
				}	
			}
			return input;
			
		}
		
	}

	/**
	 * Validator method takes in the ISBN code and date returning both if they are valid. 
	 * An ISBN (International Standard Book Number) identifies a unique publication. 
	 * An ISBN is ten digits. The first nine digits must be decimal digits (0...9). 
	 * The tenth digit can be either a decimal digit or the letter X. 
	 * Three single dashes may be between any of the characters. 
	 * (i.e., an ISBN number may either have no dashes or exactly three dashes). 
	 * Also, an ISBN must not begin or end with a dash, and sequential dashes are not allowed. 
	 * Date must be < 2016.
	 * @param code
	 * @param date
	 * @param console
	 * @return
	 */
	@SuppressWarnings("unused")
	public String validator(String code, int date, Scanner console) {
		boolean codeInput = false;
		boolean validInput = false;
		boolean checkInput = false;
		while(codeInput == false){
			if(code.replaceAll("-", "").length()!=10){
				while(code.replaceAll("-", "").length()!=10){
					System.out.println("\nError, the ISBN code for this book is invalid. Not enough or too many digits.");
					System.out.println("ISBN must be 10 digits and 3 dashes, ok to enter without dashes.");
					System.out.print("Please re-enter the ISBN code: ");
					code = console.nextLine();
				}
			}
			else if(code.startsWith("-")||code.endsWith("-")){
				System.out.println("\nError, invalid entry. ISBN cannot begin or end with a '-'.");
				System.out.print("Please re-enter the ISBN code: ");
				code = console.nextLine();
			}
			else if(validInput == false){
				int count = 0;
				for(int i = 0;i<code.length();i++){
					char a = code.charAt(i);
					if(a=='-'&& code.charAt(i+1)=='-'){
						System.out.println("\nError, invalid entry. ISBN cannot have sequencial dashes, ie. \"--\".");
						System.out.print("Please re-eter the ISBN code: ");
						code = console.nextLine();
					}
					else if(a=='-'){
						count++;
					}
					else if((int)a<48 && ((int)a!=45)||(int)a>57 && ((int)a!=88 && (int)a!=120)){
						System.out.println("\nInvalid ISBN. Must consist of numbers or an X representing the number ten. ");
						System.out.print("Please re-eter the ISBN code: ");
						code = console.nextLine();
					}
				}
				if(count >= 4||count<3){
					System.out.println("\nError, invalid entry. Incorrect number of dashes \"-\".");
					System.out.print("Please re-eter the ISBN code: ");
					code = console.nextLine();
				}
				else if(checkInput == false){
					String lastDigit = code.substring(code.length()-1, code.length());
					if(lastDigit.equalsIgnoreCase("X")){
						lastDigit = "10";
					}
					int checkSum = Integer.valueOf(lastDigit);
					int sum = 0;
					for(int i = 0;i<code.replaceAll("-", "").length()-1;i++){
						sum = sum + (Integer.valueOf(code.replaceAll("-", "").substring(i, i+1))*(i+1));
					}
					if(sum%11!=checkSum){
						System.out.println("\nError, invalid entry. Check sum doesn't add up.");
						System.out.print("Please re-eter the ISBN code: ");
						code = console.nextLine();
					}
					else{
						checkInput = true;
					}
				}
				else{
					validInput = true;
				}
			}
			else{
				codeInput = true;
			}
			while(date>2016){
				System.out.println("\nError, invalid date of publication. Must be before the year 2016");
				System.out.print("Please enter the correct date of publication: ");
				String x = console.next();
				int value = 0;
				boolean done = false;
				while(done == false){
					for(int i = 0;i<x.length();i++){
						char y = x.charAt(i);
						if((int)y<48||(int)y>57){
							System.out.print("Error, invalid entry. The date should be in format YYYY using numbers from 0-9: ");
							x = console.next();
						}
						else{
							done = true;
						}
					}
				}
				date = Integer.valueOf(x);
			}
			this.yearOfPub = date;
		}
		return code;
	}
	
	//Standard getters and setters.
	
	public boolean getData(String val){
		if(val.equalsIgnoreCase(bookCode)||val.equalsIgnoreCase(firstName)||val.equalsIgnoreCase(lastName)||val.equalsIgnoreCase(title)){
			return true;
		}
		return false;
		
	}
	public Book getNext() {
		return next;
	}
	public void setNext(Book next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Book [ISBN: "+this.bookCode+"\n"+"Title: " + this.title +"\n"+"Author: "+this.firstName+" "+this.lastName+"\n"+"Date of Publication: "+this.yearOfPub+"\n"+"Price: $"+this.price+ "]";
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public  String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearOfPub() {
		return yearOfPub;
	}

	public void setYearOfPub(int yearOfPub) {
		this.yearOfPub = yearOfPub;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
