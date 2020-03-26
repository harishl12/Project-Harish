package innerClasses.nestedInnerClass;

public class Outer {
	Outer() {
		System.out.println("I am outer class");
	}

	void outerMethod() {
		System.out.println("Outer Method");
	}

	public class Inner {
		public Inner() {
			System.out.println("Inner");
		}

		void innerMethod() {
			System.out.println("Inner method");
		}
	}

}
