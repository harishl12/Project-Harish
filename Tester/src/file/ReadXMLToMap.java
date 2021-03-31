package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLToMap {
	static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "\\Files\\XMLs\\data.xml");
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = db.parse(file);

		System.out.println("Root element: " + document.getDocumentElement().getNodeName());

		if (document.hasChildNodes()) {
			printNodeInfo(document.getChildNodes());
		}

		System.out.println("Printing map");

		map.forEach((k, v) -> System.out.println(k + "->" + v));
	}

	private static HashMap<String, String> printNodeInfo(NodeList nodeList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node elemNode = nodeList.item(i);
			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
				if (!elemNode.getNodeName().isEmpty() && !elemNode.getTextContent().isEmpty()
						&& !elemNode.hasAttributes())
					map.put(elemNode.getNodeName(), elemNode.getTextContent());

				System.out.println("elemNode.getNodeName() " + " -> " + elemNode.getNodeName());
				System.out.println("elemNode.getTextContent() " + " -> " + elemNode.getTextContent());
//				System.out.println(elemNode.getNodeName() + " -> " + elemNode.getTextContent());
				if (elemNode.hasAttributes()) {
					NamedNodeMap nodeMap = elemNode.getAttributes();
					for (int j = 0; j < nodeMap.getLength(); j++) {
						Node node = nodeMap.item(j);
						if (!node.getNodeName().isEmpty() && !node.getNodeValue().isEmpty())
							map.put(node.getNodeName(), node.getNodeValue());
						System.out.println(node.getNodeName() + " -> " + node.getNodeValue());
					}
				}
				if (elemNode.hasChildNodes()) {
					printNodeInfo(elemNode.getChildNodes());
				}
			}
		}
		return map;
	}
}