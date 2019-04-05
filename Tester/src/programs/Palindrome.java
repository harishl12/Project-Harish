package programs;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		int num = 12345;
		System.out.println(" Enter the number ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = n;
		int sum = 0;
		while (temp > 0) {
			int r = temp % 10;
			sum = (sum * 10) + r;
			temp = temp / 10;
		}
		if (sum == n)
			System.out.println("Palindrome");
		else
			System.out.println("Not palindrome");
	}
}
