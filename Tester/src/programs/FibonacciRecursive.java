package programs;

import java.util.Scanner;

public class FibonacciRecursive {
	public static void main(String[] args) {
		int n1 = 0;
		int n2 = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Number in series ");
		int in = scan.nextInt();
		System.out.print(n1 + " " + n2 + " ");
		printFibonacci(n1, n2, in);

	}

	private static void printFibonacci(int n1, int n2, int in) {
		if (in > 2) {
			int n3 = n1 + n2;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
			in--;
			printFibonacci(n1, n2, in);
			
		}
	}
}
