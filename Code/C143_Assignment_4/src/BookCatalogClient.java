import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Chayse Summers
 * @class CSC143 - Spring 15' - Gandham
 * @date June 14th, 2015
 * @assignment #4 Book Catalog
 * 
 * This program is an interactive book catalog. It takes in a catalog of books (text file) containing an ISBN number,
 * the authors name, a title, date of publication and price of the book. Users can view specific titles, or the entire catalog.
 * A user can add and remove books as well as save the work done within the program back to the catalog.
 * User can also view how big catalog has become.
 *
 */
public class BookCatalogClient {
	public static BookCatalog client;
	public static Scanner file;
	public static Scanner console;
	public static OutputStream fileOut;

	public static void main(String[] args) throws FileNotFoundException {
		intro();
		menu();
		//Book a = new Book("0-201-88337-63","Barry","Manalow","A Year Without Sun", 2017,22.90);
		
	}

	/**
	 * Menu method allows the user to traverse the catalog, giving the ability to manipulate the catalog.
	 * Handles bad input by prompting the user and redirecting back to menu.
	 */
	private static void menu() {
		console = new Scanner(System.in);
		System.out.print("\n\nMenu Selection:\n");
		System.out.print("\t 1.) Add book to the catalog.\n");
		System.out.print("\t 2.) Search for a book in the catalog.\n");
		System.out.print("\t 3.) Remove a book from the catalog.\n");
		System.out.print("\t 4.) Browse entire catalog.\n");
		System.out.print("\t 5.) View size of catalog.\n");
		System.out.print("\t 6.) Quit catalog program.\n");
		System.out.print("Please enter selection: ");
		String selection = console.next();
		
		try{
		if(Integer.valueOf(selection) == 1){
			System.out.print("Please enter the ISBN number: ");// order the ISBN number for the book, the authors last name then first name, title of book, date of publication, price: ");
			String [] book = new String[6];
			book[0]=console.next();
			System.out.print("Please enter the authors last name: ");
			book[1]=console.next();
			System.out.print("Please enter the aurthors first name: ");
			book[2]=console.next();
			console.nextLine();
			System.out.print("Please enter the title of the book: ");
			String title = console.nextLine();
			book[3]=title;
			System.out.print("Please enter the date of publication: ");
			book[4]=console.next();
			System.out.print("Please enter the price of this book: ");
			book[5]=console.next();
			//0-387-95206-3	Misra	Pady	A Discipline of Multiprogramming	2001	45.50
			client.add(book[0],book[1],book[2],book[3],Integer.valueOf(book[4]),Double.valueOf(book[5]));
			menu();
		}
		else if(Integer.valueOf(selection) == 2){
			System.out.print("Please enter either the ISBN number, the authors first or last name, or the title of the book to search the catalog: ");
			System.out.println(client.contains(console.next()));
			menu();
		}
		else if(Integer.valueOf(selection) == 3){
			System.out.print("Please enter either the ISBN number, the authors first or last name, or the title of the book to delete from the catalog: ");
			client.remove(console.next());
			menu();
		}
		else if(Integer.valueOf(selection) == 4){
			client.toString();
			menu();
		}
		else if(Integer.valueOf(selection) == 5){
			System.out.println("This catalog contains "+client.size()+" books.");
			menu();
		}
		else if(Integer.valueOf(selection) == 6){ //Selection to save catalog. Prints updated data back to catalog if yes.
			System.out.print("Thank you, would you like to save? ");
			if(console.next().equalsIgnoreCase("y")){
				try {
					PrintStream out = new PrintStream(new File("books.txt"));
					for(Book book: client.output()){
						out.println(book.getBookCode()+"\t"+book.getLastName()+"\t"+book.getFirstName()+"\t"+book.getTitle()+"\t"+book.getYearOfPub()+"\t"+book.getPrice());
					}
					out.close();
		} catch (FileNotFoundException e) {
					System.out.println("Error, unable to save. File not found.");
				}
				System.exit(0);
			}
			else{
				System.out.println("Thank you.");
				System.exit(0);
			}
		}
		else{
			System.out.println("Sorry, selection not valid. Please try again...");
			menu();
		}
		}catch(NumberFormatException e){
			System.out.println("Invalid input, please try again...");
			menu();
		}
		
	}

	/**
	 * Opening intro method, welcomes user and sets up catalog from text file. If no file is found, a blank one will be created. 
	 * @throws FileNotFoundException
	 */
	public static void intro() throws FileNotFoundException {
		System.out.println("Hello and welcome to the CSC143 book catalog. Created by Chayse Summers.");
		System.out.println("This catalog allows you to store and access data for books including the price of the book.");
		System.out.println("Please wait while the database is created...");
		try {
			client = new BookCatalog();
			file = new Scanner(new File("books.txt"));
			while(file.hasNext()==true){
				System.out.print(".");
				String book = file.nextLine();
				String[] bookData = book.split("\t");
				client.add(bookData[0],bookData[1],bookData[2],bookData[3],Integer.valueOf(bookData[4]),Double.valueOf(bookData[5]));
			}
			System.out.println(" Done!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found, default catalog created.");
		}
		
	}

}
