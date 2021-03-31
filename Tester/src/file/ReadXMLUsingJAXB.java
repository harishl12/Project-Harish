package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlSeeAlso;

public class ReadXMLUsingJAXB {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "\\Files\\XMLs\\data.xml");
		FileInputStream fis = new FileInputStream(file);
		
		

	}

}
