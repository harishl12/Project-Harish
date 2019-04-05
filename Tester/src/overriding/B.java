package overriding;

public class B extends A {
	B test() {
		System.out.println("Child");
		return this;
	}
}
