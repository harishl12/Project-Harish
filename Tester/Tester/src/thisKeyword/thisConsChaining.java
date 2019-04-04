package thisKeyword;

/*
 * Real usage of this() constructor call
The this() constructor call should be used to reuse the constructor from the constructor. 
It maintains the chain between the constructors i.e. it is used for constructor chaining.
 Let's see the example given below that displays the actual use of this keyword.
 */

public class thisConsChaining {
	int id;
	String name, course;
	float fee;

	public thisConsChaining(int id, String name, String course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	public thisConsChaining(int id, String name, String course, float fee) {
		this(id, name, course);
		this.fee = fee;

	}

	void display() {
		System.out.println(id + " " + name + " " + course + " " + fee);

	}

	public static void main(String[] args) {
		thisConsChaining t1 = new thisConsChaining(13, "hari", "c++");
		t1.display();
		thisConsChaining t2 = new thisConsChaining(15, "Gary", "java", 10004f);
		t2.display();
	}
}
