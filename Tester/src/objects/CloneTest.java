package objects;

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Cloner c1 = new Cloner();
		c1.setName("Harry");
		System.out.println(c1.getName());

		Cloner c2 = (Cloner) c1.clone();
		System.out.println(c2.getName());
		System.out.println("c1==c2 ->"+(c1==c2));
		System.out.println("c1.equals(c2) ->" + c1.equals(c2) );
		if (c1 == c2) {
			System.out.println("references are same");
		}

		if (c1.equals(c2)) {
			System.out.println("shallow copy");
		}
	}
}