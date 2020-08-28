package stringManipulation;

import java.util.StringTokenizer;

public class StringTokenDemo {
	public static void main(String[] args) {
		String str = "name = Harish;" + "Age = 33;" + "Country = India;";
		StringTokenizer st = new StringTokenizer(str, "=;");
		while (st.hasMoreTokens()) {
			String key = st.nextToken();
			String val = st.nextToken();
			System.out.println(key + " " + val);

		}
	}
}
