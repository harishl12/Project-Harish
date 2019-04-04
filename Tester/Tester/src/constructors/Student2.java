package constructors;

public class Student2 {
	int id;
	String name;

	Student2(int i, String s) {
		id = i;
		name = s;
	}

	Student2() {

	}

	void display() {
		System.out.println(id + " -> " + name);
	}

	public static void main(String[] args) {
		Student2 s1 = new Student2(17, "Harish");
		Student2 s2 = new Student2();
		s2.id = s1.id;
		s2.name = s1.name;
		s1.display();
		s2.display();
	}
}
