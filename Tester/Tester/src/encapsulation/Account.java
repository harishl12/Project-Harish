package encapsulation;

public class Account {
	private String name, email;
	private int salary, id;

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
