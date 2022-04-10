import java.util.ArrayList;

public class BookList {
	
	private ArrayList<Book> Books;
	
	public BookList() {
		
		Books = new ArrayList<Book>();
	}
	
	public int calcTotalCost() {
		int tCost = 0;
		
		for(int i = 0; i < Books.size(); i++) {
			tCost += Books.get(i).calcCost();
		}
		
		return tCost;
	}
	
	public void printList() {
		for(int i = 0; i < Books.size(); i++) {
			Books.get(i).printBook();
		}
	}
	
	
	public void addBook(Book b) {
		Books.add(b);
	}
}
