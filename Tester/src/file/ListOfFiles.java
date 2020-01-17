package file;

import java.io.File;

public class ListOfFiles {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		File folder = new File(System.getProperty("user.dir") + "\\Test1");
		File[] listOfFiles = folder.listFiles();
		for(int i=0;i<listOfFiles.length;i++) {
			System.out.println(listOfFiles[i]);
		}
	}
}
