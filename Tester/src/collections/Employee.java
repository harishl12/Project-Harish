package collections;

import java.util.Comparator;

public class Employee {
	String name;
	int id;
	String address;

	public Employee(String name, int id, String address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}

	public String toString() {
		return name + " " + id + " " + address;
	}
}

class SortName implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return (e1.name.compareTo(e2.name));
	}

}

class SortId implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.id - e2.id;
	}

}