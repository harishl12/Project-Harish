package progs2;

import java.util.Scanner;

public class RecursiveFib {

	static int fib(int n) {
		if (n == 1 || n == 0)
			return n;
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of fibonacci sequence");
//		Scanner scan = new Scanner(System.in);
//		int num = scan.nextInt();
		int n = 20;
		System.out.println(fib(n));
		for (int i = 0; i < n; i++)
			System.out.print(fib(i) + " ");

	}

}
