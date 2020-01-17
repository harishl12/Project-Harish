package geekforgeek.numbers;

import java.util.Scanner;

public class PrimeNumbersInRange {
	public static void main(String[] args) {
		System.out.println("Enter starting number");
		Scanner scan = new Scanner(System.in);
		int start = scan.nextInt();
		System.out.println("Enter upper limit");
		int end = scan.nextInt();
		scan.close();
		System.out.println("Prime numbers in range " + start + " and " + end + " is");
		for (int i = start; i <= end + 1; i++) {
			if (i > 1) {
				int flag = 1;
				for (int j = 2; j < i / 2; j++) {
					if (i % j == 0) {
						flag = 0;
						break;
					}
				}
				if (flag == 1) {
					System.out.println(i);
				}
			}
		}
	}
}
