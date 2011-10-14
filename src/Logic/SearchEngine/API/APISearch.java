/*
 * APISearch.java
 *
 * Created on Mar 22, 2011, 10:40:06 AM
 *
 * This class was implemented according to the material adopted from the given
 * website below:
 * @see http://sourceforge.net/apps/mediawiki/travelingsales/index.php?title=OSMNavigation
 * @see http://sourceforge.net/apps/mediawiki/travelingsales/index.php?title=TS/Examples
 * As the API was suppoes to be used, some reseaches was done and finally this code
 * considering the studies material was prepared.
 * 
 */
package Logic.SearchEngine.API;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.openstreetmap.osm.data.MemoryDataSet;
import org.openstreetmap.osm.data.coordinates.LatLon;
import org.openstreetmap.osm.data.searching.NearestStreetSelector;
import org.openstreetmap.osmosis.core.domain.v0_6.*;
import org.openstreetmap.travelingsalesman.routing.Route;
import org.openstreetmap.travelingsalesman.routing.routers.TurnRestrictedMultiTargetDijkstraRouter;
import org.openstreetmap.travelingsalesman.routing.selectors.Motorcar;
import org.jdesktop.swingx.mapviewer.Waypoint;
import org.openstreetmap.travelingsalesman.routing.Route.RoutingStep;

/**
 * This class finds the best way by using API
 * @author Amir Almasi
 * @see http://sourceforge.net/apps/mediawiki/travelingsales/index.php?title=OSMNavigation
 * @see http://sourceforge.net/apps/mediawiki/travelingsales/index.php?title=TS/Examples
 * @version 0.1
 */
public class APISearch {

    // variables declaration
    private Set<Waypoint> waypointSet = new HashSet<Waypoint>();
    private ArrayList<Long> nodeId = new ArrayList<Long>();
    private MemoryDataSet map = (new org.openstreetmap.osm.io.FileLoader(new File("C://Users//Emertat//Desktop//gpsmap//map.osm"))).parseOsm();

    /**
     * A method to implement the Dijkstra by using API
     * @param TESTSTARTLAT
     * @param TESTSTARTLON
     * @param TESTENDLAT
     * @param TESTENDLON
     */
    public void dijkstra(double TESTSTARTLAT, double TESTSTARTLON, double TESTENDLAT, double TESTENDLON) {
        try {
            NearestStreetSelector nSS = new NearestStreetSelector();
            Motorcar vehicle = new Motorcar();
            LatLon startCoord = new LatLon(TESTSTARTLAT, TESTSTARTLON);
            Node startNode = map.getNearestNode(startCoord, nSS);
            System.out.print(startNode.getId());
            LatLon targetCoord = new LatLon(TESTENDLAT, TESTENDLON);
            Node targetNode = map.getNearestNode(targetCoord, nSS);
            TurnRestrictedMultiTargetDijkstraRouter dijkstra = new TurnRestrictedMultiTargetDijkstraRouter();
//            DijkstraRouter dijkstra = new DijkstraRouter();
            Route theRoute = dijkstra.route(map, targetNode, startNode, vehicle);
//            theRoute.
            Set<Waypoint> wpSet = new HashSet<Waypoint>();
            ArrayList<Node> node = new ArrayList<Node>();
            for (RoutingStep rs : theRoute.getRoutingSteps()) {
                Node wayPoint = rs.getStartNode();
                wpSet.add(new Waypoint(wayPoint.getLatitude(), wayPoint.getLongitude()));
                for (WayNode wn : rs.getNodes()) {
                    node.add(map.getNodeByID(wn.getNodeId()));
                }
            }
            //Route r = router.route(map, targetNode, startNode, vehicle);
        } catch (Exception ex) {
        }
    }
}
