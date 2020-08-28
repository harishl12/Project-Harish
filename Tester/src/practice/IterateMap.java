package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IterateMap {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Harish", 122);
		map.put("Amul", 35);
		map.put("Dad", 11);
		map.put("Shakku", 12);
		map.put("Praka", 44);

		for (Entry<String, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + "->" + m.getValue());
		}

		map.forEach((k, v) -> System.out.println(k + "->" + v));
		;
	}
}
