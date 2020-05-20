package composition;

public class Employee {
	private Job job;
	private int salary;

	public Employee() {
		this.job = new Job();
		job.setSalary(1000);
	}

	public int getSalary() {
		return job.getSalary();
	}
}
