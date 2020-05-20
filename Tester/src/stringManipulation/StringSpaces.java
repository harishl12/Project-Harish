package stringManipulation;

import java.util.*;

public class StringSpaces {
	// Java program to print all strings that can be
	// made by placing spaces

	static void printSubsequences(String s) {
		char[] str = s.toCharArray();
		int n = str.length;
		int opsize = (int) (Math.pow(2, n - 1));

		for (int counter = 0; counter < opsize; counter++) {
			for (int j = 0; j < n; j++) {

				System.out.print(str[j]);
				if ((counter & (1 << j)) > 0)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	// Driver code
	public static void main(String[] args) {
		String str = "ABC";
		printSubsequences(str);
	}
}

/* This code is contributed by Mr. Somesh Awasthi */
