package designPattern.structural.adapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeClient {

	public ArrayList<Employee> getEmployeeList() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee employeeFromDB = new EmployeeDB("17", "John", "wick", "john.wick@happs.com");
		employees.add(employeeFromDB);

//		Employee employeeFromLdap = new EmployeeLdap("chewie", "solo", "han", "han.solo@happs.com");
		EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie", "solo", "han", "han.solo@happs.com");
		employees.add(new EmployeeAdapterLdap(employeeFromLdap));
		
		return employees;
	}
}
