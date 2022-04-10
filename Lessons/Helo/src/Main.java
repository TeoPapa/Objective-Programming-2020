import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		HashMap<String, BookList> bookstore = new HashMap<String, BookList>();

		BookList booklist1 = new BookList();
		booklist1.addBook(new Book("Book Title-1", 15));
		booklist1.addBook(new Book("Book Title-2", 20));
		booklist1.addBook(new Book("Book Title-3", 18));
		bookstore.put("A A", booklist1);
		
		BookList booklist2 = new BookList();
		booklist2.addBook(new Book("Book Title-4", 25));
		booklist2.addBook(new Book("Book Title-5", 16));
		booklist2.addBook(new Book("Book Title-6", 21));
		bookstore.put("B B", booklist2);
		
		for(String name : bookstore.keySet()) {
			BookList bList = bookstore.get(name);
			
			System.out.println(name + ", owns: ");
			bList.printList();
			System.out.println("\tTotal cost: " + bList.calcTotalCost());
		}
	}

}
