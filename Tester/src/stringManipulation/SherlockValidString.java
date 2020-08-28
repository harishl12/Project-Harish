package stringManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SherlockValidString {
	public static void main(String[] args) {
		String str = "abcdefghhgfedecba";
		String GOOD = "YES";
		String BAD = "NO";
		int[] allChars = new int[26];
		for (int i = 0; i < str.length(); i++) {
			allChars[str.charAt(i) - 'a']++;
		}
		Arrays.sort(allChars);
		System.out.println(Arrays.toString(allChars));
		int i = 0;
		while (allChars[i] == 0)
			i++;
		int min = allChars[i];
		int max = allChars[25];
		String ret = BAD;
		if (max - min == 0) {
			ret = GOOD;
			System.out.println(ret);
		} else {
			if (((max - min) == 1 && max > allChars[24]) || (min == 1) && allChars[i + 1] == max) {
				ret = GOOD;
				System.out.println(ret);
			}
		}

	}
}
