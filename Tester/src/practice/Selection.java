package practice;

public class Selection {
	public static void main(String[] args) {
//		int[] arr = { 5, 3, 1, 7, 2, 9, 0, 4, 8, 6 };
		int[] arr = { 34, 23, 5, 6, 77, 8, 2, 1, 86 };
		dispay(arr);
//		selection(arr);
//		dispay(arr);
		select(arr);
		dispay(arr);
	}

	static void dispay(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void select(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min_idx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_idx])
					min_idx = j;
				int min_num = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = min_num;
			}
		}
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
