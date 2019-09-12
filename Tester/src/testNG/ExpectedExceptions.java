package testNG;

import org.testng.annotations.Test;

public class ExpectedExceptions {
	@Test(expectedExceptions = ArithmeticException.class)
	public void exceptionmethod() {
		System.out.println(10 / 0);
	}

	@Test
	public void normalmethod() {
		System.out.println("Normal method");
	}
}
