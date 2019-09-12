package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test
	public void testcase1() {
		System.out.println("In testcase1");
	}

	@Test
	public void testcase2() {
		System.out.println("In testcase2");
	}

	@BeforeSuite
	public void beforesuite() {
		System.out.println("In before suite");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("In After suite");
	}

	@BeforeClass
	public void beforeclass() {
		System.out.println("In before class");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("In after class");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("In before test");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("In after test");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("In before method");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("In after method");
	}
}
