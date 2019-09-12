package testNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestEmployee {
	EmployeeDetails ed = new EmployeeDetails();

	@Test
	public void testAnnualSalary() {
		ed.setName("Harry");
		ed.setSalary(8000);
		ed.setAge(32);

		int annualSalary = ed.calculateAnnualSalary(ed.getSalary());
		assertEquals(annualSalary, 96000);

	}

	@Test
	public void testApppraisal() {
		ed.setName("Amul");
		ed.setSalary(12000);
		ed.setAge(32);

		int appraisal = ed.calculateAppraisal(ed.getSalary());
		assertEquals(appraisal, 500);
	}

}
