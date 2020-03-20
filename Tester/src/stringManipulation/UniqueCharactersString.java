package stringManipulation;

//Java Program to Find Distinct Characters In Given String
public class UniqueCharactersString {

	static void unique(String str) {
		String ip = str.toUpperCase();
		ip.replaceAll("\\s+", "");
		while (ip.length() > 0) {

			char c = ip.charAt(0);
			if (ip.lastIndexOf(c) == 0)
				System.out.print(c + " ");
			ip = ip.replaceAll(Character.toString(c), "");
		}

	}

	public static void main(String[] args) {
		String str = "here comes harish";
		unique(str);

	}
}
