package sort;

public class Merge {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 3, 6, 73, 12, 34, 6, 78, 99 };
		Merge m = new Merge();
		System.out.println("Given Array");
		m.printArray(arr);
		System.out.println();
		m.sort(0, arr.length - 1, arr);
		System.out.println("Sorted array");
		m.printArray(arr);
	}

	void mergeSort(int beg, int mid, int last, int[] arr) {
		int l = mid + 1 - beg;
		int r = last - mid;

		int[] leftArray = new int[l];
		int[] rightArray = new int[r];

		for (int i = 0; i < l; ++i) {
			leftArray[i] = arr[beg + i];
		}

		for (int j = 0; j < r; ++j) {
			rightArray[j] = arr[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = beg;

		while (i < l && j < r) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < l) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < r) {
			arr[k] = rightArray[j];
			k++;
			j++;
		}

	}

	void sort(int beg, int last, int[] arr) {
		if (beg < last) {
			int mid = (beg + last) / 2;
			sort(beg, mid, arr);
			sort(mid + 1, last, arr);
			mergeSort(beg, mid, last, arr);
		}
	}

	void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
