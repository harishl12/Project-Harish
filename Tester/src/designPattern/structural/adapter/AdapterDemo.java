package designPattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterDemo {
	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();
		ArrayList<Employee> employees = client.getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
			System.out.println(employees.get(i));
	}
}
