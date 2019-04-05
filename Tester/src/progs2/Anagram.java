package progs2;

public class Anagram {
	public static void main(String[] args) {
		String s1 = "arMy";
		String s2 = "marY";
		if (isAnagram(s1, s2))
			System.out.println("Strings " + s1 + " " + s2 + " are Anagrams");
		else
			System.out.println("Strings " + s1 + " " + s2 + " are not Anagrams");
	}

	public static boolean isAnagram(String s1, String s2) {
		boolean anagram = false;
		if (s1.length() != s2.length() || s1 == null || s2 == null)
			return anagram;

		char[] c1 = s1.toLowerCase().toCharArray();
		StringBuilder sb = new StringBuilder(s2.toLowerCase());

		System.out.println(sb);
		for (char c : c1) {
			int index = sb.indexOf("" + c);
			// System.out.println(index);
			if (index != -1)
				sb.deleteCharAt(index);
			else
				return false;
		}
		if (sb.length() == 0)
			anagram = true;
		else
			anagram = false;

		return anagram;
	}
}
