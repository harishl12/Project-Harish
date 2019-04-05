package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOuputStreamExample {

	public static void main(String[] args) throws IOException {
		Student st1 = new Student(12, "Harry");

		File file = new File("OOS.txt");
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(st1);
		oos.flush();
		oos.close();
	}

}
