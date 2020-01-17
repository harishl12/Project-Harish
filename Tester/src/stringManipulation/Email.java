package stringManipulation;

public class Email {
	public static void main(String[] args) {
		String email = "harishabc.com";
		String[] arr = email.split("\\.");
		printArray(arr);
//		email.s

	}

	public static void printArray(String[] arr) {
		for (String st : arr)
			System.out.print(st + " ");
	}
}
