/*
 * Controler.java
 *
 * Created on Mar 23, 2011, 2:54:19 PM
 * Edited on May 2, 2011, 3:55:12 PM
 * Adding related methods to navigation between the locFile by calling Dijkstra methods
 * Edited on May 5, 2011, 12:03:15 PM
 * Changing the way to navigate to the waypoints in the loc file,
 * the way it was, navigating to all waypoints, is changed now to the way that,
 * navigate to a specefic waypoint in the loc file by asking user the number of
 * prefered waypoint.
 * edit the current location of the user, if it is not valid then the last valid
 * current location would be returned.
 */
package Logic;

import GPS_Reader.CoordinateProcessor;
import GPS_Reader.GpsConnector;
import GPS_Reader.NMEAProcessor;
import Logic.History.Loading;
import Logic.History.Saving;
import Logic.SearchEngine.Manual.WaypointNode;
import Logic.SearchEngine.SearchCore;
import Logic.XMLReader.ReadLOCFile;
import Sound.ArrivalAlarm;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * The main class ( brain of the software ) to control the different parts and classes.
 * @author Amir Almasi
 * @version 0.5
 */
public class Controler implements Runnable {

    // variables declaration
    private MyNode userCurrentLocation;
    private GpsConnector gpsConnector;
    private SearchCore search;
    private Thread searchThread;
    private Thread gpsConnectorThread;
    private CoordinateProcessor coordinateProcessor;
    private ReadLOCFile readLOCFile;
    private final String LOCFileAddress = "sources//geocachingTest.loc";
    private final String OSM_XMLFile = "sources//map.osm";
    private final String alarmFile30 = "sources//Sounds//30.MP3";
    private final String alarmFile10 = "sources//Sounds//10.MP3";
    private final String alarmFile5 = "sources//Sounds//5.MP3";
    private final String wrongAlarm = "sources//Sounds//wrongAlarm.MP3";
    private final String textWaypoint = "sources//TestFile//saveInput.txt";
    private final String loadWaypoint = "sources//TestFile//saveInput.txt";
    private MyNode destination;
    private boolean reachedFlag30 = false;
    private boolean reachedFlag20 = false;
    private boolean reachedFlag10 = false;
    private boolean reachedFlag5 = false;
    private boolean reachedFlag1 = false;
    private ArrayList<MyNode> passedways = new ArrayList<MyNode>();
    private double distance = Double.MAX_VALUE;

    /**
     * non-argument constructor
     */
    public Controler() {
        userCurrentLocation = new MyNode();
        userCurrentLocation.setLatitude(57.7069);
        userCurrentLocation.setLongitude(11.9369);
    }

    /**
     * to run the program
     */
    public void run() {
        search = new SearchCore(OSM_XMLFile);
        searchThread = new Thread(search);
        gpsConnector = new GpsConnector();
        gpsConnectorThread = new Thread(gpsConnector);
        searchThread.start();
        gpsConnectorThread.start();
    }

    /**
     * A method to get the string from GPS-Device continuously
     * @return boolean
     *  -->true if  the input, received signal, is correct.
     *  -->false if  the input, received signal, is  incorrect.
     */
    public boolean getLocation() {
        MyNode temp = new NMEAProcessor().processNMEA(gpsConnector.getGetSignalString());
        if (temp != null) {
            userCurrentLocation = temp;
            passedways.add(temp);
            return true;
        }
        return false;
    }

    /**
     * A method to calculate the distance between two points on the screen.
     * @param disLatitude2 the destination latitude.
     * @param disLongitude2 the destination longitude.
     * @return String of the distance.
     */
    public String getDistance(double disLatitude2, double disLongitude2) {
        return String.valueOf(new CoordinateProcessor().getDistance(userCurrentLocation.getLatitude(), disLatitude2, userCurrentLocation.getLongitude(), disLongitude2));
    }

    /**
     * A method to check either if we are reaching the destination to play the an alarm
     * or we are on a wrong way to play wrong way sound.
     * @return boolean
     * --> False if the user is on a wrong way.
     * --> Otherwise true.
     */
    public boolean checkDistance() {
        double distanceTemp = new CoordinateProcessor().getDistance(userCurrentLocation.getLatitude(), destination.getLatitude(), userCurrentLocation.getLongitude(), destination.getLongitude());
        if (distanceTemp < 5000) {
            if (distanceTemp < distance) {
                distance = distanceTemp;
                if (distance < 5) {
                    if (!reachedFlag5) {
                        System.out.println("Class Controler, method checkDistance: Yes!! we reached the destination");
                        alarm(alarmFile5);
                        reachedFlag5 = true;
                    }
                } else {
                    if (distance < 10) {
                        if (!reachedFlag10) {
                            System.out.println("Class Controler, method checkDistance: Yes!! we reached the destination");
                            alarm(alarmFile10);
                            reachedFlag10 = true;
                        }
                    } else {
                        if (distance < 30) {
                            if (!reachedFlag30) {
                                System.out.println("Class Controler, method checkDistance: Yes!! we reached the destination");
                                alarm(alarmFile30);
                                reachedFlag30 = true;
                            }
                        }
                    }
                }
            } else {
                if ((distanceTemp - distance) > 10) {

                    alarm(wrongAlarm);
                    return false;
                }
            }
        }
        return true;
//        }
    }

    /**
     * A method to call Dijkstra method.
     * @param latitude1 the source latitude.
     * @param longitude1 the source longitude.
     * @param latitude2 the destination latitude.
     * @param longitude2 the destination longitude.
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return the ArrayList of the waypoints which shows the best way
     */
    public ArrayList<Logic.SearchEngine.Manual.WaypointNode> implementsDijkstra(double latitude1, double longitude1, double latitude2, double longitude2, int wayType) {
        return search.manualDijkstra(latitude1, longitude1, latitude2, longitude2, wayType);
    }

    /**
     * A method to check if the cursor of the mouse is on a node in .XML file or not.
     * @param latitude mouse cursor latitude on the map.
     * @param longitude mouse cursor longitude on the map.
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return the ArrayList of the Waypoints which shows the best way
     */
    public boolean checkMouseArea(double latitude, double longitude, int wayType) {
        if (search.checkMouseArea(latitude, longitude, wayType)) {
            return true;
        }
        return false;
    }

    /**
     * A method to read the LOC file
     * @return ArrayList<MyNode> the waypoints which are in the loc file.
     */
    public ArrayList<MyNode> readLocFile() {
        return new ReadLOCFile().readLoc(LOCFileAddress);
    }

    /**
     * A method to implement navigation to nodes in the LOC file
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return the ArrayList of the Waypoints which shows the best way
     */
    public ArrayList<Logic.SearchEngine.Manual.WaypointNode> locNavigation(int wayType, int locNumber) {
        ArrayList<MyNode> locNodes = new ReadLOCFile().readLoc(LOCFileAddress);
        return (implementsDijkstra(userCurrentLocation.getLatitude(), userCurrentLocation.getLongitude(), locNodes.get(locNumber).getLatitude(), locNodes.get(locNumber).getLongitude(), wayType));
    }

    /**
     * A method to read the text file of the passed waypoints.
     * @return ArrayList<WaypointNode> contains the waypoints of user passed way.
     */
    public ArrayList<WaypointNode> loadFromFile() {
        return new Loading(loadWaypoint).load();
    }

    /**
     * A method to save all passed ways in a text file.
     * @return boolean
     * --> True if saving process was finished well.
     * --> False if saving process was not finished properly.
     */
    public boolean saveToFile() {
        try {
            new Saving(textWaypoint).save(passedways);
            return true;
        } catch (Exception e) {
        }
        return false;

    }

    /**
     * A method to play the proper alarm in the thread.
     * @param fileName of the proper alarm
     */
    public void alarm(String fileName) {
        new Thread(new ArrivalAlarm(fileName)).start();
    }

    /**
     * A method to set the destination of the user each time.
     * @param lat latitude
     * @param lon longitude
     */
    public void setDestination(double lat, double lon) {
        MyNode destination = new MyNode();
        destination.setLatitude(lat);
        destination.setLongitude(lon);
        this.destination = null;
        this.destination = destination;
    }

    /**
     * A method to reset the ArrayList of waypoints kept.
     */
    public void resetSave() {
        passedways.clear();
        JOptionPane.showMessageDialog(null, "The previously saved locations have now been reset.");
    }

    /**
     * A method to reset Dijkstra and destination.
     */
    public void resetShoertestPath() {
        this.destination = null;
        setDistance(Double.MAX_VALUE);
        setReachedFlag30(false);
        setReachedFlag20(false);
        setReachedFlag10(false);
        setReachedFlag5(false);
        setReachedFlag1(false);
        setDestination(0.0, 0.0);
    }

    // getters and setters 
    public MyNode getUserCurrentLocation() {
        return userCurrentLocation;
    }

    public void setUserCurrentLocation(MyNode userCurrentLocation) {
        this.userCurrentLocation = userCurrentLocation;
    }

    public MyNode getDestination() {
        return destination;
    }

    public boolean isReachedFlag1() {
        return reachedFlag1;
    }

    public void setReachedFlag1(boolean reachedFlag1) {
        this.reachedFlag1 = reachedFlag1;
    }

    public boolean isReachedFlag10() {
        return reachedFlag10;
    }

    public void setReachedFlag10(boolean reachedFlag10) {
        this.reachedFlag10 = reachedFlag10;
    }

    public boolean isReachedFlag20() {
        return reachedFlag20;
    }

    public void setReachedFlag20(boolean reachedFlag20) {
        this.reachedFlag20 = reachedFlag20;
    }

    public boolean isReachedFlag30() {
        return reachedFlag30;
    }

    public void setReachedFlag30(boolean reachedFlag30) {
        this.reachedFlag30 = reachedFlag30;
    }

    public boolean isReachedFlag5() {
        return reachedFlag5;
    }

    public void setReachedFlag5(boolean reachedFlag5) {
        this.reachedFlag5 = reachedFlag5;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
