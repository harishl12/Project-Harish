package search;

import java.util.Scanner;

public class LinearSearch {
	public static void main(String[] args) {
		boolean found = false;
		System.out.println("Enter the array size");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println(" Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the search elements");
		int search = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == search) {
				System.out.println("Element found at " + (i + 1) + " position");
				found = true;
			}
		}
		if (!found)
			System.out.println("Element not found ");

	}
}
