package progs2;

import java.util.Arrays;

public class ZigZagArray {
	static void zigZag(int[] arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (flag) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i + 1] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 1, 2, 3, 7, 8, 0, 9 };
		System.out.println("Given array ->" + Arrays.toString(arr));
		zigZag(arr);
		System.out.println("zigZag array ->" + Arrays.toString(arr));
	}
}
