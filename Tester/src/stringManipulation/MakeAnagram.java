package stringManipulation;

public class MakeAnagram {
	public static void main(String[] args) {
		String s1 = "mary";
		String s2 = "ArMy";
		/*
		 * MakeAnagram m = new MakeAnagram(); if (m.isAnagram(s1, s2))
		 * System.out.println("Anagram"); else System.out.println("Not Anagram");
		 */
		System.out.println(sort(s1));
		System.out.println(makeAnagram(s1, s2));

	}

	public static int makeAnagram(String s1, String s2) {
		int count = 0;
		int[] letters = new int[26];
		for (char c : s1.toLowerCase().toCharArray())
			letters[c - 'a']++;
		for (char c : s2.toLowerCase().toCharArray())
			letters[c - 'a']--;
		for (int i : letters)
			count += Math.abs(i);

		return count;
	}

	public static String sort(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			for (int j = 1; j < ch.length; j++) {
				if (ch[j - 1] > ch[j]) {
					char temp = ch[j - 1];
					ch[j - 1] = ch[j];
					ch[j] = temp;
				}
			}
		}
		return String.valueOf(ch);

	}

	public boolean isAnagram(String s1, String s2) {
		char[] c1 = s1.toLowerCase().toCharArray();
		StringBuffer sb2 = new StringBuffer(s2.toLowerCase());
		if (s1.length() != s2.length())
			return false;
		if (s1.length() == 0)
			return false;
		for (int i = 0; i < c1.length; i++) {
			int index = sb2.indexOf("" + c1[i]);
			if (index == -1)
				return false;
			sb2.deleteCharAt(index);
		}
		if (sb2.length() == 0)
			return true;
		else
			return false;
	}

}
