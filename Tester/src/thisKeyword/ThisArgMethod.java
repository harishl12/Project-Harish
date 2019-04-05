package thisKeyword;
/*
 * 4) this: to pass as an argument in the method
The this keyword can also be passed as an argument in the method.
 It is mainly used in the event handling. Let's see the example:
 */


public class ThisArgMethod {
	
	void m(ThisArgMethod m) {
		System.out.println("Method is invoked");
	}

	void n() {
		m(this);
	}
	
	public static void main(String[] args) {
		ThisArgMethod t = new ThisArgMethod();
		t.n();
	}
}
