package practice;

import java.util.Arrays;

public class QuickSort {

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 6, 2, 4, 3, 9, 8, 3, 7 };
		int n = arr.length;
		sort(arr, 0, n - 1);
		System.out.println(Arrays.toString(arr));
	}

}
