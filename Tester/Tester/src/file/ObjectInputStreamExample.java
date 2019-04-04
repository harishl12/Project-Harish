package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File file = new File("OOS.txt");
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);

		Student s = (Student) ois.readObject();
		System.out.println(s.id + " -> " + s.name);

	}
}
