package se450.yang.logistics;


import java.io.File;
import java.io.IOException;
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

public class XMLFacilityInventoryReader {
	
	
	

    public void parse() {

        try {
            String fileName = "XMLFacilityInventoryDoc.xml";


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            File xml = new File(fileName);
            if (!xml.exists()) {
                System.err.println("**** XML File '" + fileName + "' cannot be found");
                System.exit(-1);
            }

            Document doc = db.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList facilityInventoryEntries = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < facilityInventoryEntries.getLength(); i++) {
                if (facilityInventoryEntries.item(i).getNodeType() == Node.TEXT_NODE) {
                    continue;
                }
                
                String entryName = facilityInventoryEntries.item(i).getNodeName();
                if (!entryName.equals("Facility")) {
                    System.err.println("Unexpected node found: " + entryName);
                    return;
                }
                
                // Get a node attribute
                NamedNodeMap aMap = facilityInventoryEntries.item(i).getAttributes();
                String storeId = aMap.getNamedItem("Location").getNodeValue();

                // Get a named nodes
                Element elem = (Element) facilityInventoryEntries.item(i);
                String FacilityLocation = elem.getElementsByTagName("Location").item(0).getTextContent();
                //String storeAddress = elem.getElementsByTagName("Address").item(0).getTextContent();

                // Get all nodes named "Book" - there can be 0 or more
                ArrayList<String> InventoryDescriptions = new ArrayList<>();
                NodeList InventoryList = elem.getElementsByTagName("Item");
                for (int j = 0; j < InventoryList.getLength(); j++) {
                    if (InventoryList.item(j).getNodeType() == Node.TEXT_NODE) {
                        continue;
                    }

                    entryName = InventoryList.item(j).getNodeName();
                    if (!entryName.equals("Item")) {
                        System.err.println("Unexpected node found: " + entryName);
                        return;
                    }

                    // Get some named nodes
                    elem = (Element) InventoryList.item(j);
                    String ItemID = elem.getElementsByTagName("ID").item(0).getTextContent();
                    String ItemQuantity = elem.getElementsByTagName("Quantity").item(0).getTextContent();
                    //String bookDate = elem.getElementsByTagName("Date").item(0).getTextContent();
                    //String bookIsbn13 = elem.getElementsByTagName("ISBN13").item(0).getTextContent();
                    //Facility facility = new Facility(naem, rate, cost);
                    // Create a string summary of the book
                    InventoryDescriptions.add(ItemID + "     " + ItemQuantity + "\n" );
                    //facilities.add(facility);
                }

                // Here I would create a Store object using the data I just loaded from the XML
                System.out.println("Item ID " + "      " + " Quantity \n"  + InventoryDescriptions + "\n");
                
            }

        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            e.printStackTrace();
        }
    }

}
