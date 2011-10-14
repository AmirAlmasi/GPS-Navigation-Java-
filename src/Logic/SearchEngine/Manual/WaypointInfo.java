/*
 * WaypointInfo.java
 *
 * Created on Mar 23, 2011, 06:39:33 PM
 */
package Logic.SearchEngine.Manual;

/**
 * The class to keep the information of either each node or way
 * @author Amir Almasi
 * @version 0.1
 */
public class WaypointInfo {

    // variable declaration
    private String key = null;
    private String value = null;
    private String objectKey = null;

    /**
     * non-argument constructor
     */
    public WaypointInfo() {
    }

    /**
     * Constructor
     * @param key
     * @param value
     */
    public WaypointInfo(String key, String value) {
        this.key = key;
        this.value = value;
        this.objectKey = key + " " + value;
    }

    // Getters and setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // override methods
    @Override
    public boolean equals(Object obj) {
        WaypointInfo temp = (WaypointInfo) obj;
        return (temp.key + " " + temp.value).contains(this.key);
    }

    @Override
    public String toString() {
        return (this.key + " " + this.value);
    }
}
