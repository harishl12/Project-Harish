package progs2;

import java.util.HashSet;

public class LongestSubstring {

	static String LongestSubString(String str) {

		String LongessubStrOverall = "";
		String LongestSubstr = "";
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (set.contains(c)) {
				LongestSubstr = "";
				set.clear();
			}
			LongestSubstr += c;
			set.add(c);
			if (LongestSubstr.length() > LongessubStrOverall.length())
				LongessubStrOverall = LongestSubstr;
		}

		return LongessubStrOverall;
	}

	public static void main(String[] args) {
		String str = "stackoverflow";
		System.out.println("Longest substring is " + LongestSubString(str));
	}
}
