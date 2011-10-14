/*
 * Search.java
 *
 * Created on Mar 23, 2011, 09:46:00 PM
 */
package Logic.SearchEngine.Manual;

import Logic.XMLReader.XMLAreaReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * A class to control the whole manual search
 * this class would be the brain of the manual search
 * @author Amir Almasi
 * @version 0.2
 */
public class Search {

    // variable declaration
    public HashMap<WaypointNode, ArrayList<Path>> hm = new HashMap<WaypointNode, ArrayList<Path>>();
    public ArrayList<Way> ways = new ArrayList<Way>();
    private String fileAddress;
    private XMLAreaReader xmlReader;
    private Dijkstra dijkstra;

    /**
     * Constructor
     * @param fileAddress The address of the .XML file
     */
    public Search(String fileAddress) {
        this.fileAddress = fileAddress;
        readXMLfile();
    }

    /**
     * a method to read the XML file
     */
    private void readXMLfile() {
        xmlReader = new XMLAreaReader(this.fileAddress, hm, ways);
        xmlReader.readXmlFile();
    }

    /**
     * A method to search the graph by implementing Dijkstra search
     * @param sourceNode
     * @param target
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return ArrayList<WaypointNode> of the best way
     */
    public ArrayList<WaypointNode> searchDijkstra(String sourceNode, String target, int wayType) {
        ArrayList<WaypointNode> allNode;
        dijkstra = new Dijkstra();
        allNode = dijkstra.findShortestPath(hm, new WaypointNode(sourceNode), new WaypointNode(target), wayType);
        if (allNode.get(allNode.size() - 1).getId().equalsIgnoreCase(target)) {
            ArrayList<WaypointNode> bestWay = new ArrayList<WaypointNode>();
            bestWay.add(allNode.get(allNode.size() - 1));
            for (int i = allNode.size() - 2; i >= 0; i--) {
                //			System.out.println("get Id " + allNode.get(i).getId() + " last Node  "+ allNode.get(i).getFirstNodeId());
                if (i == 0) {
                    bestWay.add(allNode.get(i));
                } else if (allNode.get(i).getId().equalsIgnoreCase(bestWay.get(bestWay.size() - 1).getFirstNodeId())) {
                    bestWay.add(allNode.get(i));
                    //						bestWay.add(allNode.get(i));
                }
            }

//            printInfoDijkstra(bestWay);
            return bestWay;
        } else {
            JOptionPane.showMessageDialog(null, "There was not any way found in the .XML file");
        }
        return null;
    }

    /**
     * 
     * @param id
     * @return boolean
     * --> True if node contains building information
     * --> False if node does not contain building information.
     */
    public boolean checkNode(String id) {
        try {
            if (!hm.get(new WaypointNode(id)).get(0).getTarget().waypointInfo.contains(new WaypointInfo("building", null))) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * A test method to print the information of the list_N
     * @param allNode
     */
    private void printInfoDijkstra(ArrayList<WaypointNode> allNode) {
        System.out.println("dijkstra :");
        for (WaypointNode node : allNode) {
            System.out.println("Previous Node:" + node.getFirstNodeId() + "\t\tTo Node:" + node.getId() + "\t\twith last shortest distance: " + node.getShortestDistance() + " meter");
        }
    }

    /**
     * A method to get the nearest node Id by implementing manual code.
     * @param lat latitude
     * @param lon longitude
     * @return String id
     */
    public String getNearetID(double lat, double lon) {
        for (int i = 0; i < ways.size(); i++) {
            for (int j = 0; j < ways.get(i).allNodesInWay.size(); j++) {
                if (Math.abs(ways.get(i).allNodesInWay.get(j).getLatitude() - lat) < 0.0006) {
                    if (Math.abs(ways.get(i).allNodesInWay.get(j).getLongitude() - lon) < 0.0006) {
//                        JOptionPane.showMessageDialog(null, ways.get(i).allNodesInWay.get(j).getId());
                        return ways.get(i).allNodesInWay.get(j).getId();
                    }
                }
            }
        }
        return null;
    }
}
