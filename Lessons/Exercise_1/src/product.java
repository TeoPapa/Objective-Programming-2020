import java.util.Scanner;

public class product {
	private int price;
	private double score;
	private String name;
	
	
	
	public product() {
		name = "";
		price = 1;
		score = 0;
	}
	
	
	public product( String n, int p, double s) {
		name = n;
		price = p;
		score = s;
	}
	
	
	public void setName(String n) {name = n;}
	
	public void setPrice(int p) {price = p;}
	
	public void setScore(double s) {score = s;}
	
	
	public String getName() {return name;}
	
	public int getPrice() {return price;}
	
	public double getScore() {return score;}
	
	
	
	public double calcQuality() {return score/price; }
	
	
	public void printProduct() {
		System.out.println("Product: " + name + ", has quality: " + calcQuality());
	}
	
	
	public void readFromKeyboard(Scanner keyboard) {
		System.out.print("Enter name: ");
		name = keyboard.nextLine();
		
		System.out.print("Enter price: ");
		price = keyboard.nextInt();
		
		System.out.print("Enter score: ");
		score = keyboard.nextDouble();
	}
	
	
	public boolean hasBetterQuality( product bestProduct) {
		return calcQuality() > bestProduct.calcQuality();
	}
	
}
