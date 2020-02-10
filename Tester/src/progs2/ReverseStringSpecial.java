package progs2;

public class ReverseStringSpecial {
	static void reverse(char[] c) {
		int l = 0;
		int r = c.length - 1;
		while (l < r) {
			if (!Character.isAlphabetic(c[l]) || !Character.isDigit(c[l]))
				l++;
			else if (!Character.isAlphabetic(c[r]) || !Character.isDigit(c[r]))
				r--;
			else {
				char temp = c[l];
				c[l] = c[r];
				c[r] = temp;
				l++;
				r--;
			}
		}
	}

	public static void main(String[] args) {
		String str = "h1ar$%@ishj!23D$*";
		char[] c = str.toCharArray();
		reverse(c);
		String reversed = new String(c);
		System.out.println(reversed);
	}
}
