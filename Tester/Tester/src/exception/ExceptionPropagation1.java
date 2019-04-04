package exception;

public class ExceptionPropagation1 {

	void n() {
		System.out.println("In n()");
		int x = 100 / 0;
		System.out.println(x);
	}

	void p() {
		System.out.println("in p()");
		n();

	}

	void m() {
		System.out.println("In m()");
		try {
			p();
		} catch (ArithmeticException ae) {
			System.out.println("Divide by Zero");
		}
	}

	public static void main(String[] args) {
		ExceptionPropagation1 Ex1 = new ExceptionPropagation1();
		Ex1.m();
		System.out.println("Normal flow");
	}
}
