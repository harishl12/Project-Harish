package practice;

public class StringTest {
	public static void main(String[] args) {
		String s = "aaabbbcccdda";
		int count = 1;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			for (j = i + 1; j < s.length() && s.charAt(i) == s.charAt(j); j++) {
				count++;
			}
			System.out.print(s.charAt(i) + "" + count);
			count = 1;
			i = j - 1;
		}
	}
}
