package arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListsExample {
	public void display(ArrayList<String> al) {
		for (String s : al)
			System.out.println(s);
	}

	public static void main(String[] args) {
		ArrayListsExample ale = new ArrayListsExample();
		ArrayList<String> al = new ArrayList<String>();
		al.add("Harry");
		al.add("Amul");
		al.add("Pakya");

		Iterator<String> it = al.iterator();
		/*
		 * while (it.hasNext()) { System.out.println(it.next()); }
		 */
		ale.display(al);
		al.add(2, "shakku");
		ale.display(al);

	}
}