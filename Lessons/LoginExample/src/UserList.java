import java.util.ArrayList;

public class UserList {
	private ArrayList<User> uList;
	
	public UserList() {
		uList = new ArrayList<User>();
	}
	
	public void addUser(User u) {
		uList.add(u);
	}
	
	 public User loginAttempt(String u, String p) {
		 User currentUser = null;
		 
		 for( int i = 0; i < uList.size(); i++) {
			 if(uList.get(i).equals(new User("", u, p))) {
				 currentUser = uList.get(i);
				 break;
			 }
		 }
		 
		 return currentUser;
	 } 
}
