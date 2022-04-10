
public class Student {
	private String name;
	private String id;
	
	public Student() {
		name = "";
		id = "";
	}
	
	public Student(String n, String i) {
		name = n;
		id = i;
	}
	
	
	public String getName() {return name;}
	public String getID() {return id;}
	
	public void setName( String n) { name = n;}
	public void setID( String i) { id = i;}
	
	public void printStudent() {
		System.out.println("Student: " + name + ", with ID: " + id);
	}
}
