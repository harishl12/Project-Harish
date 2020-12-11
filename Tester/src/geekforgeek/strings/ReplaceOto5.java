package geekforgeek.strings;

public class ReplaceOto5 {
	public static void main(String[] args) {
		int num = 1004;
		String s = "";
		for (char c : String.valueOf(num).toCharArray()) {
			if (Character.isDigit(c))
				if (c == '0')
					s = s + '5';
				else
					s = s + c;
		}
		System.out.println(s);
	}
}
