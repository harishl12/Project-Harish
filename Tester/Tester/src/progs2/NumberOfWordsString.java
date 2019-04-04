package progs2;

import java.util.HashMap;
import java.util.Map.Entry;

public class NumberOfWordsString {
	public static void main(String[] args) {
		String s = "Elevator is on its way up\r\n" + "Elevator is in floor -> 5\r\n" + "Elevator is in floor -> 6\r\n"
				+ "Elevator is in floor -> 7\r\n" + "Elevator has arrived";
		String[] words = s.split("\\s+");

		System.out.println(words.length);
		HashMap<String, Integer> stringMap = new HashMap<>();
		for (String s1 : words) {
			if (stringMap.containsKey(s1))
				stringMap.put(s1, stringMap.get(s1) + 1);
			else
				stringMap.put(s1, 1);
		}

		for (Entry<String, Integer> m : stringMap.entrySet())
			System.out.println(m.getKey() + " -> " + m.getValue());

	}
}
