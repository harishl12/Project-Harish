package exception;

public class CheckedExceptionPropagation {

	void m() throws InterruptedException {
		System.out.println("in m");
		Thread.sleep(1000);
	}

	void p() throws InterruptedException {
		System.out.println("in p()");
		m();
	}

	void n() throws InterruptedException {
		System.out.println("In n()");
		p();

	}

	public static void main(String[] args) throws InterruptedException {
		CheckedExceptionPropagation ce = new CheckedExceptionPropagation();
		ce.n();
		System.out.println("Normal flow");
	}
}
