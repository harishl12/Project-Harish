package sort;

import java.util.Arrays;

public class Bubble {
	public static void main(String[] args) {
		int[] arr = { 23, 4, 21, 4, 5, 6, 2, 3, 123, 898 };
		System.out.println("Given array " + Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Sorted " + Arrays.toString(arr));
	}
}
