package progs2;

public class LongestRepeatedSubstring {

	static String printLongestRepeatedSubst(String str) {
		int n = str.length();
		int[][] LCS = new int[n + 1][n + 1];
		int i;
		int index = 0;
		String result = "";
		int len = 0;

		for (i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (str.charAt(i - 1) == str.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
					if (LCS[i][j] > len) {
						len = LCS[i][j];
						index = Math.max(index, i);
					} else
						LCS[i][j] = 0;
				}
			}

		}

		if (len > 0) {
			for (i = index - len + 1; i <= index; i++) {
				result = result + str.charAt(i-1);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(printLongestRepeatedSubst(str));
	}
}
