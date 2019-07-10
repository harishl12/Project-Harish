package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
	public static void main(String[] args) throws IOException {
		File file = new File("FW.txt");
		FileOutputStream out = new FileOutputStream(file);
		FileWriter writer = new FileWriter(file);
		String text = "File Writer Example";
//		byte[] byt = text.getBytes();
		writer.write(text);
		writer.flush();
		writer.close();
	}
}