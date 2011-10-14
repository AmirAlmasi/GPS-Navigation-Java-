/*
 * Way.java
 *
 * Created on Mar 21, 2011, 10:00:57
 */
package Logic.SearchEngine.Manual;

import java.util.ArrayList;

/**
 * A class to keep the object ways among nodes
 * @author Amir Almasi
 * @version 0.2
 *
 */
public class Way {

    //declaration of variables
    private String id;
    private String user;
    private String uid;
    private boolean visible;
    private byte version;
    private String timestamp;
    public ArrayList<WaypointNode> allNodesInWay = new ArrayList<WaypointNode>();
    public ArrayList<WaypointInfo> wayInfo = new ArrayList<WaypointInfo>();

    /**
     * non-argument constructor
     */
    public Way() {
    }

    /**
     * each way contains one edge, weight, and target
     * @param edge
     * @param weight
     * @param target
     */
    public Way(String id, String user, String uid, boolean visible, byte version,
            String timestamp) {
        this.id = id;
        this.user = user;
        this.uid = uid;
        this.visible = visible;
        this.version = version;
        this.timestamp = timestamp;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
