package stringManipulation;

//Java Program to Find Common Characters in Two Given Strings
public class CommonCharacters {
	public static void main(String[] args) {
		String str1 = "master";
		String str2 = "blaster";
		System.out.println(commonChars(str1, str2));
	}

	static String commonChars(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		StringBuffer commonChars = new StringBuffer();

		String toBeIterated = str1.length() > str2.length() ? str1 : str2;
		String toBeChecked = toBeIterated.equals(str1) ? str2 : str1;

		for (int i = 0; i < toBeIterated.length(); i++) {
			if (toBeChecked.contains(Character.toString(toBeIterated.charAt(i))))
				commonChars.append(Character.toString(toBeIterated.charAt(i)));
		}

		return String.valueOf(commonChars);
	}

}
