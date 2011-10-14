/*
 * Saving.java
 *
 * Created on 4th of May, 2011, 3:54:19 PM
 */
package Logic.History;

import Logic.MyNode;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class Saving provides a method named "save" that saves 
 * some nodes' information to a file.
 * @author Amir Almasi
 * @Version: 0.1
 */
public class Saving {

    // variable declaration
    private String fileAddress;

    /**
     * no-arg constructor
     */
    public Saving() {
    }

    /**
     * Constructor 
     * @param fileAddress
     */
    public Saving(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    /**
     * Gets a list of nodes, writes nodes' coordinates to the file "save".
     * @param list ArrayList<MyNode> the nodes to be saved.
     */
    public void save(ArrayList<MyNode> list) {
        try {
            File file = new File(fileAddress);
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < list.size(); i++) {
                writer.write(String.valueOf(list.get(i).getLatitude()) + ",");
                writer.write(String.valueOf(list.get(i).getLongitude()) + "\n");
            }
            writer.close();
        } catch (Exception exception) {
        }
    }
}
