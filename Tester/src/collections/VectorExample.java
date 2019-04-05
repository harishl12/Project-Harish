package collections;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<>();
		vec.add("Harry");
		vec.add("Amul");
		vec.add("Pakya");
		vec.add("Mummy");

		Iterator<String> it = vec.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
