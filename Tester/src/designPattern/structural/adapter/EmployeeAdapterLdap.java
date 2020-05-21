package designPattern.structural.adapter;

public class EmployeeAdapterLdap implements Employee {
	private EmployeeLdap instance;

	public EmployeeAdapterLdap(EmployeeLdap instance) {
		this.instance = instance;
	}

	@Override
	public String getId() {
		return instance.getCn();
	}

	@Override
	public String getFirstName() {
		return instance.getGivenName();
	}

	@Override
	public String getLastName() {
		return instance.getSurname();
	}

	@Override
	public String getEmail() {
		return instance.getEmail();
	}

	@Override
	public String toString() {
		return "ID: " + instance.getCn() + " firstName:" + instance.getGivenName() + " lastname:"
				+ instance.getSurname() + " Email:" + instance.getEmail();
	}

}
