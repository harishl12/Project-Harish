package innerClasses.staticInnerClass;

public class Outer {
	private static int data = 90;

	Outer() {
		System.out.println("Outer");
	}

	static class Inner {
		Inner() {
			System.out.println("Inner");
		}

		void show() {
			System.out.println(data);
		}
	}
}
