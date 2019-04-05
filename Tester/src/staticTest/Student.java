package staticTest;

public class Student {
	int id;
	String name;
	static String college = "JSS";

	Student(int i, String n) {
		id = i;
		name = n;
	}

	void display() {
		System.out.println(id + " ->" + name + " -> " + college);
	}

	public static void main(String[] args) {
		Student s1 = new Student(17, "Harry");
		Student s2 = new Student(18, "Amul");
		s1.display();
		s2.display();
	}

}
