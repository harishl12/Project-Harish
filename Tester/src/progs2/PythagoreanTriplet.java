package progs2;

import java.util.Arrays;

public class PythagoreanTriplet {
	static void usingFor(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					int h = arr[i];
					int o = arr[j];
					int a = arr[k];
					if ((h * h == a * a + o * o)) {
						System.out.println(h + " " + a + " " + o);
						return;
					}
				}
			}
		}
	}

	static boolean printPythagorean(int[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		int n = arr.length - 1;

		for (int i1 = n - 1; i1 >= 2; i1++) {
			int l = 0;
			int r = i1 - 1;
			while (l < r) {
				if (arr[l] * arr[l] + arr[r] * arr[r] == arr[i1] * arr[i1]) {
					System.out.println("Pythagorean nums are " + arr[l] + " " + arr[r] + " " + arr[i1]);
					return true;
				}
				if (arr[l] * arr[l] + arr[r] * arr[r] > arr[i1] * arr[i1])
					r--;
				else
					l++;

			}
		}
		if (flag)
			System.out.println("Pythagorean");
		else
			System.out.println("No pythagorean");
		System.out.println(Arrays.toString(arr));
		return flag;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 6, 5 };
		usingFor(arr);
		printPythagorean(arr);
	}
}
