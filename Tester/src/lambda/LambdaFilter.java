package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LambdaFilter {
	public static void main(String[] args) {
		List<Phones> list = new ArrayList<Phones>();
		list.add(new Phones(32, "Apple", 2500, "8 S"));
		list.add(new Phones(57, "Samsung", 2005, "S6"));
		list.add(new Phones(41, "Nokia", 1999, "X6"));
		list.add(new Phones(89, "Google", 1990, "Nexus"));

		Stream<Phones> filtered_data = list.stream().filter(p -> p.price > 1999);

		filtered_data.forEach(n -> System.out.println(n.name));
	}
}
