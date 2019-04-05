package instanceInitializer;

public class Bike {
	Bike() {
		System.out.println("Bike is created");
	}

	{
		System.out.println("Instance initializer block is created");
	}

	public static void main(String[] args) {
		Bike b = new Bike();
	}
}
