package collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
//		TreeSet<String> ts = new TreeSet<>();
		TreeSet<Integer> ts = new TreeSet<>();
		/*
		 * ts.add("Sachin"); ts.add("Rahul"); ts.add("Harry"); ts.add("Amul");
		 */

		ts.add(2);
		ts.add(100);
		ts.add(34);
		ts.add(23);

//		Iterator<String> it = ts.iterator();
		Iterator<Integer> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
