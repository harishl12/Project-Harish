package programs;

public class LargestSecond {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 2, 66, 11, 22, 44, 98, 33, 21, 42 };
		System.out.println("Given array ");
		print(arr);
		System.out.println();
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;

			}
			arr[j + 1] = key;
		}
		System.out.println("sorted");
		print(arr);
		System.out.println();
		System.out.println("2nd largest -> " + arr[arr.length - 2]);
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
