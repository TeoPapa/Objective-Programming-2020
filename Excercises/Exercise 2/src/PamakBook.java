import java.util.ArrayList;

public class PamakBook {
	
	//Adds at the friends list of u1 the user u2
	static void addAFriend(User u1, User u2) {
		u1.addFriend(u2);
		System.out.println(u1.getUsername() + " and " + u2.getUsername() + " are now friends!");
	}
	
	
	//Prints the common friends
	static void printCommon(User u1, User u2) {
		ArrayList<User> Commons = new ArrayList<User>();
		
		Commons = u1.mutualFriends(u2);
		
		System.out.println("**************************************");
		System.out.println("Common friends of " + u1.getUsername() + " and " + u2.getUsername());
		System.out.println("**************************************");
		for( int i = 0; i < Commons.size(); i++)
			System.out.println( (i+1) + ": " + Commons.get(i).getUsername());
		
		System.out.println("--------------------------------------");
	}
	
	
	//Prints the friends list of user u
	static void printMyFriends( User u ) {
		u.printFriends();
	}
	
	
	//Adds user u to the group g
	static void addToGroup(User u, Group g) {
		g.addMember(u);
	}
	
	
	//Prints the groups the user u has enrolled in
	static void whereHaveIEnrolled(User u) {
		u.printGroups();
	}


	//Prints the mebmers of the group g
	public static void membersOfGroup(Group g) {
		g.printMembers();
	}


	public static void infection(User u) {
		ArrayList<User> Infected = new ArrayList<User>();
		
		Infected.addAll(u.itsCoronaTime());
		
		System.out.println("**************************************");
		System.out.println(u.getUsername() + " has been infected. The following users have to be tested");
		System.out.println("**************************************");
		
		for( int i = 0; i < Infected.size(); i++) 
			System.out.println(Infected.get(i).getUsername());
		
		System.out.println("--------------------------------------");
	}
}
