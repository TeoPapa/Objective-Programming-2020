
public class ShippmentMain {

	public static void main(String[] args) {
		Ship sh = new Ship(450);

		sh.addContainer(new Bulk("1532CD", "Zimbawe", 8));
		sh.addContainer(new Bulk("1552CD", "New Zeland", 7));
		sh.addContainer(new Refridgerator("1512CD", "Greece", 6));
		sh.addContainer(new Refridgerator("1582CD", "Japan", 5));
		
		new ShippmentChargeGUI(sh);
	}

}
