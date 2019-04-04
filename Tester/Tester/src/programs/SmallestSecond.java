package programs;

public class SmallestSecond {
	public static void main(String[] args) {
		int[] arr = { 3, 22, 5, 66, 7, 53, 16, 42, 113 };
		System.out.println("Given array");
		print(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					int temp = arr[index];
					arr[index] = arr[j];
					arr[j] = temp;
				}

			}
		}
		System.out.println("sorted");
		print(arr);
		System.out.println();
		System.out.println("2nd smallest -> "+ arr[1]);

	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
