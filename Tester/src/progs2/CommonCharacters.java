package progs2;

public class CommonCharacters {
	static void printCommon(String s1, String s2) {
		char[] c3 = new char[Math.max(s1.length(), s2.length())];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int k = 0;
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c1[i] == c2[j]) {
					c3[k++] = c1[i];
				}
			}
		}
		System.out.println(c3);
	}

	public static void main(String[] args) {
		String str1 = "abcdefghc";
		String str2 = "ghijklmnaa";
		printCommon(str1, str2);
	}

}
