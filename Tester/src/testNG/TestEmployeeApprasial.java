package testNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestEmployeeApprasial {

	EmployeeDetails de1 = new EmployeeDetails();

	@Test
	public void testAppraisal2() {
		de1.setAge(26);
		de1.setName("Harish");
		de1.setSalary(11000);

		int sal = de1.calculateAppraisal(de1.getSalary());
		assertEquals(sal, 500);
	}
}
