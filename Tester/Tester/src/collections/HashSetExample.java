package collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Sachin");
		hs.add("Rahul");
		hs.add("Harry");
		hs.add("Amul");

		// for (String s : hs)
		// System.out.println(s);

		Iterator<String> it = hs.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
