package constructors;

public class CopyConstructor implements Cloneable {
	int id;
	String name;

	public CopyConstructor(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void display() {
		System.out.println(id + " -> " + name);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CopyConstructor c1 = new CopyConstructor(13, "Harry");
		c1.display();
		// CopyConstructor c2 = c1;
		// c2.display();
		CopyConstructor c3 = (CopyConstructor) c1.clone();
		c3.display();
		c1 = new CopyConstructor(15, "Amul");
		c1.display();
		// c2.display();

		c3.display();
	}

}
