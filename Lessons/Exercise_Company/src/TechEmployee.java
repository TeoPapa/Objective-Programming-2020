
public class TechEmployee extends Employee {
	
	private double bonus;
	
	public TechEmployee( String n, double inc, double b) {
		
		super(n, inc);
		bonus = b;
	}
	
	
	public void incomePrint() {
		
		System.out.print("The monthly income of " + name + " is: " + income*0.7 + bonus );
	}
}
