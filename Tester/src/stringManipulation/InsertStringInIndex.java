package stringManipulation;

//Insert a String into Another String at given index
public class InsertStringInIndex {
	static String insertIndex(String str1, String str2, int index) {
		StringBuffer sb = new StringBuffer();
		if (str1 == null || str2 == null || index > str1.length() - 1) {
			System.out.println("invalid input");
			return null;
		}
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int len = ch1.length + ch2.length;
		for (int i = 0; i < len; i++) {
			if (i == index) {
				sb.append(str2);
				len = len - ch2.length;
			}
			sb.append(ch1[i]);
		}

		return String.valueOf(sb);
	}

	public static void main(String[] args) {
		String str1 = "Listen";
		String str2 = "Silelt";
		System.out.println(insertIndex(str1, str2, 3));
	}
}
