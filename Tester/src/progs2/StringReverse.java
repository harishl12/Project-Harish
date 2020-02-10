package progs2;

public class StringReverse {
	public static void main(String[] args) {
		String str = "harish";
		reverse(str);
		System.out.println(str.substring(1));
	}

	static String reverse(String s) {
		if (s.isEmpty())
			return s;
		return reverse(s.substring(1)) + s.charAt(0);
	}
}
