package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIpAddress {
	public static void main(String[] args) {
		String regex = "[0-255]\\.[0-255]\\.[0-255]\\.[0-255]";
		Pattern pattern = Pattern.compile(regex);
		System.out.println("Enter the IP address to be validated");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Valid IP Address");

		} else
			System.out.println("Invalid IP");

	}

}
