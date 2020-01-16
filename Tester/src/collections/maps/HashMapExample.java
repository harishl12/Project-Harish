package collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(123, "Harry");
		map.put(234, "Amul");
		map.put(456, "Dada");
		map.put(12, "Shakku");

		for (Entry<Integer, String> m : map.entrySet())
			System.out.println(m.getKey() + "->" + m.getValue());

	}
}
