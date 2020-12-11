package geekforgeek.strings;

import java.util.Arrays;

public class PrintAnagramsTogether {

	static boolean isAnagram(String s1, String s2) {
		int count = 0;
		int[] letters = new int[26];
		for (char c : s1.toLowerCase().toCharArray())
			letters[c - 'a']++;
//		System.out.println(Arrays.toString(letters));
		for (char c : s2.toLowerCase().toCharArray())
			letters[c - 'a']--;
//		System.out.println(Arrays.toString(letters));
		for (int i : letters)
			count = count + Math.abs(i);

		return count == 0;
	}

	public static void main(String[] args) {
		String[] words = { "act", "god", "cat", "dog", "tac" };
		/*
		 * String s1 = "Acte"; String s2 = "catw"; if (isAnagram(s1, s2))
		 * System.out.println("Anagram"); else System.out.println("Not anagram");
		 */
		for (int i = 0; i < words.length - 1; i++) {
			if (isAnagram(words[i], words[i + 1]))
				System.out.println(words[i] + " " + words[i + 1]);

		}

	}
}
