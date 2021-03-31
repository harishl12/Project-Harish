package test;

import java.util.Arrays;

public class QuickS {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 3, 6, 73, 12, 34, 6, 78, 99 };
		quickSort(0, arr.length - 1, arr);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int beg, int last, int[] arr) {
		if (beg < last) {
			int pivot = partition(beg, last, arr);
			quickSort(beg, pivot - 1, arr);
			quickSort(pivot + 1, last, arr);
		}
	}

	static int partition(int beg, int last, int[] arr) {

		int pivot = arr[last];
		int i = beg - 1;

		for (int j = beg; j < last; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[last];
		arr[last] = temp;
		return i + 1;
	}
}
