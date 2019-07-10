package practice;

//Program to swap two Strings without temp

public class SwapStrings {
	public static void main(String[] args) {
		String s1 = "Harish";
		String s2 = "Amulya";

		System.out.println("s1 ->" + s1);
		System.out.println("s2 ->" + s2);

		s2 = s1 + s2;
		s1 = s2.substring(s1.length(), s2.length());
		s2 = s2.substring(0, s1.length());

		System.out.println("s1 ->" + s1);
		System.out.println("s2 ->" + s2);
	}

}
