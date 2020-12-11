package geekforgeek.strings;

public class SumOfNumbersInString {
	public static void main(String[] args) {
		String str = "Harish17at45";
		int sum = 0;
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c))
				sum = Integer.parseInt(String.valueOf(c)) + sum;
		}
		System.out.println(sum);
	}
}
