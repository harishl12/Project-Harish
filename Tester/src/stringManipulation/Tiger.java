package stringManipulation;

/*input: the white tiger was bigger than the brown tiger
output: 
the 3
was 3

than 4

brown 5
tiger 5
white 5**/

public class Tiger {
	public static void main(String[] args) {
		String input = "the white tiger was bigger than the brown tiger";
		System.out.println("Given -> " + input);

		String[] arr = input.split("\\s++");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].charAt(0) < arr[j - 1].charAt(0) && arr[j].length() == arr[j - 1].length()) {
					String temp1 = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp1;
				}

				if (arr[j].length() < arr[j - 1].length()) {
					String temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;

				}

			}
		}

		/*
		 * for (int i = 0; i < arr.length - 1; i++) { if (!arr[i].equals(arr[i + 1])) {
		 * System.out.println(arr[i] + " " + arr[i].length()); } }
		 */

		int j = removeDuplicates(arr, arr.length);

	}

	static int removeDuplicates(String[] arr, int length) {
		int j = 0;
		for(int i=1;i<length;i++) {
			if(a1])
		}
		return j;

	}
}
