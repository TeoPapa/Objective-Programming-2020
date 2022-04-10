
abstract class Container {
	protected String code;
	protected String destination;
	
	public Container(String c, String d) {
		code = c;
		destination = d;
	}
	
	abstract double calcCharge();
}
