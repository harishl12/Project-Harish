package file;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("DOS.txt");
		DataInputStream dis = new DataInputStream(in);
		int i = 0;
		while ((i = dis.read()) != -1) {
			System.out.print((char) i);
		}

	}
}
