package collections;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorDemo {

	public static void main(String[] args) {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee("Harish", 26, "Benglur"));
		al.add(new Employee("Amul", 45, "Nagarabhavi"));
		al.add(new Employee("Lakshman", 3, "Karnataka"));

		System.out.println("Unsorted");

		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}

		System.out.println("Sorted name");
		Collections.sort(al, new SortName());
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}

		System.out.println("Sorted id");
		Collections.sort(al, new SortId());
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

}
