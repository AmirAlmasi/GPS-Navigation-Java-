/*
 * Path.java
 *
 * Created on Mar 21, 2011, 09:59:59 PM
 */
package Logic.SearchEngine.Manual;

/**
 * A class to keep the object of each path between two points
 * @author Amir Almasi
 * @version 0.2
 */
public class Path {

    //declaration of variables
    private Edge edge;
    private double weight;
    private WaypointNode target;

    // non-argument constructor
    public Path() {
    }

    /**
     * Each path contains one edge, weight, and target
     * @param edge
     * @param weight
     * @param target
     */
    public Path(Edge edge, double weight, WaypointNode target) {
        this.edge = edge;
        this.weight = weight;
        this.target = target;
    }

    // getters and setters
    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public double getWeigth() {
        return weight;
    }

    public void setWeigth(double weigth) {
        this.weight = weigth;
    }

    public WaypointNode getTarget() {
        return target;
    }

    public void setTarget(WaypointNode target) {
        this.target = target;
    }
}
