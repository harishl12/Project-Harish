package stringManipulation;

//Java Program to Remove Duplicate Characters From Word Using Collection Concept
public class RemoveDuplicatesString {

	static String removeDuplicate(String str) {
		String uniq = "";
		while (str.length() > 0) {
			char c = str.charAt(0);
			if (str.lastIndexOf(c) != 0)
				uniq += c;
			if (str.lastIndexOf(c) == 0)
				uniq += c;
			str = str.replaceAll(Character.toString(c), "");
		}
		return uniq;
	}

	public static void main(String[] args) {
		String str = "herecomesharish";
		System.out.println(removeDuplicate(str));
	}
}
