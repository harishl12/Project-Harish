package testNG;

public class EmployeeDetails {
	private int salary;
	private int age;
	private String name;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int calculateAnnualSalary(int salary) {
		int annualSalary = 0;
		annualSalary = salary * 12;
		return annualSalary;
	}

	public int calculateAppraisal(int salary) {
		int appraisal = 0;
		if (salary > 10000)
			appraisal = 500;
		else
			appraisal = 1000;
		return appraisal;
	}

}
