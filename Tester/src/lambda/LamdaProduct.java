package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaProduct {
	public static void main(String[] args) {
		Product prod1 = new Product(2, "Dell", 256.15);
		Product prod2 = new Product(3, "HP", 193.12);
		Product prod3 = new Product(5, "Apple", 652.99);

		List<Product> list = new ArrayList<Product>();
		list.add(prod1);
		list.add(prod2);
		list.add(prod3);

		System.out.println("Sorting with name");
		Collections.sort(list, (p1, p2) -> {
			return p1.name.compareTo(p2.name);
		});

		list.forEach(n -> System.out.println(n.id + " " + n.name + " " + n.price));

	}

}
