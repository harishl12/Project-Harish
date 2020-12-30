package search;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 70 };
		int search = 51;
		binary(arr, 0, arr.length - 1, search);
	}

	static void binary(int[] arr, int first, int last, int search) {
		int mid = (first + last) / 2;
		while (first <= last) {
			if (arr[mid] < search) {
				first = mid + 1;
			} else if (arr[mid] == search) {
				System.out.println("Element found at " + (mid + 1));
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last)
			System.out.println("Element not found");
	}

}
