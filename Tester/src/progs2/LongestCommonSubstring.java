package progs2;

public class LongestCommonSubstring {

	static void printLCS(String x, String y, int m, int n) {
		int len = 0;
		int[][] LCSuff = new int[m + 1][n + 1];

		int row = 0;
		int col = 0;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCSuff[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
					if (len < LCSuff[i][j]) {
						len = LCSuff[i][j];
						row = i;
						col = j;
					}
				} else
					LCSuff[i][j] = 0;
			}
		}
		if (len == 0) {
			System.out.println("No Common substring");
			return;
		}

		String resultStr = "";
		while (LCSuff[row][col] != 0) {
			resultStr = x.charAt(row - 1) + resultStr;
			--len;
			row--;
			col--;
		}
		System.out.println(resultStr);
	}

	public static void main(String[] args) {
//		String x = "OldSite:GeeksforGeeks.org";
//		String y = "NewSite:GeeksQuiz.com";
		String x = "habc";
		String y = "yabd";
		int m = x.length();
		int n = y.length();
		printLCS(x, y, m, n);
	}
}
