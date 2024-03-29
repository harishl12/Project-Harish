package progs2;

import java.util.Arrays;

public class RemoveDuplicateElement {
	public static int removeDuplicates(int[] arr, int arrayLength) {
		// int length = 0;

		if (arrayLength == 0 || arrayLength == 1)
			return arrayLength;

		sort(arr);
		System.out.println(Arrays.toString(arr));
		int j = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] != arr[i]) {
				arr[j++] = arr[i];
				// System.out.println(arr[j]);
			}
		}

		return j;
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[j - 1] > a[j]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 3, 4, 2, 3, 6, 7, 4, 1, 9, 8, 5 };
		System.out.println(removeDuplicates(a, a.length));
		int j = removeDuplicates(a, a.length);
		for (int i = 0; i < j; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
