package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class CloneObject {
	public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Harry");
		ar.add("Amul");
		ar.add("Harish");
		System.out.println("Printing ar");
		print(ar);
		ArrayList<String> ar2 = (ArrayList<String>) ar.clone();
		System.out.println("Printing ar2");
		print(ar2);
		ar2.add("Fers");
		print(ar2);
		print(ar);
	}

	public static void print(ArrayList<String> ar) {
		Iterator<String> it = ar.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}