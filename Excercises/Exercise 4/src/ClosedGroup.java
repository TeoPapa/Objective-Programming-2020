import java.util.ArrayList;

public class ClosedGroup extends Group{
	
	public ClosedGroup(String n, String d) {
		super(n, d);
	}

	
	
	//Overrides the addMember of Group and checks if the User is friends with someone that is member of this group. If not User will not be registered. The first User provided will be entered by default. Returns true if the user has been added and false if not
	public boolean addMember(User x) {
		boolean hasFriend = false;
		int i = 0;
		
		if(Members.size() == 0 ) {
			super.addMember(x);
			hasFriend = true;
			return true;
		}
		else {
			
			while( i < Members.size() && !(hasFriend) ) {
				ArrayList<User> tempFriends = new ArrayList<User>();
				
				for( int p = 0; p < Members.size(); p++)
					tempFriends.addAll(Members.get(p).returnFriends());
				
				for( int j = 0; j < tempFriends.size(); j++) {
					if( tempFriends.get(i).getUsername() == x.getUsername() && tempFriends.get(i).getEmail() == x.getEmail() ) {
							super.addMember(x);
							hasFriend = true;
							return true;
					}
					else {
						i++;
					}
				}
			}
			
			return false;
		}
		
	}
	
}
