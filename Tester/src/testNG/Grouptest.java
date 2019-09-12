package testNG;

import org.testng.annotations.Test;

public class Grouptest {
	@Test(groups = "functional")
	public void runFunctionalTest() {
		System.out.println("Run functional group");
	}

	@Test(groups = "Smoke")
	public void runSmoke() {
		System.out.println("Run Smoke group");
	}

	@Test(groups = "performance")
	public void runPerformancetest() {
		System.out.println("run performance group");
	}
}
