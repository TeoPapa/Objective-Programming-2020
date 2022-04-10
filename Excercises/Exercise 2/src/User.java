import java.util.ArrayList;

public class User {
	
	private String Username;
	private String email;
	private ArrayList <User> Friends;
	private ArrayList <Group> enrolledGroups;
	
	
	public User(String u, String e) {
		if(e.matches("[id][ica][si][0-9][0-9][0-9][0-9][0-9]@uom.edu.gr") || e.matches("[id][ica][si][0-9][0-9][0-9][0-9]@uom.edu.gr") || e.matches("[id][ica][si][0-9][0-9][0-9]@uom.edu.gr") ) {
			Username = u;
			email = e;
			Friends = new ArrayList <User>();
			enrolledGroups = new ArrayList<Group>();
		}
		else {
			System.out.println("User " + u + " has not been created. Email format is not acceptable");
		}
	}
	
	
	
	//Checks if the user is friends with the user friend and returns true if they are or false if they are not. By default the student is not friends with his friends thus the lines 19-20
	public boolean isFriends( User friend) {
		if(isItMe(friend))
			return false;
		
		for(int i = 0; i < Friends.size(); i++) {
			if(Friends.get(i).Username.equals(friend.Username) && Friends.get(i).email.equals(friend.email)) 
				return true;
		}
		
		return false;
	}
	
	
	//Checks if the user friend is in the friend list or is the user 
	public void addFriend(User friend) {
		if( !(isFriends(friend)) && !(isItMe(friend)) ) {
			Friends.add(friend);
			friend.Friends.add(this);
		}
	}
	
	
	//Returns the array of the mutual friends between the User and the friend
	public ArrayList<User> mutualFriends(User friend) {
		ArrayList<User> mFriends = new ArrayList<User>();
		
		for( int i = 0; i < Friends.size(); i++) {
			if( friend.checkMutual(Friends.get(i))) {
				mFriends.add(Friends.get(i));
			}
		}
		return mFriends;
	}
	
	
	//Prints the friends of the user
	public void printFriends() {
		
		System.out.println("**************************************");
		System.out.println("Friends of " + Username);
		System.out.println("**************************************");
		
		for(int i = 0; i < Friends.size(); i++)
			System.out.println( (i+1) + ": " + Friends.get(i).Username);
		
		System.out.println("--------------------------------------");
	}
	
	
	//Prints the groups the User has enrolled in
	public void printGroups() {
		System.out.println("**************************************");
		System.out.println("Groups that " + Username + " has enrolled in");
		System.out.println("**************************************");
		
		for(int i = 0; i < enrolledGroups.size(); i++)
			System.out.println( (i+1) + ": " + enrolledGroups.get(i).getName() );
		
		System.out.println("--------------------------------------");
	}
	
	
	//Returns an ArrayList with all the friends of the User and all the friends of the friends of the user (without repeatable names)
	public ArrayList <User> itsCoronaTime() {
		ArrayList <User> Corona = new ArrayList<User>();
		
		Corona.addAll(Friends); 
		
		for( int i = 0; i < Friends.size(); i++) { 
			
			ArrayList <User> tempFriends = new ArrayList<User>();
			tempFriends.addAll(Friends.get(i).returnFriends()); 
			
			for( int j = 0; j < Corona.size(); j++) { 
				for( int k = 0; k < tempFriends.size(); k++) { 
					if( Corona.get(j).email == tempFriends.get(k).email && Corona.get(j).Username == tempFriends.get(k).Username) 
						tempFriends.remove(k);
					else if ( this.email == tempFriends.get(k).email && this.Username == tempFriends.get(k).Username)
						tempFriends.remove(k);
				}
			}
			
			Corona.addAll(tempFriends);
		}
		
		return Corona;
	}
	
	
	//Returns the friends of the User
	public ArrayList<User> returnFriends() {
		return Friends;
	}
													

	//Returns true if the mUser exists in the friends list and false if it does not
	public boolean checkMutual(User mUser) {
		for(int i = 0; i < Friends.size(); i++) {
			if( (mUser.Username == Friends.get(i).Username) && (mUser.email == Friends.get(i).email) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	//Returns true if the user x is the current user or false if it's someone else
	private boolean isItMe(User x) {
		return Username.equals(x.Username) && email.equals(x.email);
	}
	
	
	//Returns the Username of the User
	public String getUsername() {
		return Username;
	}
	
	
	//Returns the email of the User
	public String getEmail() {
		return email;
	}
}
