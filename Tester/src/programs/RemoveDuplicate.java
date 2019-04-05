package programs;

import java.util.Arrays;

public class RemoveDuplicate {
	public static void main(String[] args) {
		int[] arr = { 30, 50, 10, 50, 20, 30, 70, 80, 40, 60, 10 };
		System.out.println("Given array ");
		printArray(arr);
		System.out.println();
		System.out.println("Sorted ");
		insertion(arr);
		printArray(arr);
		int n = removeDuplicates(arr);
		System.out.println();
		for (int i = 0; i < n - 1; i++)
			System.out.print(arr[i] + " ");
	}

	static int removeDuplicates(int[] arr) {
		int[] temp = new int[arr.length];
		int n = arr.length;
		int j = 0;
		if (arr.length != 0) {
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] != arr[i + 1]) {
					temp[j++] = arr[i];
				}
			}
			temp[j++] = arr[n - 1];
			for (int i = 0; i < j; i++) {
				arr[i] = temp[i];
			}
			/*
			 * for (int j1 = 0; j1 < temp.length; j1++) { arr[j1] = temp[j1]; }
			 */
		}
		return j;

	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

}