
public class Main {

	public static void main(String[] args) {
		
		User u1 = new User("Makis", "iis1998@uom.edu.gr");
		User u2 = new User("Petros", "ics1924@uom.edu.gr");
		User u3 = new User("Maria", "iis2012@uom.edu.gr");
		User u4 = new User("Gianna", "iis19133@uom.edu.gr");
		User u5 = new User("Nikos", "dai1758@uom.edu.gr");
		User u6 = new User("Babis", "ics19104@uom.edu.gr");
		User u7 = new User("Stella", "dai1827@uom.edu.gr");
		User u8 = new User("Eleni", "ics2086@gmail.com");
		
		Group g1 = new Group("WebGurus","A group for web passionates");
		ClosedGroup g2 = new ClosedGroup("ExamSolutions","Solutions to common exam questions");
		
		
		PamakBook.addAFriend(u1, u2);
		PamakBook.addAFriend(u1, u5);
		PamakBook.addAFriend(u5, u6);
		PamakBook.addAFriend(u3, u4);
		PamakBook.addAFriend(u3, u2);
		PamakBook.addAFriend(u4, u6);
		PamakBook.addAFriend(u5, u3);
		PamakBook.addAFriend(u1, u6);
		PamakBook.addAFriend(u5, u2);
		PamakBook.addAFriend(u7, u1);
		
		PamakBook.printCommon(u5, u4);
		PamakBook.printCommon(u1, u5);
		
		PamakBook.printMyFriends(u1);
		PamakBook.printMyFriends(u3);
		
		PamakBook.addToGroup(u4, g1);
		PamakBook.addToGroup(u3, g1);
		PamakBook.addToGroup(u2, g1);
		PamakBook.addToGroup(u4, g2);
		PamakBook.addToGroup(u5, g2);
		PamakBook.addToGroup(u6, g2);
		PamakBook.addToGroup(u5, g2);
		
		PamakBook.whereHaveIEnrolled(u4);
		
		PamakBook.membersOfGroup(g1);
		PamakBook.membersOfGroup(g2);
		
		PamakBook.infection(u4);
	}

}
