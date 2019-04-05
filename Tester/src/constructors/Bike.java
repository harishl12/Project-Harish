package constructors;

public class Bike {
	int model;
	String name;

	Bike(int i, String s) {
		model = i;
		name = s;
	}

	void display() {
		System.out.println(model + "->" + name);
	}

	public static void main(String[] args) {
		Bike b1 = new Bike(2000, "Activa");
		Bike b2 = new Bike(2018, "FZ");
		b1.display();
		b2.display();

	}
}
