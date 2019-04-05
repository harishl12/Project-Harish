package progs2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateCharacterString {
	public static void main(String[] args) {
		String s = "Sachin Tendulkar";
		char[] c = s.toCharArray();
		// HashMap<Character, Integer> map = new HashMap<>();
		// for (char c1 : c) {
		// if (map.containsKey(c1)) {
		// map.put(c1, map.get(c1) + 1);
		// } else
		// map.put(c1, 1);
		// }
		// System.out.println(map.keySet());

		Set<Character> set = new LinkedHashSet<>();
		for (char c2 : c)
			set.add(c2);

		StringBuilder sb = new StringBuilder();
		for (Character c1 : set)
			sb.append(c1);

		System.out.println(sb);
	}
}
