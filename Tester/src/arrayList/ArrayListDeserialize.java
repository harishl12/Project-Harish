package arrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ArrayListDeserialize {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("ALOOS.txt");
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);

		ArrayList<Books> al = (ArrayList<Books>) ois.readObject();
		for (Books b : al)
			System.out.println(b.id + "->" + b.Author + "->" + b.rate);

	}
}
