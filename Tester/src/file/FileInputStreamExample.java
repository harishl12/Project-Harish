package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("FOS.txt");
		int i = 0;
		StringBuffer text = new StringBuffer();
		String val = null;
		while (((i = file.read()) != -1)) {
//			System.out.print((char) i);
			val = String.valueOf((char) i);
			text.append(val);
		}
		System.out.println(text);
	}
}
