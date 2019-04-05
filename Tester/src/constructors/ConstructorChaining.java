package constructors;

public class ConstructorChaining {
	String name;
	int id, age, fee;

	public ConstructorChaining(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public ConstructorChaining(String name, int id, int age, int fee) {
		this(name, id, age);
		this.fee = fee;
	}

	public void display() {
		System.out.println(name + "->" + id + "->" + age + "->" + fee);
	}

	public static void main(String[] args) {
		ConstructorChaining cc = new ConstructorChaining("Amu", 23, 45, 1000);
		cc.display();
	}

}
