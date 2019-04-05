package regex;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
	public static void main(String[] args) {
		// Console console = System.console();
		Scanner scan = new Scanner(System.in);

		// if (console == null) {
		// System.out.println("Console not found");
		// System.exit(1);
		// }
		while (true) {
			System.out.println("Enter regex");
			String regex = scan.nextLine();
			System.out.println("Enter input string to search");
			String sentence = scan.nextLine();

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(sentence);

			boolean found = false;

			while (matcher.find()) {
				System.out.println("I found String \"" + matcher.group() + "\" starting at index " + matcher.start()
						+ " ending at " + matcher.end());
				found = true;
			}

			if (!found) {
				System.out.println("Pattern not found");
			}
		}
	}
}
