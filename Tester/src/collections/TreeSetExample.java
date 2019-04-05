package collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<>();
		ts.add("Sachin");
		ts.add("Rahul");
		ts.add("Harry");
		ts.add("Amul");

		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
