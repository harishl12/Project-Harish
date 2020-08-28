package lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaList {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Dada");
		names.add("Shakku");
		names.add("Harish");
		names.add("Amul");
		names.add("Pakku");
		names.add("Sumi");

		names.forEach((n) -> System.out.println(n));

	}
}
