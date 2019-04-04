package file;

import java.io.File;
import java.io.FilenameFilter;

public class FileExample {
	public static void main(String[] args) {
		String path = "C:\\Users\\lakshh\\Documents\\workspace\\Tester\\Files";
		File file = new File(path);
		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		System.out.println("file.exists() -> " + file.exists());
		System.out.println("file.getAbsolutePath() -> " + file.getAbsolutePath());
		System.out.println("file.getAbsoluteFile() -> " + file.getAbsoluteFile());
		System.out.println("file.list() -> " + file.listFiles(filter));

	}
}
