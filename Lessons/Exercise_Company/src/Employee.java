
public class Employee {
	protected String name;
	protected double income;
	
	
	
	public Employee(String n, double inc) {
		name = n;
		income = inc;
	}


	public void incomePrint() {
		System.out.print("The monthly income of " + name + " is: " + income*0.8 );
	}
}
