package collections;

import java.io.Serializable;

public class Book implements Serializable {
	public int id;
	public String Author;
	public Double rate;

	public Book(int id, String Author, Double rate) {
		this.id = id;
		this.Author = Author;
		this.rate = rate;

	}
}
