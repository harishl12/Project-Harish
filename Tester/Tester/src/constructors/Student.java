package constructors;
//* Copy constructor

public class Student {
	int age;
	String name;

	Student(int a, String n) {
		age = a;
		name = n;
	}

	Student(Student s) {
		age = s.age;
		name = s.name;
	}

	void display() {
		System.out.println(age + "-> " + name);

	}

	public static void main(String[] args) {
		Student s1 = new Student(31, "Harish");
		Student s2 = new Student(s1);
		s1.display();
		s2.display();
	}
}
