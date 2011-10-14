/*
 * XMLReader.java
 *
 * Created on Mar 22, 2011, 08:54:54 PM
 */
package Logic.XMLReader;

import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import GPS_Reader.CoordinateProcessor;
import Logic.SearchEngine.Manual.Edge;
import Logic.SearchEngine.Manual.Path;
import Logic.SearchEngine.Manual.Way;
import Logic.SearchEngine.Manual.WaypointInfo;
import Logic.SearchEngine.Manual.WaypointNode;

/**
 * A class to read the .XML file of the area
 * @author Amir Almasi
 * @version 0.2
 *
 */
public class XMLAreaReader {

    // declration of the variables
    private HashMap<WaypointNode, ArrayList<Path>> hm = new HashMap<WaypointNode, ArrayList<Path>>();
    private ArrayList<Way> ways = new ArrayList<Way>();
    private WaypointNode nodeTemp;
    private ArrayList<Path> path;
    private WaypointInfo wpi;
    private String fileAddress = "";
    private boolean wayTag;
    private boolean nodeTag;

    // non-argument constructor
    public XMLAreaReader() {
    }

    /**
     * Constructor to open the file and put it in the HashMap
     * @param fileAddress, the address of the .XML file
     * @param hm, the HashMap which contains the .XML file
     */
    public XMLAreaReader(String fileAddress, HashMap<WaypointNode, ArrayList<Path>> hm, ArrayList<Way> ways) {
        this.hm = hm;
        this.fileAddress = fileAddress;
        this.ways = ways;
    }

    /**
     * A method to read the .XML file
     */
    public void readXmlFile() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                /**
                 * A method for starting tags of the .XML
                 */
                public void startElement(String uri, String localName,
                        String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("node")) {
                        nodeTag = true;
                        nodeTemp = new WaypointNode(attributes.getValue("id"), Double.valueOf(attributes.getValue("lat")),
                                Double.valueOf(attributes.getValue("lon")), attributes.getValue("user"), attributes.getValue("uid"),
                                Boolean.valueOf(attributes.getValue("visible")), Byte.valueOf(attributes.getValue("version")),
                                attributes.getValue("timestamp"));
                        if (!hm.containsKey(nodeTemp)) {
                            path = new ArrayList<Path>();
                            path.add(new Path(new Edge("null"), 0, nodeTemp));
                            hm.put(nodeTemp, path);
                        }
                    } else {
                        if (qName.equalsIgnoreCase("way")) {
                            wayTag = true;
                            ways.add(new Way(attributes.getValue("id"), attributes.getValue("user"), attributes.getValue("uid"), Boolean.valueOf(attributes.getValue("visible")), Byte.valueOf(attributes.getValue("version")), attributes.getValue("timestamp")));

                        } else {
                            /* if a way has been started then the last way in the arraylist of path which
                             * had been add last time will be returned, then in that last way the new node would be add to the way
                             */
                            if (qName.equalsIgnoreCase("nd")) {
                                if (wayTag) {
                                    ways.get(ways.size() - 1).allNodesInWay.add(hm.get(new WaypointNode(attributes.getValue("ref"))).get(0).getTarget());
                                }

                            } else {
                                if (qName.equalsIgnoreCase("tag")) {
                                    if (wayTag) {
                                        ways.get(ways.size() - 1).wayInfo.add(new WaypointInfo(attributes.getValue("k"),
                                                attributes.getValue("v")));
                                    } else {
                                        nodeTemp.waypointInfo.add(new WaypointInfo(attributes.getValue("k"),
                                                attributes.getValue("v")));
                                        path = new ArrayList<Path>();

                                        path.add(new Path(new Edge("null"), 0, nodeTemp));
                                        hm.put(nodeTemp, path);
                                    }
                                }
                            }
                        }
                    }
                }

                /**
                 * A method for finished tag of .XML
                 */
                public void endElement(String uri, String localName,
                        String qName)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("way")) {
                        wayTag = false;
                    } else {
                        if (qName.equalsIgnoreCase("node")) {
                            nodeTag = false;
                        }
                    }
                }

                /**
                 * A method to read the character between tags.
                 */
                public void characters(char ch[], int start, int length)
                        throws SAXException {
                }
            };
            saxParser.parse(fileAddress, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * with this for loop I am adding (each node in the way) to the value of key in the HashMap
         * the value is arrayList of Node
         * if the way is both way the node 2 would be added in adjacency of node 1 in the HashMap
         * and node 1 would be added in adjacency of the node 2 in the HashMap
         * if the way if oneWay then just node 2 would be added to adjacency of the node 1
         */
        for (Way way : ways) {
            for (int j = 0; j < way.allNodesInWay.size() - 1; j++) {
                for (int wayInfoCounter = 0; wayInfoCounter < way.wayInfo.size(); wayInfoCounter++) {
                    hm.get(way.allNodesInWay.get(j)).get(0).getTarget().waypointInfo.add(way.wayInfo.get(wayInfoCounter));
                }
                hm.get(way.allNodesInWay.get(j)).add(new Path(new Edge(way.getId()), new CoordinateProcessor().getDistance(way.allNodesInWay.get(j).getLatitude(), way.allNodesInWay.get(j + 1).getLatitude(), way.allNodesInWay.get(j).getLongitude(), way.allNodesInWay.get(j + 1).getLongitude()), way.allNodesInWay.get(j + 1)));

                if (!way.wayInfo.contains(new WaypointInfo("oneway", "non-impoetant parameter in this case"))) {
                    hm.get(way.allNodesInWay.get(j + 1)).add(new Path(new Edge(way.getId()), new CoordinateProcessor().getDistance(way.allNodesInWay.get(j + 1).getLatitude(), way.allNodesInWay.get(j).getLatitude(), way.allNodesInWay.get(j + 1).getLongitude(), way.allNodesInWay.get(j).getLongitude()), way.allNodesInWay.get(j)));
                }
            }
        }
    }
}
