import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class User implements Serializable {
	
	private String Username;
	private String email;
	private ArrayList <User> Friends;
	private ArrayList <Group> enrolledGroups;
	private ArrayList <Post> myPosts;
	private Boolean hasBeenCreated;
	private ArrayList <Integer> myGraph = new ArrayList<Integer>();
	
	
	public User(String u, String e) {
		if(e.matches("[id][ica][si][0-9][0-9][0-9][0-9][0-9]@uom.edu.gr") || e.matches("[id][ica][si][0-9][0-9][0-9][0-9]@uom.edu.gr") || e.matches("[id][ica][si][0-9][0-9][0-9]@uom.edu.gr") ) {
			Username = u;
			email = e;
			Friends = new ArrayList <User>();
			enrolledGroups = new ArrayList<Group>();
			myPosts = new ArrayList<Post>();
			hasBeenCreated = true;
		}
		else {
			hasBeenCreated = false;
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
	
	
	//Adds a post to the User
	public void addPost(Post p) {
		myPosts.add(p);
	}
	
	public ArrayList<Post> returnMyPosts() {
		return myPosts;
	}
	
	
	//Returns an array with all the posts of the User and the User's friends
	public ArrayList<Post> returnAllPosts() {
		ArrayList<Post> allPosts = new ArrayList<Post>();
		
		allPosts.addAll(myPosts);
		for(int i = 0; i < Friends.size(); i++ ) {
			allPosts.addAll(Friends.get(i).returnMyPosts());
		}
		
		for(int i = (allPosts.size() - 1); i > 0; i-- ) {
			for(int j = 0; j < i; j++) {
				if(allPosts.get(j).getTime().compareTo(allPosts.get(j+1).getTime()) < 0 )
					Collections.swap(allPosts, j, (j+1));
			}
		}
		
		return allPosts;
	}
	
	
	//Returns an ArrayList with the suggested friends of the User
	public ArrayList<User> suggestedFriends() {
		ArrayList<User> suggFriends = new ArrayList<User>(); //Will hold the suggested friends

		for(int i = 0; i < Friends.size(); i++) {
			ArrayList<User> tempFriends = Friends.get(i).returnFriends(); // Has the friends of the user i
			Boolean found = false; //Holds if there has been at least one mutual friend in the friends list of user

			for( int j = 0; j < tempFriends.size(); j++) {
				if(this.checkMutual(tempFriends.get(j))) {
					found = true;
					break;
				}
			}

			if(found)
				for(int j = 0; j < tempFriends.size(); j++) {
					if( !(checkMutual(tempFriends.get(j))) && !(isItMe(tempFriends.get(j))) )
						suggFriends.add(tempFriends.get(j));
				}
		}
		
		for(int i = 0; i < suggFriends.size(); i++) {
			for(int j = i + 1; j < suggFriends.size(); j++) {
				if( suggFriends.get(i).equals(suggFriends.get(j)) )
					suggFriends.remove(i);
			}

		}
		
		return suggFriends;
	}
	
	
	public boolean userCreated() {
		return hasBeenCreated;
	}
	
	
	
	public boolean equals(Object o) {
		User u = (User) o;
		
		if(this.Username.equals(u.Username) )
			return true;
		
		return false;
	}


	//The method that checks the diameters. It's not perfect, but it returns the correct numbers.
	public void checkTheGraph(User senter, int diameter, int type_of_sent) {
		
		if(type_of_sent == 0) {
			for(int i = 0; i < Friends.size(); i++) {
				int thisDia = diameter + 1;
				Friends.get(i).checkTheGraph(this, thisDia, 1);
			}
		} else {
			for(int i = 0; i < Friends.size(); i++) {
				if( !(senter.isFriends(Friends.get(i))) && !(senter.isItMe(Friends.get(i)))   ) {
					int thisDia =  diameter + 1;
					Friends.get(i).checkTheGraph(this, thisDia, 1);
				}
			}
		}
		
		myGraph.add(diameter);
	}
	
	public ArrayList<Integer> getmyGraph() {
		return myGraph;
	}
}
