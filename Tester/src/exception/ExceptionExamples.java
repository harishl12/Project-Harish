package exception;

public class ExceptionExamples {
	public static void main(String[] args) {
		String s = null;

		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException ae) {
			System.out.println("arithmetice exception");
		}
		try {
			System.exit(0);
			System.out.println(s.length());
		} catch (NullPointerException ne) {
			System.out.println("Null pointer exception");
		} finally {
			System.out.println("finally");
		}
	}
}
