package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class FilterOutputStreamExample {
	public static void main(String[] args) throws IOException {
		File file = new File("FOPS.txt");
		FileOutputStream fos = new FileOutputStream(file);
		FilterOutputStream fops = new FilterOutputStream(fos);
		String text = "Filter Output example from Haary";
		byte[] byt = text.getBytes();
		fops.write(byt);
		fops.flush();
		fops.close();
		System.out.println("Write succesful");
	}
}
