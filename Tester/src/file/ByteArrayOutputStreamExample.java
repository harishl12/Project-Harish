package file;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos1 = new FileOutputStream("BAOS1.txt");
		FileOutputStream fos2 = new FileOutputStream("BAOS2.txt");
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		String text = "Byte Array Output stream example for Harry and Amul";
		byte[] byt = text.getBytes();
		boas.write(byt);
		boas.writeTo(fos1);
		boas.writeTo(fos2);
		boas.flush();
		boas.close();
		System.out.println("Write completed ");
	}
}
