package numbers;

import java.util.Arrays;

public class ReverseWithoutArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int mid = arr.length / 2;
		int i = 0;
		int j = arr.length - 1;

		while (i < mid && j > mid) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		System.out.println(Arrays.toString(arr));
	}
}
