import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PamakBook {
	
	private static ArrayList<User> AllTheUsers = new ArrayList<User>();
	private static ArrayList<Group> AllTheGroups = new ArrayList<Group>();
	private static int hasStartedFromFile;
	
	//Adds at the friends list of u1 the user u2
	static void addAFriend(User u1, User u2) {
		u1.addFriend(u2);
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
	static boolean addToGroup(User u, Group g) {
		return g.addMember(u);
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
	
	//Adds to the PamakBook the users that are registered
	public static void addUserToPB(User u) {
		AllTheUsers.add(u);
	}
	
	//Returns the ArrayList with all the Users
	public static ArrayList<User> getAllTheUsers() {
		return AllTheUsers;
	}
	
	
	
	//Prints in the Console the biggest length between two peaks in the PamakBook Users graph
	public static int graphLength() {
		ArrayList<Integer> Distances = new ArrayList<Integer>();
		
		for(int i = 0; i < AllTheUsers.size(); i++) {
			AllTheUsers.get(i).checkTheGraph(null, 0, 0);
			Distances.addAll(AllTheUsers.get(i).getmyGraph());
		}
		
		int length = checkMax(Distances);
		
		return length;
	}
	
	
	//Finds the max in an ArrayList of Integers and returns it
	private static int checkMax(ArrayList<Integer> x) {
		int max = x.get(0);
		
		for(int i = 1; i < x.size(); i++) {
			if(x.get(i) > max) max = x.get(i);
		}
		
		return max;
	}
	
	
	
	public static void addGroup(Group g) {
		boolean temp = true;
		for(int i = 0; i < AllTheGroups.size(); i++) {
			if(AllTheGroups.get(i).equals(g)) {
				temp = false;
				break;
			}
		}
		if(temp)
			AllTheGroups.add(g);
	}
	
	
	
	//Returns the list with all the available groups in the system
	public static ArrayList<Group> getAllTheGroups() {
		return AllTheGroups;
	}

	
	
	//Loads from the Users.ser and Groups.ser the data from previous uses
	public static void loadFiles() {
		File fUser = new File("Users.ser");
		File fGroup = new File("Groups.ser");
		
		if(fUser.length() > 0) {
			try {
				FileInputStream fins = new FileInputStream(fUser);
				ObjectInputStream dins = new ObjectInputStream(fins);
			
				AllTheUsers.addAll( (ArrayList<User>) dins.readObject() );
			
				dins.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if(fGroup.length() > 0) {
			try {
				FileInputStream finss = new FileInputStream(fGroup);
				ObjectInputStream dinss = new ObjectInputStream(finss);
				
				AllTheGroups.addAll( (ArrayList<Group>) dinss.readObject() );
			
				dinss.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if(fGroup.length() > 0 || fUser.length() > 0) {
			hasStartedFromFile = AllTheGroups.size() + AllTheUsers.size();
		} else {
			hasStartedFromFile = 0;
		}
	}
	
	
	//Checks if the program has started from a File and if so checks if the file had data in it
	public static boolean hasFileStart() {
		boolean temp = true;
		
		if(hasStartedFromFile == 0) 
				temp = false;
		
		return temp;
	}
	
	
	
	public static void saveFiles() {
		File fUsers = new File("Users.ser");
		File fGroups = new File("Groups.ser");
		
		try {
			FileOutputStream fouts = new FileOutputStream(fUsers);
			ObjectOutputStream douts = new ObjectOutputStream(fouts);
			
				douts.writeObject(AllTheUsers);
			
			douts.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileOutputStream foutss = new FileOutputStream(fGroups);
			ObjectOutputStream doutss = new ObjectOutputStream(foutss);
			
				doutss.writeObject(AllTheGroups);
			
			doutss.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
