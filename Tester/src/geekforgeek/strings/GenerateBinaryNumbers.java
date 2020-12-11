package geekforgeek.strings;

public class GenerateBinaryNumbers {

	static String getBinary(int x) {
		String s = "";
		if (x == 0)
			return "0";
		while (x != 0) {
			s = (x % 2) + s;
			x = x / 2;
		}
		return s;
	}

	static void printBinary(int n) {
		for (int i = 0; i <= n; i++)
			System.out.print(getBinary(i) + " ");
	}

	public static void main(String[] args) {
		int n = 12;
		printBinary(12);
	}
}
