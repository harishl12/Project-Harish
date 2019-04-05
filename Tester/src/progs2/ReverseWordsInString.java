package progs2;

public class ReverseWordsInString {
	public static void main(String[] args) {
		String s = "Sizing FAST.X Upgrade with XtremIO or a 3rd party array to an existing VMAX3";
		String[] arr = s.split("\\s+");
		for (String s1 : arr)
			System.out.print(reverseWord(s1.toString()) + " ");
	}

	public static String reverseWord(String s) {
		char[] c = s.toCharArray();
		char[] rev = new char[s.length()];
		for (int i = c.length; i > 0; i--) {
			rev[s.length() - i] = c[i - 1];

		}
		String reversed = new String(rev);
		return reversed;
	}
}
