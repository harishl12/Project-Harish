package practice;

public class Insertion {

	static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	/*
	 * for (int i = 1; i < arr.length; i++) { int key = arr[i]; int j = i - 1; while
	 * (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j = j - 1; } arr[j + 1] =
	 * key; } }
	 */

	public static void main(String[] args) {
		int[] arr = { 5, 2, 7, 0, 9, 1, 6, 3, 8, 4 };
		sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
