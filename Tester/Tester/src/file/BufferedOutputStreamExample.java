package file;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("BOS.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String text = "Harry Amul Buffered Output stream";
		byte[] byteArray = text.getBytes();
		bos.write(byteArray);
		bos.close();
		fos.close();
		System.out.println("Write successful");
	}
}
