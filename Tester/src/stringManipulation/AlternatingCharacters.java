package stringManipulation;

public class AlternatingCharacters {
	public static void main(String[] args) {
		String str = "AAAA";
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1))
				count++;
		}
		System.out.println(count);
	}

}
