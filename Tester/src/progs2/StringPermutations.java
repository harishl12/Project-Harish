package progs2;

public class StringPermutations {

	public void permute(String a, int l, int r) {
		if (l == r) {
			System.out.println(a);
		} else {
			for (int i = l; i <= r; i++) {
				a = swap(a, l, i);
				permute(a, l + 1, r);
				a = swap(a, l, i);
			}
		}

	}

	public static String swap(String a, int l, int r) {
		char[] c = a.toCharArray();

		char temp = a.charAt(l);
		c[l] = c[r];
		c[r] = temp;

		return String.valueOf(c);

	}

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		StringPermutations sp = new StringPermutations();
		sp.permute(str, 0, n - 1);

	}
}
