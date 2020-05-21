package geekforgeek.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SherlockAnagrams {
	public static void main(String[] args) {
		String str = "ifailuhkqq";
		List<String> allSubstrings = new ArrayList<String>();
		List<String> anagrams = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <= str.length() - i; j++) {
				allSubstrings.add(str.substring(i, i + j));
			}
		}
		System.out.println(allSubstrings);
		for (int i = 0; i < allSubstrings.size(); i++) {
			for (int j = i + 1; j < allSubstrings.size(); j++) {
				String first = allSubstrings.get(i);
				String second = allSubstrings.get(j);
				System.out.println(first + "----" + second);
				if (first.length() == second.length() && isAnagram(first, second))
					anagrams.add(first);
			}

		}
		System.out.println(anagrams);
	}

	public static boolean isAnagram(String str1, String str2) {
		boolean anagram = false;
		char[] ch1 = str1.toLowerCase().toCharArray();
		if (str1.length() != str2.length())
			return false;
		if (str1.length() == 0)
			return false;
		StringBuffer sb = new StringBuffer(str2.toLowerCase());

		for (int i = 0; i < ch1.length; i++) {
			int index = sb.indexOf("" + ch1[i]);
			if (index == -1)
				return false;
			else
				sb.deleteCharAt(index);
		}
		if (sb.length() == 0)
			return anagram = true;
		else
			return false;

	}
}
