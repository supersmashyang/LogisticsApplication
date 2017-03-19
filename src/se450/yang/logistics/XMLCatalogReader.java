package se450.yang.logistics;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLCatalogReader {
	 private final ItemCatalog itemCatalog;
	
	 public XMLCatalogReader() {
	      this.itemCatalog = new ItemCatalog();
	
	 }

	private File fromClassPath(String name) throws URISyntaxException {
		return new File(XMLCatalogReader.class.getClassLoader().getResource(name).toURI());
	}

	public void parse() throws URISyntaxException {
		try {
			String fileName = "se450/yang/logistics/XMLCatalogDoc.xml";

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			File xml = fromClassPath(fileName);
			if (!xml.exists()) {
				System.err.println("**** XML File '" + fileName + "' cannot be found");
				System.exit(-1);
			}

			Document doc = db.parse(xml);
			doc.getDocumentElement().normalize();

			NodeList Catalog = doc.getDocumentElement().getChildNodes();

			for (int i = 0; i < Catalog.getLength(); i++) {
				if (Catalog.item(i).getNodeType() == Node.TEXT_NODE) {
					continue;
				}

				String entryName = Catalog.item(i).getNodeName();
				if (!entryName.equals("Item")) {
					System.err.println("Unexpected node found: " + entryName);
					return;
				}

				// Get a node attribute
				NamedNodeMap aMap = Catalog.item(i).getAttributes();
				// String storeId = aMap.getNamedItem("Id").getNodeValue();

				// Get a named nodes
				Element elem = (Element) Catalog.item(i);
				String CatalogId = elem.getElementsByTagName("Id").item(0).getTextContent();
				String CatalogPrice = elem.getElementsByTagName("Price").item(0).getTextContent();

				// Get all nodes named "Book" - there can be 0 or more
				ArrayList<String> itemDescriptions = new ArrayList<>();
				NodeList itemList = elem.getElementsByTagName("Item");
				for (int j = 0; j < itemList.getLength(); j++) {
					if (itemList.item(j).getNodeType() == Node.TEXT_NODE) {
						continue;
					}

					entryName = itemList.item(j).getNodeName();
					if (!entryName.equals("Item")) {
						System.err.println("Unexpected node found: " + entryName);
						return;
					}

					// Get some named nodes
					elem = (Element) itemList.item(j);
					String Id = elem.getElementsByTagName("Id").item(0).getTextContent();
					String Price = elem.getElementsByTagName("Price").item(0).getTextContent();
					itemCatalog.put(Id, Integer.parseInt(Price));
					System.out.println(itemCatalog);

//					itemDescriptions.add(Id + ": " + Price + "\n");
				}

				// Here I would create a Store object using the data I just
				// loaded from the XML
				// System.out.println("Item Catalog: " + itemDescriptions + "\n");

			}

		} catch (ParserConfigurationException | SAXException | IOException | DOMException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		System.out.println(itemCatalog);
		
	}
}
