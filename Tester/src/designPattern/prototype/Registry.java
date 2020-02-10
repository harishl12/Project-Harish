package designPattern.prototype;

import java.util.HashMap;

public class Registry {
	HashMap<String, Item> items = new HashMap<String, Item>();

	public Registry() {
		loadItems();
	}

	public Item createItem(String type) {
		Item item = null;
		try {
			item = (Item) (items.get(type)).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return item;
	}

	private void loadItems() {
		Movies movie = new Movies();
		movie.setTitle("Dark Knight");
		movie.setRunTime(160);
		movie.setPrice(12.56);
		movie.setUrl("google.com");
		items.put("Movies", movie);

		Books book = new Books();
		book.setTitle("Ramayan");
		book.setNumberOfPages(789);
		book.setPrice(48.95);
		book.setUrl("amazon.com");
		items.put("Books", book);
	}
}
