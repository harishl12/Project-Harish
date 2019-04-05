package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

	public static void main(String[] args) throws IOException {
		// String
		try {
			FileOutputStream FOS = new FileOutputStream("FOS.txt");
			String text = " Harry and Amul";
			byte[] b = text.getBytes();
			FOS.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
