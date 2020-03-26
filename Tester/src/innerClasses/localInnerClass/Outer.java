package innerClasses.localInnerClass;

import innerClasses.nestedInnerClass.Outer.Inner;

public class Outer {
	private int data = 17;

	Outer() {
		System.out.println("Outer");
	}

	void display() {
		class Inner {
			Inner() {
				System.out.println("Inner");
			}

			void msg() {
				System.out.println(data);
			}

		}
		Inner in = new Inner();
		in.msg();
	}
}