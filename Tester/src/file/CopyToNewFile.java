package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyToNewFile {
	public static void main(String[] args) throws IOException {
//		System.out.println(System.getProperty("user.dir"));
		String filePath = System.getProperty("user.dir") + "\\Files";
		File file = new File(filePath + "\\ASN.txt");
		File tgt = new File(filePath + "\\ASN2.txt");
		FileReader fr = new FileReader(file);
		FileWriter wr = new FileWriter(tgt);
		BufferedWriter bw = new BufferedWriter(wr);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			System.out.println(line.split("\\|")[0]);
			bw.write(line.split("\\|")[0] + "\n");
		}
		bw.flush();
		/*
		 * int i = 0; while ((i = fr.read()) != -1) { System.out.print((char) i); }
		 */
	}
}
