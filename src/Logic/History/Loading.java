/*
 * Loading.java
 *
 * Created on May 8, 2011, 2:54:19 PM
 */
package Logic.History;

import Logic.SearchEngine.Manual.WaypointNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Class Loading provides a method named load that reads a file and returns
 * a list of previously saved nodes.
 * @author Amir Almasi
 * @version 0.1
 */
public class Loading {

    // variable declaration
    private String fileAddress;
    private ArrayList<WaypointNode> list = new ArrayList<WaypointNode>();

    /**
     * no-arg constructor
     */
    public Loading() {
    }

    /**
     * Constructor
     * @param fileAddress of the text file.
     */
    public Loading(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    /**
     * A method to load the passed waypoints from a text file.
     * @returns ArrayList<WaypointNode> a list of saved nodes received from a file.
     */
    public ArrayList<WaypointNode> load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
            String line = reader.readLine();
            while (line != null) {
                WaypointNode node = new WaypointNode("");
                StringTokenizer tokenizer = new StringTokenizer(line);
                node.setLatitude(Double.parseDouble(tokenizer.nextToken(",")));
                node.setLongitude(Double.parseDouble(tokenizer.nextToken()));
                list.add(node);
                line = reader.readLine();
            }
        } catch (Exception exception) {
        }
        return list;
    }  // end of method load.
} // end of class
