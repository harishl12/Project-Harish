package sort;

public class QuickSort {

	int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);

			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);
		}
	}

	void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		System.out.println("Before sorting");
		qs.printArray(arr);
		qs.sort(arr, 0, n - 1);
		System.out.println();
		System.out.println("After sorting");
		qs.printArray(arr);

	}
}
