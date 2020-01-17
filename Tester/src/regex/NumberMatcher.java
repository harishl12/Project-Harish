package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberMatcher {
	public static void main(String[] args) {
		String mail = "abc934ef8comghrenjjfre";
		Pattern pattern = Pattern.compile("e");
		Matcher match = pattern.matcher(mail);
		while (match.find()) {
			System.out.println(match.group());
			System.out.println(match.end());
			System.out.println(match.groupCount());
		}
	}
}
