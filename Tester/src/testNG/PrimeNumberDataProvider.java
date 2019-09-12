package testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrimeNumberDataProvider {

	private PrimeNumberChecker primeCheck;

	@BeforeMethod
	public void initialize() {
		primeCheck = new PrimeNumberChecker();
	}

	@DataProvider(name = "test1")
	public static Object dataprovider() {
		return new Object[][] { { 2, true }, { 3, true }, { 6, false }, { 8, false }, { 13, true } };
	}

	@Test(dataProvider = "test1")
	public void testPrime(int input, boolean result) {
		System.out.println(input + " -> " + result);
		Assert.assertEquals(result, primeCheck.validate(input));
	}
}
