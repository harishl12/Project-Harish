package overriding;

public class Car extends Vehicle {
	void run() {
		System.out.println("Car is running");
	}

	void move() {
		System.out.println("Vehicle is moving");
	}
}
