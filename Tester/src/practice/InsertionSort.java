package practice;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 6, 1, 8, 4, 0, 6 };
		printArray(arr);
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;

		}
		System.out.println("Sorted Array ");
		printArray(arr);
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
