package geekforgeek.strings;

public class AllPermutationsOfString {
	public static void main(String[] args) {
		String str = "ABCD";
		int len = str.length();
		permute(str, 0, len - 1);

	}

	static void permute(String str, int start, int end) {
		if (start == end)
			System.out.println(str);
		else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				permute(str, start + 1, end);
				str = swap(str, start, i);
			}
		}

	}

	static String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		return String.valueOf(arr);

	}
}
