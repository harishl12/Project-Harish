package superKeyword;

public class Lion extends Animal {
	String color = "brown";

	Lion() {
		super();
		System.out.println("Lion is created");
	}

	void eat() {
		System.out.println("Lion is eating");
	}

	void work() {
		eat();
		super.eat();
	}

	void printColor() {
		System.out.println(color);
		System.out.println(super.color);
	}
}
