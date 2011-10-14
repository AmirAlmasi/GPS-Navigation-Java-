/*
 * Edge.java
 *
 * Created on Mar 21,2011, 9:59:48 PM
 */
package Logic.SearchEngine.Manual;

/**
 * A class to keep the objects of the edge
 * @author Amir Almasi
 * @version 0.2
 * 
 */
public class Edge {

    //declaration of the variables
    private String id;

    /**
     * no- argument constructor
     */
    public Edge() {
    }

    // getters and setters
    public Edge(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
