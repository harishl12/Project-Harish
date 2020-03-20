package stringManipulation;

//Java Program to Invert Case of Each Char in a String
public class InvertCaseString {
	static String invertCase(String in) {
		char[] ch = in.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isAlphabetic(ch[i])) {
				if (Character.isUpperCase(ch[i]))
					ch[i] = Character.toLowerCase(ch[i]);
				else
					ch[i] = Character.toUpperCase(ch[i]);
			}
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		String in = "Harish Is hEre";
		System.out.println("Given string ->" + in);
		invertCase(in);
		System.out.println("inverted case ->" + invertCase(in));
	}
}
