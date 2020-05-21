package progs2;

public class ReturnNonNegativeArray {
	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static void nonNegative(int[] arr) {
		int[] neg = new int[arr.length];
		int curIdx = 0, curLen = 0;
		int maxIdx = 0, maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				curLen++;
				if (curLen == 1)
					curIdx = i;
			} else {
				if (curLen > maxLen) {
					maxIdx = curIdx;
					maxLen = curLen;
				}
				curLen = 0;

			}
		}

		for (int j = curIdx; j < maxLen; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println(maxIdx + " " + maxLen);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, -1, 2, 3, 4, -2, 4 };
		print(arr);
		nonNegative(arr);
		print(arr);
	}
}
