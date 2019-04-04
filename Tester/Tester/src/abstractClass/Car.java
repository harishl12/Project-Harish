package abstractClass;

public class Car extends Vehicle {
	void run() {
		System.out.println("Car running");
	}

	public static void main(String[] args) {
		Vehicle v1 = new Car();
		v1.run();
	}
}
