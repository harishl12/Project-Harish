package testNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Basic {
	@Test
	public void tester() {
		String str = "TestNG is working fine";
		assertEquals("TestNG is working fine", str);
	}
}
