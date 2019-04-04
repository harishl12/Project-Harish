package sort;

import java.util.Arrays;

public class Selection {
	public static void main(String[] args) {
		int[] arr = { 34, 23, 5, 6, 77, 8, 2, 1, 86 };
		System.out.println("Given array " + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("Sorted " + Arrays.toString(arr));
	}

	static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index])
					index = j;
			}
			int smallNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallNumber;
		}
	}
}
