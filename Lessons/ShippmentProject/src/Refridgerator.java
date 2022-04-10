
public class Refridgerator extends Container{
	private int kw;
	
	public Refridgerator(String c, String d, int k) {
		super(c, d);
		kw = k;
	}

	@Override
	double calcCharge() {
		return (2000*kw);
	}
	
}
