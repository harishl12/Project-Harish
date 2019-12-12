package other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Upgrade {
	public static void main(String[] args) throws IOException {
//	
		String pwd = System.getProperty("user.dir");
		File file = new File(pwd + "\\Files\\ASN.txt");
		FileReader fr = new FileReader(file);
		BufferedReader buf = new BufferedReader(fr);
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		String fileAsString = sb.toString();
//		System.out.println("Contents : " + fileAsString);
		String[] asnarray = fileAsString.split("\n");
		System.out.println(asnarray);
		ArrayList<String> asn = new ArrayList<String>();
		for (String s : asnarray)
			asn.add(s.trim());
		System.out.println(asn);

	}
}
