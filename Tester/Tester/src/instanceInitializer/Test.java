package instanceInitializer;

public class Test {
	int nonStaticVariable;
	static int staticVariable;
	static {
		System.out.println("static initialization");
		staticVariable = 5;
		System.out.println("staticVariable ->" + staticVariable);
	}
	{
		System.out.println("non static initialization");
		nonStaticVariable = 10;
		System.out.println("non static Variable -> " + nonStaticVariable);
	}

	Test() {
		System.out.println("Constructor");
	}

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 =  new Test();
				
	}
}
