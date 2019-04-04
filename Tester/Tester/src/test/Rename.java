package test;

import java.io.File;

public class Rename {
	public static void main(String[] args) {
		String path = "C:\\Files";
		File dir = new File(path);
		File[] filesDir = dir.listFiles();
		for (File file : filesDir) {
//			String path1 = file.getName().replaceAll("950", "250");
//			String path1 = file.getName().split("950")[0];
//			System.out.println(file.getName().split("950")[0]);
//			int num = Integer.parseInt(file.getName().split("_")[2].split("\\.")[0])+25;
//			System.out.println(num);
//			System.out.println(path1+"950_"+num);
			String newPath = path + "\\" + file.getName().replaceAll("450", "850");
//			file.renameTo(new File(path + "\\" + path1+"950_"+num+".xml"));
			file.renameTo(new File(newPath));
		}
	}
}
