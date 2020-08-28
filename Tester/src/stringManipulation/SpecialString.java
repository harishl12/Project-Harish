package stringManipulation;
/*A string is said to be a special string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

For example, given the string , we have the following special substrings: .*/

import java.util.ArrayList;

public class SpecialString {
	public static void main(String[] args) {
		String str = "abcbaba";
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				al.add(str.substring(i, j));
			}
		}
		int count = 0;
		for (String s : al) {
			if (isSpecial(s))
				count++;
		}

		System.out.println(count);

	}

	public static boolean isSpecial(String str) {
		int l = 0;
		int r = str.length() - 1;
		boolean flag = false;
		if (str.length() == 0)
			return false;
		if (str.length() == 1)
			return true;

		while (l < r) {
			if (str.charAt(l) == str.charAt(r))
				flag = true;
			else {
				flag = false;
				return flag;
			}
			l++;
			r--;
		}
		int cc = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				cc++;
			}
			if (cc > 2)
				flag = false;
			else
				flag = true;
		}

		return flag;
	}
}
