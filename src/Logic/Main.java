/*
 * Main.Java
 *
 * Created on Feb 20, 2011
 * Edited on Mar 21, 2011, 9:07:02 PM
 */
package Logic;

import GUI.LoadScreen;
import GUI.Map;

/**
 * The main class to run.
 * @author Amir Almasi
 * @version 0.3
 */
public class Main {

    private Map map;
    private LoadScreen load;
    private Thread loadScreenThread;

    /**
     * Constructor
     */
    public Main() {
        try {
            load = new LoadScreen();
            map = new Map();
            loadScreenThread = new Thread(load);
            loadScreenThread.start();
            loadScreenThread.join();
            map.setVisible(true);
            map.showMap();
        } catch (InterruptedException ex) {
            System.out.println("there was something wrong with the waitting for"
                    + " the thread to be finished ");
        }
    }

    /**
     * The main method to run the software.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
}
