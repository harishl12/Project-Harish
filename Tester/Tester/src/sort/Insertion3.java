package sort;

import java.util.Arrays;

public class Insertion3 {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 3, 6, 73, 12, 34, 6, 78, 99 };
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		System.out.println(Arrays.toString(arr));
	}
}
