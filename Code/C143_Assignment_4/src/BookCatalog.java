/**
 * Book Catalog class creates a linked list of books for the catalog. Allows user to add/delete/view books in catalog.
 * @author Chayse Summers
 *
 */
public class BookCatalog {
	private Book head;
	private int count;
	
	public String toString(){
		if(head!=null){
			Book cursor = head;
			while(cursor!=null){
				System.out.println("\n"+cursor.toString());
				cursor = cursor.getNext();
			}
		}
		else
			System.out.println("The catalog is empty.");
		return null;
	}
	
	public Book[] output(){ //Method for outputting catalog to text file.
		Book cursor = head;
		Book[] y = new Book[count-1];
		int i = 0;
		while(cursor!=null){
			Book out = cursor;
			cursor = cursor.getNext();
			y[i] = out;
			i++;
			
		}
		return y;
	}
	
	//Add method allows user to add a new book to head of catalog.
	public void add(String isbn, String lastName, String firstName, String title, int date, double price){
		head = new Book(isbn, lastName, firstName, title, date, price, head);
		count++;
	}
	//Add at tail method allows user to do just that, add a book to tail of linkedlist.
	public void addAtTail(String isbn, String lastName, String firstName, String title, int date, double price){
		Book newNode = new Book(isbn, lastName, firstName, title, date, price, null);
		if(head==null)
			head = newNode;
		else{
			Book cursor = head;
			while(cursor.getNext()!=null)
				cursor = cursor.getNext();
			cursor.setNext(newNode);
		}
	}
	
	//Returns data of book if available, if not tells user book not found.
	public String contains(String val){
		Book cursor = head;
		while(cursor!=null){
			if(cursor.getData(val)== true)
				return cursor.toString();
			cursor = cursor.getNext();
		}
		return ("Book not found in catalog.");
	}
	
	//gives back user info of size of catalog.
	public int size(){
		int count = 0;
		for(Book cursor = head; cursor != null; cursor = cursor.getNext())
			++count;
		return count;
	}
	
	//method to remove books from catalog.
	public void remove(String id){
		Book cursor = head;
		Book reference = null;
		while(cursor.getData(id)!=true){
			reference = cursor;
			cursor = cursor.getNext();
		}
		cursor = cursor.getNext();
		reference.setNext(cursor);
		//cursor.setNext(null);
		System.out.printf("Book has been removed from the catalog.");
	}


}
