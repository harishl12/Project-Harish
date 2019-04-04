package programs;

import java.util.Arrays;

public class SmallestFirst {
	public static void main(String[] args) {
		int[] arr = { 23, 125, 6, 3, 777, 23, 5, 22, 10, 73, 94 };
		System.out.println("Given array -> " + Arrays.toString(arr));
		sort(0, arr.length - 1, arr);
		System.out.println("Sorted array -> " + Arrays.toString(arr));

	}

	static void sort(int first, int last, int[] arr) {
		if (first < last) {
			int mid = (first + last) / 2;
			sort(first, mid, arr);
			sort(mid + 1, last, arr);
			merge(first, last, mid, arr);
		}
	}

	static void merge(int first, int last, int mid, int[] arr) {
		int l = mid + 1 - first;
		int r = last - mid;

		int[] leftArray = new int[l];
		int[] rightArray = new int[r];

		for (int i = 0; i < l; i++)
			leftArray[i] = arr[first + i];

		for (int j = 0; j < r; j++)
			rightArray[j] = arr[mid + 1 + j];

		int i = 0;
		int j = 0;
		int k = first;

		while (i < l && j < r) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < l) {
			arr[k] = leftArray[i];
			i++;
			k++;

		}

		while (j < r) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}

	}
}
