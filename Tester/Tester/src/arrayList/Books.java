package arrayList;

import java.io.Serializable;

public class Books implements Serializable {
	int id;
	String Author;
	Double rate;

	Books(int id, String Author, Double rate) {
		this.id = id;
		this.Author = Author;
		this.rate = rate;

	}
}
