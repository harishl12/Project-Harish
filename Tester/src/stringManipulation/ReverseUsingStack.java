package stringManipulation;

import java.util.Stack;

//Java Program to Reverse a String Using Stack
public class ReverseUsingStack {
	static String reverse(String in) {
		String op = new String();
		char[] ch = in.toCharArray();
		Stack<Character> st = new Stack<Character>();
		for (Character c : ch)
			st.push(c);
		while (!st.isEmpty())
			op += st.pop();
		return op;
	}

	public static void main(String[] args) {
		String in = "Harish";
		System.out.println(reverse(in));

	}
}
