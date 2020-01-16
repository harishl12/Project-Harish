package collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import collections.Book;

public class HashMapBookExample {
	public static void main(String[] args) {
		Book b1 = new Book(12, "Harry", 12.36);
		Book b2 = new Book(345, "Shakku", 55.44);
		Book b3 = new Book(75, "Amul", 65.02);

		Map<Integer, Book> map = new HashMap<Integer, Book>();
		map.put(21, b1);
		map.put(5, b2);
		map.put(60, b3);

		for (Map.Entry<Integer, Book> entry : map.entrySet()) {
			int key = entry.getKey();
			System.out.println("Key -> " + key);
			Book b = entry.getValue();
			System.out.println(b.id + "->" + b.Author + "->" + b.rate);

		}

	}
}
