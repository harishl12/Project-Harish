package practice;

public class SortSelection {

	static void sort(int[] arr) {
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

	public static void main(String[] args) {
		int[] arr = { 2, 9, 4, 3, 7, 5, 6, 1, 8, 0 };
		sort(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}

}
