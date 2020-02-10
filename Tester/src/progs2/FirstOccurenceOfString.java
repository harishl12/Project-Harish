package progs2;

public class FirstOccurenceOfString {
	public static void main(String[] args) {
		String s1 = "first appearance of string";
		String s2 = "app";
		System.out.println(s1.indexOf(s2));
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		boolean match = false;
		int first = 0;
		for (int i = 0; i < c1.length; i++) {
			if (s2.toCharArray()[0] == c1[i] && !match) {
				System.out.println(c1[i] + "->" + i);
				first = i;
				int len = c2.length;
				int j = 0;
				while (len > 0) {
					if (c1[i++] == c2[j++])
						match = true;
					else
						match = false;
					len--;

				}
				i = first;
			}
		}
		if (match)
			System.out.println("First occurence -> " + first);
		else
			System.out.println("String not found");
	}
}
