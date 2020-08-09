package lambda;

public class Phones extends Product {
	String model;

	public Phones(int id, String name, double price, String model) {
		super(id, name, price);
		this.model = model;
	}

}
