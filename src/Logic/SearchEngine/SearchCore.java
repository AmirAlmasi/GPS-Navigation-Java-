/*
 * SearchCore.java
 *
 * Created on Mar 20, 2011, 05:21:34 PM
 */
package Logic.SearchEngine;

import Logic.SearchEngine.API.APISearch;
import Logic.SearchEngine.Manual.Search;
import Logic.SearchEngine.Manual.WaypointNode;
import org.openstreetmap.osm.ConfigurationSection;
import org.openstreetmap.osmosis.core.domain.v0_6.*;
import org.openstreetmap.osm.data.IDataSet;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.openstreetmap.osm.data.MemoryDataSet;
import org.openstreetmap.osm.data.coordinates.LatLon;
import org.openstreetmap.osm.data.searching.*;
import org.openstreetmap.travelingsalesman.routing.IVehicle;
import org.openstreetmap.travelingsalesman.routing.selectors.Motorcar;

/**
 * This class is the core of searching ways
 * If the user attempts either to search by using API or manual search this class
 * handles the search type.
 * @author Amir Almasi
 * @version 0.2
 */
public class SearchCore implements Runnable {

    // declration of the variables
    private Search search;
    private APISearch apiSearch;
    private String fileAddress;
    private MemoryDataSet myMap = (new org.openstreetmap.osm.io.FileLoader(new File("sources//map.osm"))).parseOsm();

    /**
     * Constructor with the address of the file.
     * @param fileAddress of the file.
     */
    public SearchCore(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    /**
     * run method for Thread to run the search to start reading XML file
     */
    public void run() {
        search = new Search(fileAddress);
    }

    /**
     *  A method to call the manual Dijkstra by getting node's ID
     * @param latitude1 
     * @param longitude1
     * @param latitude2
     * @param longitude2
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return the ArrayList of the Waypoints which shows the best way
     */
    public ArrayList<Logic.SearchEngine.Manual.WaypointNode> manualDijkstra(double latitude1, double longitude1, double latitude2, double longitude2, int wayType) {
        /*
         * To get the clicked node id on the map and start the searching by
         * manual dijkstra
         */
        NearestStreetSelector nSS = new NearestStreetSelector();
        Motorcar vehicle = new Motorcar();
        LatLon startCoord = new LatLon(latitude1, longitude1);
        LatLon targetCoord = new LatLon(latitude2, longitude2);

        // the nearest node id would be return with this one
        String targetID = myMap.getNearestNode(targetCoord, new WalkingSelector()).getId() + "";
        String startID = search.getNearetID(latitude1, longitude1);
        if (startID == null) {
            return search.searchDijkstra(myMap.getNearestNode(startCoord, nSS).getId() + "", targetID, wayType);
        }
        /*
         * start searching manually by node id
         */
//        return search.searchDijkstra(myMap.getNearestNode(startCoord, nSS).getId() + "", targetID, wayType);
//         return search.searchDijkstra(myMap.getNearestNode(startCoord, nSS).getId() + "", myMap.getNearestNode(targetCoord, nSS).getId() + "", wayType);
        ArrayList<Logic.SearchEngine.Manual.WaypointNode> list = new ArrayList<WaypointNode>();
        list = search.searchDijkstra(startID, targetID, wayType);
        if (list == null) {
//            JOptionPane.showMessageDialog(null, "yes barabare null hastesh ");
            return search.searchDijkstra(myMap.getNearestNode(startCoord, nSS).getId() + "", targetID, wayType);
        }
        return list;
    }

    /**
     * A method check if the mouse cursor is on a node located in .XML or not.
     * @param latitude mouse latitude of the map.
     * @param longitude mouse longitude of the map.
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return boolean
     *  --> True if mouse cursor is on a node.
     *  --> False if mouse cursor is not on a node.
     */
    public boolean checkMouseArea(double latitude, double longitude, int wayType) {
        LatLon checkCoordinate = new LatLon(latitude, longitude);
        Node n = myMap.getNearestNode(checkCoordinate, new WalkingSelector());
        if ((Math.abs(n.getLatitude() - latitude) < 0.0001) && (Math.abs(n.getLongitude() - longitude) < 0.0001)) {
            if (search.checkNode(n.getId() + "")) {
                return true;
            }
        }
        return false;
    }

    /**
     * An internal class to get the nearest node id,
     * the node id for both manual search and API search would be needed
     */
    public class WalkingSelector implements IVehicle {

        public boolean isAllowed(IDataSet ids, Node node) {
            return true;
        }

        public boolean isReverseOneway(IDataSet ids, Way way) {
            return false;
        }

        public boolean isOneway(IDataSet ids, Way way) {
            return false;
        }

        public boolean isAllowed(IDataSet ids, Way way) {
            return true;
        }

        public boolean isAllowed(IDataSet ids, Relation rltn) {
            return true;
        }

        public ConfigurationSection getSettings() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
