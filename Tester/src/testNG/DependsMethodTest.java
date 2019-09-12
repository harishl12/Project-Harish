package testNG;

import org.testng.annotations.Test;

public class DependsMethodTest {
	@Test(dependsOnMethods = { "first", "mid" })
	public void last() {
		System.out.println("Last depends on mid,first");
	}

	@Test
	public void first() {
		System.out.println("first method");
	}

	@Test(dependsOnMethods = "first")
	public void mid() {
		System.out.println("Mid depends on firsst");
	}
}
