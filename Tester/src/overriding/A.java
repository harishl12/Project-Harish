package overriding;

public class A {
	A test() {
		System.out.println("Parent");
		return this;
	}
}
