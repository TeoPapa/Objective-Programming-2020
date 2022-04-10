import java.io.*;
import java.util.ArrayList;

public class Group implements Serializable{
	
	protected String Name;
	protected String Description;
	protected ArrayList<User> Members;
	
	
	public Group(String n, String d) {
		Name = n;
		Description = d;
		Members = new ArrayList<User>();
	}
	
	
	public boolean isMember( User x) {
		
		for( int i = 0; i < Members.size(); i++) {
			if(Members.get(i).getUsername() == x.getUsername() && Members.get(i).getEmail() == x.getEmail())
				return true;
		}
		
		return false;
	}
	
	
	public boolean addMember(User x) {
		
		if( !(isMember(x)) ) {
			Members.add(x);
			return true;
		}
		
		return false;
	}
	
	
	public void printMembers() {
		System.out.println("*******************************");
		System.out.println("Members of group " + Name);
		System.out.println("*******************************");
		for( int i = 0; i < Members.size(); i++)
			System.out.println( (i+1) + ": " + Members.get(i).getUsername());
		
		System.out.println("--------------------------------------");
	}
	
	
	public String getName() {
		return Name;
	}
	
	public boolean equals(Object o) {
		Group x = (Group) o;
		
		return Name.equals(x.Name);
	}
}
