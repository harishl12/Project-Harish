package numbers;

import java.util.Arrays;

public class IntToBinary {
	public static void main(String[] args) {
		String str = "ABCD";
		int count = (int) Math.pow(2, str.length() - 1);
		String[] arr = binaryRep(count);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == '0') {
					System.out.print(str.charAt(j));
				} else {
					System.out.print(" " + str.charAt(j));
				}
			}
			System.out.println();
		}

	}

	public static String leadingZeroes(String num, int length) {
		String n2 = num;
		while (n2.length() != length) {
			n2 = "0" + n2;
			n2.length();
		}

		return n2;
	}

	public static String[] binaryRep(int d) {
		String b[] = new String[d];
		for (int i = 0; i < d; i++) {
			String n1 = Integer.toBinaryString(i);
			n1 = leadingZeroes(n1, 4);
//			System.out.println(n1);
			b[i] = n1;
		}
		return b;
	}
}
