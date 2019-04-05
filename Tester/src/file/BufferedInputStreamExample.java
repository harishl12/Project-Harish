package file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.util.BlockingInputStream;

public class BufferedInputStreamExample {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("BOS.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		int i = 0;
		while ((i = bis.read()) != -1) {
			System.out.print((char) i);
		}
		bis.close();
		fis.close();
		System.out.println("Read completed");
	}
}
