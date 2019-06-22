package stringManipulation;

/*I/P : "hello how are you"
o/p : uoy how are olleh*/

public class Str01 {
	public static void main(String[] args) {
		String s = "hello how are you";
		System.out.println(s);

		String[] s1 = s.split("\\s+");
		String temp = s1[0];
		s1[0] = s1[s1.length - 1];
		s1[s1.length - 1] = temp;

		for (int i = 0; i < s1.length; i++) {
			if (i == 0 || i == s1.length - 1) {
				char[] c1 = s1[i].toCharArray();
				for (int j = c1.length - 1; j >= 0; j--) {
					System.out.print(c1[j]);
				}
				System.out.print(" ");
			} else {
				System.out.print(s1[i] + " ");
			}
		}
	}
}
