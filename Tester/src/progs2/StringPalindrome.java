package progs2;

public class StringPalindrome {
	public static void main(String[] args) {
		String s = "Malalaym";
		if (s.toLowerCase().equals(reverse(s))) {
			System.out.println("String " + s + " is palindrome");
		} else
			System.out.println("String " + s + " is not an palindrome");

	}

	public static String reverse(String s) {
		char[] arr = s.toLowerCase().toCharArray();
		char[] revArray = new char[s.length()];

		for (int i = arr.length; i > 0; i--) {
			revArray[arr.length - i] = arr[i - 1];
		}
		String reversed = new String(revArray);
		return reversed;
	}
}
