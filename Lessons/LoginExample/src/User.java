
public class User {
	protected String name;
	protected String uname;
	protected String pass;
	
	public User(String n, String u, String p) {
		name = n;
		uname = u;
		pass = p;
	}
	
	public boolean equals(Object o) {
		User u = (User) o;
		
		if(uname.equals(u.uname) && pass.equals(u.pass)) return true;
		
		return false;
	}
}
