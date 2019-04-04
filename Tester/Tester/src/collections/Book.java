package collections;

import java.io.Serializable;

public class Book implements Serializable {
	int id;
	String Author;
	Double rate;

	Book(int id, String Author, Double rate) {
		this.id = id;
		this.Author = Author;
		this.rate = rate;

	}
}
