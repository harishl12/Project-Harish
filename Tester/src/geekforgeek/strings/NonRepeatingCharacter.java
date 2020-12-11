package geekforgeek.strings;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class NonRepeatingCharacter {

	public static LinkedHashMap<Character, Integer> getCharCount(String str) {
		LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();
		if (str.length() == 0) {
			System.out.println("Empty string");
			return null;
		}
		for (char c : str.toCharArray()) {
			if (charCountMap.containsKey(c))
				charCountMap.put(c, charCountMap.get(c) + 1);
			else
				charCountMap.put(c, 1);
		}

		return charCountMap;
	}

	public static void main(String[] args) {
		String str = "zxvczbtxyzvy";
		LinkedHashMap<Character, Integer> charCount = getCharCount(str);
		for (Entry<Character, Integer> map : charCount.entrySet()) {
			if (map.getValue() == 1) {
				System.out.println("First non repeated character is " + map.getKey());
				break;
			}
		}
	}
}
