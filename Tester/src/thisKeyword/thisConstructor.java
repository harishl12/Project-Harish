package thisKeyword;
//3) this() : to invoke current class constructor

public class thisConstructor {
	public thisConstructor() {
		this(6);
		System.out.println(" Default constructor ");
	}

	thisConstructor(int n) {
		System.out.println(n);
	}

	public static void main(String[] args) {
		thisConstructor t = new thisConstructor();

	}
}
