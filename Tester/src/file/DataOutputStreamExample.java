package file;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream out = new FileOutputStream("DOS,txt");
		DataOutputStream dos = new DataOutputStream(out);
		String text = "Hi Data Output stream example from Harry and Amul";
		byte[] byt = text.getBytes();
		dos.write(byt);
		dos.flush();
		dos.close();
		out.close();
		System.out.println("Write successful");

	}
}
