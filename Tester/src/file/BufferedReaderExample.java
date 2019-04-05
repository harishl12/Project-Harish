package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
	public static void main(String[] args) throws IOException {
		File file = new File("BW.txt");
		FileReader in = new FileReader(file);
		BufferedReader read = new BufferedReader(in);
		int i = 0;
		while ((i = read.read()) != -1) {
			System.out.print((char) i);
		}
	}
}
