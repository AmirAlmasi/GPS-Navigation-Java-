/*
 * ReadLocFile.java
 *
 * Created on Mar 23, 2011, 8:54:19 PM
 */
package Logic.XMLReader;

import Logic.MyNode;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * A class to read the LOC file of waypoints.
 * @author Amir Almasi
 */
public class ReadLOCFile {

    // variables declaration
    private MyNode node;
    private ArrayList<MyNode> LOCList;

    /**
     * A method to read the .XML file
     * @param fileAddress of the .LOC file
     */
    public ArrayList<MyNode> readLoc(String fileAddress) {
        LOCList = new ArrayList<MyNode>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // handler
            DefaultHandler handler = new DefaultHandler() {

                boolean bName = false;
                boolean bCoord = false;
                boolean bWaypoint = false;

                /**
                 * A method for starting tags of the .XML
                 */
                public void startElement(String uri, String localName,
                        String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("waypoint")) {
                        bWaypoint = true;
                        node = new MyNode();
                    }
                    if (qName.equalsIgnoreCase("name")) {
                        bName = true;
                        node.setWaypointName(attributes.getValue("id"));
//                        System.out.println("id: " + attributes.getValue("id"));
                    }
                    if (qName.equalsIgnoreCase("coord")) {
                        bCoord = true;
                        node.setLatitude(new Double(attributes.getValue("lat")));
//                        System.out.println("latitude: " + attributes.getValue("lat"));
                        node.setLongitude(new Double(attributes.getValue("lon")));
//                        System.out.println("longitude: " + attributes.getValue("lon"));
                    }
                } // end of startElement method.

                /**
                 * A method for finished tag of .XML
                 */
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("waypoint")) {
                        LOCList.add(node);
                    }
                }
            };
            saxParser.parse(fileAddress, handler);
        } catch (Exception exception) {
        }
        return LOCList;
    } // end of method main.
} // end of class ReadLOCFile.

