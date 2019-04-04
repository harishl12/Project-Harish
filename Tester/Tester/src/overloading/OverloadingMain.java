package overloading;

public class OverloadingMain {
	public static void main(String[] args) {
		System.out.println("String array");
	}

	public static void main(String args) {
		System.out.println("string");
	}

	public static void main() {
		System.out.println("No args");
	}
}
