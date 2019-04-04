package superKeyword;

public class Employee extends Person {
	double salary;

	public Employee(int id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}

	void display() {
		System.out.println(id + "->" + name + "->" + salary);
	}
}
