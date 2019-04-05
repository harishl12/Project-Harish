package objects;

public class Student2 implements Cloneable {
	int id;
	String name;

	void insertInfo(int i, String n) {
		id = i;
		name = n;
	}

	void displayInfo() {
		System.out.println(id + " " + name);
	}
}
