package collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class DescendingOrderMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
		map.put(123, "Harry");
		map.put(234, "Amul");
		map.put(456, "Dada");
		map.put(82, "Shakku");

		// System.out.println(map.keySet());

		for (Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " -> " + m.getValue());
		}
	}
}
