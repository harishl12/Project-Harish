package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
	public static void main(String[] args) throws IOException {
		File file = new File("BW.txt");
		FileWriter writer = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(writer);
		String text = "Buffered writer example";
		bw.write(text);
		bw.flush();
		bw.close();
		System.out.println("Write completed");
	}
}
