package testNG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataProvider {

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir") + "//Files/info";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			System.out.println(listOfFiles[i]);
			FileReader fr = new FileReader(listOfFiles[i]);
			int j = 0;
			while ((j = fr.read()) != -1) {
				System.out.print((char) j);
			}

		}
	}

}
