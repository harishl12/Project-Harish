package programs;

import java.util.Arrays;

public class LargestFirst {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 3, 77, 44, 22, 12, 41, 75 };
		System.out.println("Given array = " + Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("sorted = " + Arrays.toString(arr));
		System.out.println("Largest -> " + arr[arr.length - 1]);
	}
}
