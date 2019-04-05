package programs;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arm = 0;
		int temp = num;
		while (num > 0) {
			int r = num % 10;
			arm = arm + r * r * r;
			num = num / 10;
		}
		System.out.println(arm);
		if(arm == temp)
			System.out.println("Armstrong number");
		else
			System.out.println("Not an Armstrong number");
	}
}
