
public class Course {
	private String name;
	private String classroom;
	private Student[] enrolledStudent;
	private int numEnrollStudents;
	
	public Course() {
		name = "";
		classroom = "";
		enrolledStudent = new Student[10];
		numEnrollStudents = 0;
	}
	
	public Course( String n, String c) {
		name = n;
		classroom = c;
		enrolledStudent = new Student[10];
		numEnrollStudents = 0;
	}
	
	public void enrollStudent( Student c ) {
		System.out.println("Atempting to enroll student: " + s.getName() + "into course: " + name + "...");
		if (numEnrollStudents < 10) {
			enrolledStudents[numEnrollStudents] = c;
		}
	}
	
	
	public void printCourse() {
		System.out.println("==========================");
		System.out.println("Course: " + name );
		System.out.println("Classroom: " + classroom );
		System.out.print("\t");
		enrolledStudent.printStudent();
	}
}
