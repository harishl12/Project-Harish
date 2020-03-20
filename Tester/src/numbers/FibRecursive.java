package numbers;

import java.util.Scanner;

public class FibRecursive {
	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.print(fib(i) + " ");
		}

	}
}
