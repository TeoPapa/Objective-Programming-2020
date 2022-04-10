import java.util.ArrayList;

public class Ship {
	private int AvailableSlots;
	private ArrayList<Container> cargo;
	
	
	
	public Ship( int s) {
		AvailableSlots = s;
		cargo = new ArrayList<Container>();
	}
	
	
	
	public void addContainer(Container c) {
		if(AvailableSlots > 0) {
			cargo.add(c);
			AvailableSlots--;
		}
		else
			System.out.println("There are not available slots in the ship");
	}
	
	
	public double TotalCharge() {
		double tCharge = 0;
		
		for(int i = 0; i < cargo.size(); i++) { 
			tCharge += cargo.get(i).calcCharge();
		}
		
		return tCharge;
	}
}
