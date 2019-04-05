package overloading;

/* 
 * Method Overloading: changing no. of arguments
 */
public class Overloading1 {
	int add(int n1, int n2) {
		return n1 + n2;
	}

	int add(int n1, int n2, int n3) {
		return n1 + n2 + n3;
	}

	double add(double d1, double d2) {
		return d1 + d2;
	}

	public static void main(String[] args) {
		Overloading1 o1 = new Overloading1();
		System.out.println(o1.add(3, 4));
		System.out.println(o1.add(4, 5, 6));
		System.out.println(o1.add(4.5f, 3.9f));
	}
}
