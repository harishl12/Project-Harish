package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
	public static void main(String[] args) throws IOException {
		File file = new File("FW.txt");
		FileInputStream in = new FileInputStream(file);
		FileReader read = new FileReader(file);
		int i = 0;
		while ((i = read.read()) != -1) {
			System.out.print((char) i);
		}
	}

}
