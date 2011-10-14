/*
 * CoordinateProcessor.java
 *
 * Created on Mar 20, 2011, 01:31:27 AM
 */
package GPS_Reader;

/**
 * The class contains the methods to work with coordinates and process them.
 * @author Amir Almasi
 * @version 0.1
 */
public class CoordinateProcessor {

    /**
     * The method converts the decimal coordinates to degree coordinates.
     * @param decimalValue The decimal value which will be converted
     * @return double of degree coordinated made by decimal coordinate
     */
    public Double makeCoordinate(String decimalValue) {
        String leftPart, rightPart;
        Double coordinate;
        leftPart = decimalValue.substring(0, decimalValue.indexOf(".") - 2);
        rightPart = decimalValue.substring(decimalValue.indexOf(".") - 2, decimalValue.length());
        coordinate = Double.parseDouble(leftPart) + Double.parseDouble(rightPart) / 60;
        //   System.out.println("left part:   "+leftPart +      "  right part:   " + rightPart);
        return coordinate;
    } // end of method makeCoordinate.

    /**
     * The method computes the distance between two waypoints on the map.
     * @param latitude1 the first lat
     * @param latitude2 the destination lat
     * @param longitude1 the first lon
     * @param longitude2 the destination lon
     * @return double value of the distance between two points
     */
    public double getDistance(double latitude1, double latitude2, double longitude1, double longitude2) {
        final int EarthRadius = 6371000; // It is in meters scale.
        double latitude_difference = Math.toRadians(latitude2 - latitude1);
        double longitude_difference = Math.toRadians(longitude2 - longitude1);
        double a = (Math.sin(latitude_difference / 2) * Math.sin(latitude_difference / 2))
                + (Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(longitude_difference / 2) * Math.sin(longitude_difference / 2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EarthRadius * c;
        return distance;
    }
}
