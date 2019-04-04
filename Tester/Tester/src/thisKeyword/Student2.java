package thisKeyword;

public class Student2 {
	int id;
	String name;

	Student2(int id, String name) {
		this.id = id;
		this.name = name;

	}

	void display() {
		System.out.println(id + " -> " + name);
	}

	public static void main(String[] args) {
		Student2 s1 = new Student2(13, "Greg");
		s1.display();
		Student2 s2 = new Student2(16, "House");
		s2.display();

	}
}
