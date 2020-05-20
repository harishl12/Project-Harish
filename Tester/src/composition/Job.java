package composition;

public class Job {
	private String role;
	private int salary;
	private String department;

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
