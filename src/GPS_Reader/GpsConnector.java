/*
 * GpsConnector.java
 * This class was implemented according to the material adopted from the given
 * website below:
 * http://edn.embarcadero.com/article/31915
 * As the API was suppoes to be used, some reseaches was done and finally this code
 * considering the studies material was prepared.
 * 
 * Created on Mar 09, 2011, 01:31:27 AM
 */
package GPS_Reader;

import gnu.io.*;
import java.io.*;
import java.util.*;

/**
 * A class to connect to GPS-Device and receive the information as Strings.
 * @author Amir Almasi
 * @version 0.2
 * @see http://edn.embarcadero.com/article/31915
 */
public class GpsConnector implements Runnable, SerialPortEventListener {

    static CommPortIdentifier thePortId;
    private String signalString = "";
    private InputStream inputStream;
    private SerialPort theSerialPort;
    private Thread thread;
    static String elapse;

    /**
     * The run method to use it in thread 
     */
    public void run() {
        //linux version of the connecting to the proper port.
//        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
//        while (ports.hasMoreElements()) {
//            thePortId = (CommPortIdentifier) ports.nextElement();
        try {
            thePortId = CommPortIdentifier.getPortIdentifier("COM19");
//                thePortId = CommPortIdentifier.getPortIdentifier(thePortId.getName());
//                System.out.println(thePortId.getName());
        } catch (Exception e) {
            elapse = new java.util.Date().toString();
            System.out.println(elapse + ": COM19 " + thePortId);
        }
//        }

        try {
            elapse = new java.util.Date().toString();
            theSerialPort = (SerialPort) thePortId.open("GpsConnector", 2000);

        } catch (PortInUseException e) {
        }
        try {
            inputStream = theSerialPort.getInputStream();
        } catch (IOException e) {
        }
        try {
            theSerialPort.addEventListener(this);
        } catch (TooManyListenersException e) {
        }
        theSerialPort.notifyOnDataAvailable(true);
        try {

            theSerialPort.setSerialPortParams(4800,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            theSerialPort.setDTR(false);
            theSerialPort.setRTS(false);

        } catch (UnsupportedCommOperationException e) {
        }

        thread = new Thread(this);
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    /**
     *  The method to handle the serial events.
     * @param event
     */
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                StringBuffer readBuffer = new StringBuffer();
                int c;
                try {
                    while ((c = inputStream.read()) != 10) {
                        if (c != 13) {
                            readBuffer.append((char) c);
                        }
                    }
                    String scannedInput = readBuffer.toString();
                    elapse = new java.util.Date().toString();
                    setGetSignalString(scannedInput);
                    inputStream.close();
                } catch (IOException e) {
                }

                break;
        }
    }

    // getters and setters
    public String getGetSignalString() {
        return signalString;
    }

    public void setGetSignalString(String getSignalString) {
        System.out.println(getSignalString);
        this.signalString = getSignalString;
    }
}
