package programs;

public class LargestThird {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 16, 32, 45, 6, 22, 34, 88, 9, 15 };
		System.out.println("Given array");
		printArray(arr);
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		System.out.println();
		System.out.println("sorted");
		printArray(arr);
		System.out.println();
		System.out.println("Third largest -> " + arr[arr.length - 3]);
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
