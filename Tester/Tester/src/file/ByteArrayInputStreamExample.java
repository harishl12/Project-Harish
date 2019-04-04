package file;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ByteArrayInputStreamExample {
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis1 = new FileInputStream("BAOS1.txt");
		FileInputStream fis2 = new FileInputStream("BAOS2.txt");
		BufferedInputStream bis1 = new BufferedInputStream(fis1);
		BufferedInputStream bis2 = new BufferedInputStream(fis2);
		// ByteArrayInputStream bais = new ByteArrayInputStream(bis1,bis2)
	}
}
