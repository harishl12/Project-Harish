package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(123, "Harry");
		map.put(234, "Amul");
		map.put(456, "Dada");
		map.put(12, "Shakku");

		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " -> " + m.getValue());
		}
	}
}
