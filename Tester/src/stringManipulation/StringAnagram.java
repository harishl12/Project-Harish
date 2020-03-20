package stringManipulation;

//ava Program to Check if Two Strings are Anagram
public class StringAnagram {

	static boolean isAnagram(String str1, String str2) {
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

	public static void main(String[] args) {
		String str1 = "Listen";
		String str2 = "Silelt";
		if (isAnagram(str1, str2))
			System.out.println(str1 + ", " + str2 + " are Anagrams");
		else
			System.out.println(str1 + ", " + str2 + " are not Anagrams");

	}
}
