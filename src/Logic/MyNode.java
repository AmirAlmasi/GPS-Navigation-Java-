/*
 * Node.java
 *
 * Created on Mar 22, 2011, 12:34:43 PM
 */
package Logic;

/**
 * A class which would be made of the received string from GPS-device by StringProcessor class
 * @author Amir Almasi
 * @version 0.1
 */
public class MyNode {

    // declaration of the variables 
    private double speed;
    private double longitude;
    private double latitude;
    private int satelliteNumber;
    private String time;
    private String date;
    private int fixQuality;
    private float positionDilutio;
    private double altitude;
    private double geoid;
    private String checkSum;
    private double degrees;
    private String waypointName;
    private int waypointId;

    //All getters and setters
    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    public int getFixQuality() {
        return fixQuality;
    }

    public void setFixQuality(int fixQuality) {
        this.fixQuality = fixQuality;
    }

    public double getGeoid() {
        return geoid;
    }

    public void setGeoid(double geoid) {
        this.geoid = geoid;
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

    public float getPositionDilutio() {
        return positionDilutio;
    }

    public void setPositionDilutio(float positionDilutio) {
        this.positionDilutio = positionDilutio;
    }

    public int getSatelliteNumber() {
        return satelliteNumber;
    }

    public void setSatelliteNumber(int satelliteNumber) {
        this.satelliteNumber = satelliteNumber;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(int waypointId) {
        this.waypointId = waypointId;
    }

    public String getWaypointName() {
        return waypointName;
    }

    public void setWaypointName(String waypointName) {
        this.waypointName = waypointName;
    }
}
