package progs2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountCharacterString {
	public static void main(String[] args) {
		String s = "India";
		HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
		char[] c = s.toLowerCase().toCharArray();
		int count = 0;
		for (char c1 : c) {
			if (stringMap.containsKey(c1))
				stringMap.put(c1, stringMap.get(c1) + 1);
			else
				stringMap.put(c1, 1);
		}

		for (Entry<Character, Integer> m : stringMap.entrySet())
			System.out.println(m.getKey() + "-> " + m.getValue());
	}
}
