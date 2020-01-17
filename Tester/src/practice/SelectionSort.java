package practice;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 2, 3, 5, 22, 0, 9, 7 };
		display(arr);
		selection(arr);
		display(arr);

	}

	public static void display(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void selection(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int smaller_index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smaller_index])
					smaller_index = j;
				int smaller_number = arr[smaller_index];
				arr[smaller_index] = arr[i];
				arr[i] = smaller_number;
			}
		}

	}
}
