
public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("George", "123");
		Course c1 = new Course("Object-Oriented Programming", "E301", s1);
		
		Course c2 = new Course("Introduction to databases", "E302", new Student("Maria", "456") );

		
		c1.printCourse();
		c2.printCourse();
	}

}
