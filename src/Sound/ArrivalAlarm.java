/**
 * ArivalAlarm.java
 *
 * Created on May 16, 2011, 11:55:11 AM
 * This class is using one jar file to play the sound.
 * The library name is: jl1.0.1.jar.
 * @see http://introcs.cs.princeton.edu/java/faq/mp3/mp3.html
 */
package Sound;

import javazoom.jl.player.Player;
import java.io.FileInputStream;

/**
 * This class is used as a proximity alarm, it informs the user
 * when they are either far away or near the location,
 * the class is implementing the runnable to be used in threads.
 * @author Amir Almasi
 * @version 0.1
 * @see http://introcs.cs.princeton.edu/java/faq/mp3/mp3.html
 */
public class ArrivalAlarm implements Runnable {

    // variable declaration
    private String fileAddress = null;

    /**
     * non-argument constructor
     */
    public ArrivalAlarm() {
    }

    /**
     * Constructor to set the file address
     * @param fileAddress of the sound
     */
    public ArrivalAlarm(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    /**
     * A method to play the arrival alarm
     */
    private void play() {
        try {
            FileInputStream fis = new FileInputStream(fileAddress);
            Player play = new Player(fis);
            play.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * The run method to use it in the thread
     */
    public void run() {
        play();
    }
} // end of class

