package programs;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		int n1 = 0;
		int n2 = 1;
		int n3;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Number of fibonacci series");
		int num = input.nextInt();
		System.out.print(n1 + " " + n2 + " ");
		for(int i = 2;i < num;i++) {
			n3 = n1 + n2;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
		}
	}
}
