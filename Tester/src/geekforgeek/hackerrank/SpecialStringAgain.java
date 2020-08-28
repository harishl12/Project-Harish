package geekforgeek.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SpecialStringAgain {

	public static void main(String[] args) {
		String str = "mnonopoo";
		for (String s1 : printSubstring(str)) {
			System.out.println(s1 + " is " + isSpecial(s1));
		}

	}

	private static boolean isSpecial(String str) {
		boolean flag = false;
		int l = 0;
		int r = str.length() - 1;
		while (l <= r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
			flag = true;
		}

		return flag;

	}

	private static List<String> printSubstring(String str) {
		List<String> al = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				System.out.println(str.substring(i, j));
				al.add(str.substring(i, j));
			}
		}
		return al;
	}

}
