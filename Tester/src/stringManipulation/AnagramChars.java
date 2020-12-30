package stringManipulation;

public class AnagramChars {
	public static boolean isAnagram(String s1, String s2) {
		int[] freq = new int[26];
		int sum = 0;
		for (char c1 : s1.toLowerCase().toCharArray())
			freq[c1 - 97]++;
		for (char c2 : s2.toLowerCase().toCharArray())
			freq[c2 - 97]--;

		for (int i : freq) {
			if (i != 0)
				return false;
			sum = sum + i;
		}
		if (sum == 0)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		String s1 = "Army";
		String s2 = "mary";
		if (isAnagram(s1, s2))
			System.out.println("is Anagram");
		else
			System.out.println("Not Anagram");

	}
}
