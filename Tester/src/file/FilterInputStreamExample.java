package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;

import org.apache.poi.util.BlockingInputStream;

public class FilterInputStreamExample {
	public static void main(String[] args) throws IOException {

		File file = new File("FOPS.txt");
		FileInputStream input = new FileInputStream(file);
		FilterInputStream filter = new BufferedInputStream(input);
		int j = 0;
		while ((j = filter.read()) != -1) {
			System.out.print((char) j);
		}
		System.out.println("\n Write completed");
	}
}
