package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Sachin");
		ll.add("Rahul");
		ll.add("Harry");
		ll.add("Amul");

		Iterator<String> it = ll.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(ll.remove("Gary"));
		System.out.println(ll.get(2));
	}
}
