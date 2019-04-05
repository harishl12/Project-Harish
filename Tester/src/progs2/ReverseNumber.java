package progs2;

public class ReverseNumber {
	public static void main(String[] args) {
		int num = 1234;
		int num2 = 0;
		while (num > 0) {
			num2 = (num2 * 10) + num % 10;
			num = num / 10;
		}
		System.out.println(num2);
	}
}
