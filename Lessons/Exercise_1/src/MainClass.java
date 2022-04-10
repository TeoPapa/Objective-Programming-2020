import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		product bestProduct = new product();
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			product currentProduct = new product();
			
			currentProduct.readFromKeyboard(keyboard);
			if(currentProduct.hasBetterQuality(bestProduct)) {
				bestProduct = currentProduct;
			}
			
			System.out.print("Do you want to continue (0: Exit)");
			
			int answer = keyboard.nextInt();
			
			if(answer == 0) break;
		}
		
		
		
		System.out.println("The best product is: ");
		bestProduct.printProduct();
		
		keyboard.close();

	}

}
