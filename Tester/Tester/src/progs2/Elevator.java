package progs2;

import java.util.Scanner;

public class Elevator {
	static int currentFloor;

	public static void moveToFloor(int sourceFloor, int targetFloor) {
		if (targetFloor == sourceFloor)
			System.out.println("Elevator is in floor -> " + targetFloor);
		else if (targetFloor > sourceFloor)
			moveUp(sourceFloor, targetFloor);
		else
			moveDown(sourceFloor, targetFloor);

	}

	public static void moveDown(int sourceFloor, int targetFloor) {
		System.out.println("Elevator is on its way down");
		while (targetFloor < sourceFloor) {
			System.out.println("Elevator is in floor -> " + sourceFloor);
			sourceFloor--;
		}
		System.out.println("Elevator has arrived");
	}

	public static void moveUp(int sourceFloor, int targetFloor) {
		System.out.println("Elevator is on its way up");
		while (targetFloor > sourceFloor) {
			System.out.println("Elevator is in floor -> " + sourceFloor);
			sourceFloor++;
		}
		System.out.println("Elevator has arrived");
	}

	public static void run() {
		currentFloor = ((int) Math.random() * 10) + 1;
		System.out.println("The elevator is in " + currentFloor + " floor");
		System.out.println("Which floor you are at now");
		Scanner scan = new Scanner(System.in);
		int personFloor = scan.nextInt();
		if (currentFloor == personFloor)
			System.out.println("Enter the elevator");
		else
			moveToFloor(currentFloor, personFloor);
		System.out.println("Enter the elevator");
		System.out.println("Which floor would yoyu like to go ");
		int destinationFloor = scan.nextInt();
		moveToFloor(personFloor, destinationFloor);
		System.out.println("Exit the elevator");

	}

	public static void main(String[] args) {
		Elevator.run();
	}
}
