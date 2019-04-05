package overriding;

public class Test {
	public static void main(String[] args) {
		Car c = new Car();
		c.run();
		System.out.println(c.model);
	}
}
