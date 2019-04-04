package finalKeyword;

public class Vehicle {
	final int speedLimit ;

	Vehicle(){
		speedLimit = 150;
	}
	
	void run() {
		int speedLimit1 = 250;
	}

	final void move() {
		System.out.println("Vehicle moving");
	}
}

class Car extends Vehicle {

	void move1() {
		System.out.println("Car moving");
	}
}
