package designPattern.abstractFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class AbstractFactoryXMLDemo {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		String xml = "<document><body><stock>HHH</stock></body></document>";
		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(is);
		doc.getDocumentElement().normalize();

		System.out.println("Root element --->" + doc.getDocumentElement().getNodeName());

		System.out.println(dbf);
		System.out.println(db);
		System.out.println(doc);
	}
}
