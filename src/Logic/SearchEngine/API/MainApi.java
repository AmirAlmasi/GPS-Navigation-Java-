/*
 * MainApi.java
 *
 * Created on Mar 22, 2011, 
 */
package Logic.SearchEngine.API;

/**
 *  A class to test the APISearch class, this is made for testing the API separately,
 * This class is not used in the project at all.
 * @author Amir Almasi
 * @version 0.1
 */
class MainApi {

    /**
     * The main method to test the API search class
     * @param args
     */
    public static void main(String[] args) {
        APISearch APISearchTest = new APISearch();
        APISearchTest.dijkstra(57.7090, 11.9350, 57.7070, 11.9280);
    }
}
