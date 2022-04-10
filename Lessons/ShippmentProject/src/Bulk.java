
public class Bulk extends Container{
	private int kilos;
	
	
	public Bulk(String c, String d, int k) {
		super(c, d);
		kilos = k;
	}
	
	@Override
	double calcCharge() {
		
		return (10*kilos);
	}
	
}
