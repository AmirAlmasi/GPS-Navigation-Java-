/*
 * NMEAProcessor.java
 *
 * Created on Feb 25, 2011, 10:45:46 Am
 * Edited on Mar 15, 2011, 03:20:55 PM
 */
package GPS_Reader;

import Logic.MyNode;
import java.util.StringTokenizer;

/**
 *
 * This class provides methods in order to process four types of the sentences (GGA, GSA, GSV, and RMC)
 * received by the GPS unit.
 * @author Mozhan
 * @version 0.3
 *
 */
public class NMEAProcessor {

    /**
     *  no-arg constructor
     */
    public NMEAProcessor() {
    }

    /**
     *
     * This method gets a String(NMEA sentence) and according to the type of the sentence
     * a proper method would be invoked. In case of receiving a sentence other than the four
     * types( GGA, GSA, GSV, RMC) anticipated, null value would be returned.
     * @param sentence
     *
     */
    public MyNode processNMEA(String sentence) {

        // If the received String is GGA sentence, processGGA(sentence) would be returned.
        if (sentence.contains("$GPGGA")) {
            return processGGA(sentence);
        }

        //If the received String is GSA sentence, processGSA(sentence) would be returned.

        //If the received String is GSV sentence, processGSV(sentence) would be returned.

        //If the received String is RMC sentence, processRMC(sentence) would be returned.
        if (sentence.contains("$GPRMC")) {
            return processRMC(sentence);
        }
        //  If an unfamiliar sentence has been received.
        if ((!sentence.contains("$GPGGA")) && (!sentence.contains("$GPGSA")) && (!sentence.contains("$GPGSV")) && (!sentence.contains("$GPRMC"))) {
//            System.out.println(" Class NMEAProcessor.method processNMEA." + " !An unfamiliar sentence has been received!");
        }

        // If any sentence has not been received, null value would be returned.
        return null;
    } // end of method processNMEA

    /**
     * This method receives GGA sentence and sets its components
     *  to relevant attributes defined for objects of Node.
     * @param GGA
     *
     */
    private MyNode processGGA(String GGA) {
        MyNode node = new MyNode();
        StringTokenizer tokenizer = new StringTokenizer(GGA, ",");
        for (int i = 1; i < 10; i++) {
            String temp = tokenizer.nextToken();
            switch (i) {
                case 1:
                    break;
                case 2:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                String first = null, middle = null, last = null;
                                int localHour, hour;
                                hour = Integer.parseInt(temp.substring(0, 1));
                                if (hour == 23) {
                                    hour = -01;
                                }
                                if (hour == 24) {
                                    hour = 00;
                                }
                                localHour = hour + 1;
                                first.valueOf(localHour);
                                middle = temp.substring(2, 3);
                                last = temp.substring(4, 5);
                                node.setTime(first.concat(":".concat(middle.concat(":".concat(last)))));
                            } // end of try
                            catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received UTC is not valid!");
                            }
                        } // end of inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received UTC " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of outer if
                    else {
//                        System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received UTC is empty!");
                    }
                case 3:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                node.setLatitude(makeCoordinate(temp));
                            } catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received latitude is not valid!");
                            }
                        } // end of first inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received latitude " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of the outer if block
                    else {
//                        System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received latitude is empty!");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                node.setLongitude(makeCoordinate(temp));
                            } catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received longitude is not valid!");
                            }
                        } // end of first inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received longitude " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of the outer if block
                    else {
//                        System.out.println(" Class NMEAProcessor.method processGGA." + " ! The received longitude is empty!");
                    }
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
            }
        }   // end of for loop including switch
        return node;
    } // end of processGGA method

    /**
     * This method receives GSA sentence and sets its components
     *  to relevant attributes defined for objects of Node.
     * @param GSA
     *
     */
    private MyNode processGSA(String GSA) {
        return null;
    }  // end of processGSA method

    /**
     * This method receives GSV sentence and sets its components
     *  to relevant attributes defined for objects of Node.
     * @param GSV
     *
     */
    private MyNode processGSV(String GSV) {

        return null;
    }  // end of processGSV method

    /**
     * This method receives RMC sentence and sets its components
     *  to relevant attributes defined for objects of Node.
     * @param RMC
     *
     */
    private MyNode processRMC(String RMC) {
        MyNode node = new MyNode();
        StringTokenizer tokenizer = new StringTokenizer(RMC, ",");
        for (int i = 1; i < 14; i++) {
            String temp = tokenizer.nextToken();
            switch (i) {
                case 1:
                    break;
                case 2:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                String first = null, middle = null, last = null;
                                int localHour, hour;
                                hour = Integer.parseInt(temp.substring(0, 2));
                                if (hour == 23) {
                                    hour = -01;
                                }
                                if (hour == 24) {
                                    hour = 00;
                                }
                                localHour = hour + 1;
                                first = String.valueOf(localHour);
                                middle = temp.substring(2, 4);
                                last = temp.substring(4, 6);
                                node.setTime(first.concat(":".concat(middle.concat(":".concat(last)))));
                            } // end of try
                            catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received UTC is not valid!");
                            }
                        } // end of inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received UTC " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of outer if
                    else {
//                        System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received UTC is empty!");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                node.setLatitude(makeCoordinate(temp));
                            } catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received latitude is not valid!");
                            }
                        } // end of first inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received latitude " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of the outer if block
                    else {
//                        System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received latitude is empty!");
                    }
                    break;
                case 5:
                    break;
                case 6:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                node.setLongitude(makeCoordinate(temp));
                            } catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received longitude is not valid!");
                            }
                        } // end of first inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received longitude " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of the outer if block
                    else {
//                        System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received longitude is empty!");
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {

                            try {
                                double speed = Double.parseDouble(temp);
                                node.setSpeed(speed);
                            } // end of try
                            catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received Speed " + "(" + temp + ") " + "is not valid");
                            }
                        } // end of second id
                        else {
//                            System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received Speed " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of first if
                    else {
//                        System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received Speed " + "(" + temp + ") " + "is empty!");
                    }
                    break;
                case 9:
                    break;
                case 10:
                    if (!temp.isEmpty()) {
                        if (!temp.contains("?")) {
                            try {
                                if (temp.length() == 6) {
                                    int first, middle, last;
                                    first = Integer.parseInt(temp.substring(0, 2));
                                    middle = Integer.parseInt(temp.substring(2, 4));
                                    last = Integer.parseInt(temp.substring(4, 6));
                                    node.setDate(String.valueOf(first).concat("/").concat(String.valueOf(middle).concat("/").concat(String.valueOf(last))));
                                }

                            } // end of try
                            catch (Exception e) {
//                                System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received Date is not valid!");
                            }
                        } // end of second inner if
                        else {
//                            System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received Date " + "(" + temp + ") " + "is not known!");
                        }
                    } // end of outer if
                    else {
//                        System.out.println(" Class NMEAProcessor.method processRMC." + " ! The received Date is empty!");
                    }
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
            } // end of switch
        }// end of for
        return node;
    } // end of processRMC method

    /**
     * This method gets a String and returns a double value which would be
     * used as either a latitude or a longitude.
     * @param decimalValue
     * @return
     */
    private Double makeCoordinate(String decimalValue) {
        String leftPart, rightPart;
        Double coordinate;
        leftPart = decimalValue.substring(0, decimalValue.indexOf(".") - 2);
        rightPart = decimalValue.substring(decimalValue.indexOf(".") - 2, decimalValue.length());
        coordinate = Double.parseDouble(leftPart) + Double.parseDouble(rightPart) / 60;
        //   System.out.println("left part:   "+leftPart +      "  right part:   " + rightPart);
        return coordinate;
    } // end of method makeCoordinate.
} // end of class

