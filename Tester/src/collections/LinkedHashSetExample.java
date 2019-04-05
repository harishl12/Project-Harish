package collections;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("Sachin");
		lhs.add("Rahul");
		lhs.add("Harry");
		lhs.add("Amul");

		for (String s : lhs)
			System.out.println(s);
	}
}
