package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamExample {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = new FileInputStream("BOS.txt");
		FileInputStream fis2 = new FileInputStream("FOS.txt");
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		int i = 0;
		while ((i = sis.read()) != -1) {
			System.out.print((char) i);
		}
		System.out.println();
		sis.close();
		fis1.close();
		fis2.close();
		System.out.println("Read completed");
	}
}
