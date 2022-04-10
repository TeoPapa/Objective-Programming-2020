
public class Book {
	
	private String name;
	private int price;
	
	public Book(String n, int p) {
		name = n;
		price = p;
	}
	
	
	public int calcCost() {
		return price;
	}

	public void printBook() {
		System.out.println("Name: " + name + " | Price: " + price);
	}
}
