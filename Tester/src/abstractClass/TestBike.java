package abstractClass;

public class TestBike {
	public static void main(String[] args) {
		Bike b1 = new Pulsar();
		b1.model();
		b1.run();

		Bike b2 = new Access();
		b2.run();
		b2.model();
	}
}
