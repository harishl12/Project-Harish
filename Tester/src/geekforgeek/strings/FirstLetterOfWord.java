package geekforgeek.strings;

public class FirstLetterOfWord {
	public static void main(String[] args) {
		String str = "Here comes harish";
		String[] strArray = str.split("\\s+");

		char[] ch = new char[str.split("\\s+").length];
		for (int i = 0; i < strArray.length; i++) {
			ch[i] = strArray[i].charAt(0);
		}
		System.out.println(new String(ch));
		System.out.println(ch);
	}

}
