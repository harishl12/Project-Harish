package programs;

import java.util.Scanner;

public class PalindromeString {
	public static void main(String[] args) {
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String rev = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			rev = rev + input.charAt(i);
		}
		if (rev.equals(input))
			System.out.println("Palindrome");
		else
			System.out.println("Not palindrome");
	}
}
