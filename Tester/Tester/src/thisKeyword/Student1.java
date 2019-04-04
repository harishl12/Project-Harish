package thisKeyword;

public class Student1 {
	int id;
	String name;

	Student1(int id, String name) {
		id = id;
		name = name;

	}

	void display() {
		System.out.println(id + " -> " + name);
	}

	public static void main(String[] args) {
		Student1 s1 = new Student1(13, "Greg");
		s1.display();
		Student1 s2 = new Student1(16, "House");
		s2.display();

	}
}
