package progs2;

//return only positive numbers from array
public class ReturnPositiveArray {
	public static void main(String[] args) {
		int[] arr = { 1, 1, -1, 2, 3, 4, -2, 4 };
		int k = 0;
		int[] pos = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				pos[k++] = arr[i];
			}
		}

		for (int j = 0; j < k; j++) {
			System.out.println(pos[j]);
		}

	}
}
