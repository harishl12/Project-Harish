package testNG;

import org.testng.annotations.Test;

public class IgnoredMethod {
	@Test(enabled = false)
	public void ignoredMethod() {
		System.out.println("This to be ignored");
	}

	@Test
	public void donotIgnore() {
		System.out.println("Do not ignore");
	}
}
