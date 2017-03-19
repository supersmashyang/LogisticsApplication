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

public class XMLFacilityNetworkReader {

	private final FacilityLinks facilityLinks;
	private final FacilityLinkDistance facilityLinkDistance;
	private final Facilities facilities;

	public XMLFacilityNetworkReader() {
		this.facilityLinks = new FacilityLinks();
		this.facilityLinkDistance = new FacilityLinkDistance();
		this.facilities = new Facilities();

	}

	private File fromClassPath(String name) throws URISyntaxException {
		return new File(XMLFacilityNetworkReader.class.getClassLoader().getResource(name).toURI());
	}

	public void parse() {
		try {
			String fileName = "se450/yang/logistics/XMLFacilityNetworkDoc.xml";

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			File xml = fromClassPath(fileName);
			if (!xml.exists()) {
				System.err.println("**** XML File '" + fileName + "' cannot be found");
				System.exit(-1);
			}

			Document doc = db.parse(xml);
			doc.getDocumentElement().normalize();

			NodeList facilityEntries = doc.getDocumentElement().getChildNodes();

			for (int i = 0; i < facilityEntries.getLength(); i++) {
				if (facilityEntries.item(i).getNodeType() == Node.TEXT_NODE) {
					continue;
				}

				String entryName = facilityEntries.item(i).getNodeName();
				if (!entryName.equals("Facility")) {
					System.err.println("Unexpected node found: " + entryName);
					return;
				}

				// Get a node attribute
				NamedNodeMap aMap = facilityEntries.item(i).getAttributes();
				String facility = aMap.getNamedItem("Location").getNodeValue();
				Vertex facilityFrom = new Vertex(facility);

				// Get a named nodes
				Element elem = (Element) facilityEntries.item(i);
				int facilityRate = Integer.parseInt(elem.getElementsByTagName("rate").item(0).getTextContent());
				int facilityCost = Integer.parseInt(elem.getElementsByTagName("cost").item(0).getTextContent());
				FacilityInfo facilityInfo = new FacilityInfo(facilityRate, facilityCost);
				facilities.put(facilityFrom, facilityInfo);

				// // Get all nodes named "Book" - there can be 0 or more
				// ArrayList<String> facilityDescriptions = new ArrayList<>();
				NodeList adjacentList = elem.getElementsByTagName("AdjacentFacilitiy");
				for (int j = 0; j < adjacentList.getLength(); j++) {
					if (adjacentList.item(j).getNodeType() == Node.TEXT_NODE) {
						continue;
					}

					entryName = adjacentList.item(j).getNodeName();
					if (!entryName.equals("AdjacentFacilitiy")) {
						System.err.println("Unexpected node found: " + entryName);
						return;
					}

					// Get some named nodes
					elem = (Element) adjacentList.item(j);
					String adjacentFacilityLocation = elem.getElementsByTagName("Location").item(0).getTextContent();
					String adjacentFacilityDistance = elem.getElementsByTagName("distance").item(0).getTextContent();
					
					Vertex facilityTo = new Vertex(adjacentFacilityLocation);
					Edge facilityLink = new Edge(facilityFrom, facilityTo);
					facilityLinkDistance.put(facilityLink, Integer.parseInt(adjacentFacilityDistance));
					facilityLinks.put(facilityFrom, facilityTo);

				}

			}

		} catch (ParserConfigurationException | SAXException | IOException | DOMException | URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println("facilities" + facilities);
		System.out.println("facilityLinkDistance" + facilityLinkDistance);
		System.out.println("facilityLinks" + facilityLinks);

	}
}
