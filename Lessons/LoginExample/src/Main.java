
public class Main {

	public static void main(String[] args) {
		UserList uList = new UserList();
		
		uList.addUser(new Student("A A", "aaa", "aaa"));
		uList.addUser(new Student("B B", "bbb", "bbb"));
		uList.addUser(new Student("C C", "ccc", "ccc"));
		uList.addUser(new Student("D D", "ddd", "ddd"));
		
		new LoginGUI(uList);
	}

}
