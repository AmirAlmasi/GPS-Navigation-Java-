/*
 * WaypointNode.java
 *
 * Created on Mar 22, 2011, 10:22:30 AM
 */
package Logic.SearchEngine.Manual;

import java.util.ArrayList;

/**
 * The class to keep each waypoint
 * @author Amir Almasi
 * @version 0.1
 */
public class WaypointNode {

    // declaration of the variables
    private String id;
    private double latitude;
    private double longitude;
    private String user;
    private String uid;
    private boolean visible = false;
    private byte version;
    private String timestamp;
    private WaypointNode previousNode = null;
    private double shortestDistance = Double.MAX_VALUE;
    private String firstNodeId;
    private String EdgeId;
    // variables which are used by searching methods
    public ArrayList<WaypointInfo> waypointInfo = new ArrayList<WaypointInfo>();

    /*
     * non-argument constructor
     */
    public WaypointNode() {
    }

    /**
     * Constructor
     * @param id
     * @param latitude
     * @param longitude
     * @param user
     * @param uid
     * @param visible
     * @param version
     * @param timestamp
     */
    public WaypointNode(String id, double latitude, double longitude,
            String user, String uid, boolean visible, byte version,
            String timestamp) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
        this.uid = uid;
        this.visible = visible;
        this.version = version;
        this.timestamp = timestamp;
    }

    // getters and setters
    public String getFirstNodeId() {
        return firstNodeId;
    }

    public void setFirstNodeId(String firstNodeId) {
        this.firstNodeId = firstNodeId;
    }

    public WaypointNode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WaypointNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(WaypointNode previousNode) {
        this.previousNode = previousNode;
    }

    public double getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(double shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    //override methods
    @Override
    public boolean equals(Object obj) {
        WaypointNode n = (WaypointNode) obj;
        return this.id.hashCode() == n.id.hashCode();
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
