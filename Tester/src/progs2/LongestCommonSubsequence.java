package progs2;

public class LongestCommonSubsequence {

	public static void lcs(String X, String Y, int m, int n) {
		int[][] L = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		int index = L[m][n];
		int temp = index;

		char[] lcs = new char[index + 1];
		lcs[index] = '\u0000';

		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				lcs[index - 1] = X.charAt(i - 1);

				i--;
				j--;
				index--;
			} else if (L[i - 1][j] > L[i][j - 1])
				i--;
			else
				j--;
		}
		System.out.println("LCS is ");
		for (int k = 0; k < temp; k++) {
			System.out.print(lcs[k]);
		}

	}

	public static void main(String[] args) {
		String s1 = "HARRY";
		String s2 = "SALLY";
		int m = s1.length();
		int n = s2.length();
		lcs(s1, s2, m, n);
	}
}