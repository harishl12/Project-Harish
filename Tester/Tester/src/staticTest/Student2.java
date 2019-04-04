package staticTest;

public class Student2 {
	int id;
	String name;
	static String collegename = "KLE";

	public Student2(int i, String n) {
		id = i;
		name = n;
	}

	void display() {
		System.out.println(id + " -> " + name + " -> " + collegename);
	}

	public static void main(String[] args) {
		Student2 s1 = new Student2(19, "Hari");
		s1.display();
		Student2 s2 = new Student2(20, "Kuri");
		s2.display();
		Student2.collegename = "JSS";
		Student2 s3 = new Student2(21, "mari");
		s3.display();
	}
}
