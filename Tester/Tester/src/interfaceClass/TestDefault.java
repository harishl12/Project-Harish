package interfaceClass;

public class TestDefault implements DefaultMethod {
	public void print() {
		System.out.println("printing");
	}

	public static void main(String[] args) {
		TestDefault t1 = new TestDefault();
		// t1.msg();
		DefaultMethod.msg();
		t1.print();

	}
}
