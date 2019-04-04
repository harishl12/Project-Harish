package arrayList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListBooksExample {
	public static void main(String[] args) throws IOException {
		Books b1 = new Books(01, "Harry", 123.45);
		Books b2 = new Books(02, "Pakya", 345.66);
		Books b3 = new Books(3, "Shaky", 77.43);

		ArrayList<Books> al = new ArrayList<Books>();
		al.add(b1);
		al.add(b2);
		al.add(b3);

		File file = new File("ALOOS.txt");
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(al);
		oos.flush();
		oos.close();

		Iterator<Books> it = al.iterator();
		while (it.hasNext()) {
			Books bk = (Books) it.next();
			System.out.println(bk.id + "->" + bk.Author + "->" + bk.rate);
		}
	}
}
