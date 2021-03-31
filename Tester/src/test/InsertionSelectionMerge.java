package test;

import java.util.Arrays;

public class InsertionSelectionMerge {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 3, 6, 73, 12, 34, 6, 78, 99 };
//		int[] arr = { 34, 23, 5, 6, 77, 8, 2, 1, 86 };
//		insertion(arr);
//		selection(arr);
		msort(0, arr.length-1, arr);
		System.out.println(Arrays.toString(arr));
	}

	static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		System.out.println(Arrays.toString(arr));
	}

	static void selection(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index])
					index = j;
			}
			int smallNum = arr[index];
			arr[index] = arr[i];
			arr[i] = smallNum;

		}
		System.out.println(Arrays.toString(arr));
	}

	static void merge(int beg, int mid, int last, int[] arr) {
		int l = mid + 1 - beg;
		int r = last - mid;

		int[] left = new int[l];
		int[] right = new int[r];

		for (int i = 0; i < l; ++i) {
			left[i] = arr[beg + i];
		}

		for (int j = 0; j < r; ++j) {
			right[j] = arr[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = beg;

		while (i < l && j < r) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < l) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < r) {
			arr[k] = right[j];
			j++;
			k++;
		}

	}

	static void msort(int beg, int last, int[] arr) {
		if (beg < last) {
			int mid = (beg + last) / 2;
			msort(beg, mid, arr);
			msort(mid + 1, last, arr);
			merge(beg, mid, last, arr);
		}
	}

}
