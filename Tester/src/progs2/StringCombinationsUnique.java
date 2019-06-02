package progs2;

public class StringCombinationsUnique {

	public static String sortString(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			for (int j = 1; j < charArray.length; j++) {
				if (charArray[j - 1] > charArray[j]) {
					char temp = charArray[j];
					charArray[j] = charArray[j - 1];
					charArray[j - 1] = temp;
				}
			}
		}

		return String.valueOf(charArray);

	}

	public static String removeDuplicates(String str) {
		char[] charArray = str.toCharArray();
		int dup = 1;
		int ip = 1;
		while (ip != charArray.length) {
			if (charArray[ip] != charArray[ip - 1]) {
				charArray[dup] = charArray[ip];
				dup++;
			}
			ip++;
		}
		str = new String(charArray);
		return String.valueOf(str.substring(0, dup));
	}

	public static void permute(String str, int l, int r) {
		if (l == r) {
			System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String str, int l, int r) {
		char[] array = str.toCharArray();
		char temp = str.charAt(l);
		array[l] = array[r];
		array[r] = temp;

		return String.valueOf(array);
	}

	public static void main(String[] args) {
		String str = "ABCD";
//		System.out.println(sortString(str));
		int n = str.length();
		String s1 = removeDuplicates(sortString(str));
		System.out.println(s1);
		permute(s1, 0, n - 1);
	}
}
