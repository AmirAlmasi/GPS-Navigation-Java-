/*
 * Dijkstra.java
 *
 * Created on Mar 23, 2011, 6:57:35 PM
 */
package Logic.SearchEngine.Manual;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class provides manually searched based called Dijkstra 
 * @author Amir Almasi
 * @version 0.2
 */
class Dijkstra {

    //variable declaration
    protected ArrayList<WaypointNode> list_N = new ArrayList<WaypointNode>(); // the last list of the vertex to reach the target
    protected ArrayList<WaypointNode> visitedNodes = new ArrayList<WaypointNode>(); //the list of the nodes which have been visited
    protected HashMap<WaypointNode, ArrayList<Path>> allNodes = new HashMap<WaypointNode, ArrayList<Path>>();// the HashMap which keeps the whole graph

    /**
     *  no-arg constructor
     */
    Dijkstra() {
    }

    /**
     *  A method to give a father node and return an array list of the children.
     */
    protected ArrayList<Path> getChildren(WaypointNode father) {
        if (allNodes.containsKey(father)) {
            return allNodes.get(father);
        }
        return new ArrayList<Path>();
    }

    /**
     *  A method to calculate the children's distance and updating them in the visitedNodes list
     * @param children , an Arraylist of adjacency paths which contains the nodes as well.
     * @param father
     */
    protected void calculateDistance(ArrayList<Path> children, WaypointNode father, int wayType) {

        for (int i = 1; i < children.size(); i++) {
            /*
             * the searched based would be check in here on food or by car
             */
//            switch (wayType) {
//                case 0:
//                    System.out.println("name of node: " +children.get(i).getTarget().getId());
//                    for (int j = 0 ; j< children.get(i).getTarget().waypointInfo.size();j++){
//                        System.out.print("waypointInfo" + children.get(i).getTarget().waypointInfo.get(j)+"  ");
//                    }
//                    System.out.println();
//                    if(!children.get(i).getTarget().waypointInfo.contains(new WaypointInfo("foot", null))){
//                        System.out.println("the node does not have foot continue: " + children.get(i).getTarget().getId());
//                        continue;
////                    ArrayList<WaypointInfo> list2 = new ArrayList<WaypointInfo>();
////                    list2.add(new WaypointInfo("foot", null));
////                    if (new FootWayComparator().compare(children.get(i).getTarget().waypointInfo, list2)== -1) {
////                        System.out.println(" !! children.get(i).getTarget().waypointInfocontains(new WaypointInfo(foot, null) " +
////                                children.get(i).getTarget().waypointInfo.contains(new WaypointInfo("foot", null)));
////                        continue;
//                    }
//
//                    break;
//                case 1:
//                    break;
//                default:
////                    allNode = dijkstra.findShortestPath(hm, new WaypointNode(sourceNode), new WaypointNode(target));
//            }
//            System.out.print("the Node has: name: " +children.get(i).getTarget().getId()+"  ");

            if ((father.getShortestDistance() + children.get(i).getWeigth() <= children.get(i).getTarget().getShortestDistance())) {
                //				&& (!(list_N.contains(children.get(i).getTarget())))
                children.get(i).getTarget().setShortestDistance(father.getShortestDistance() + children.get(i).getWeigth());
                children.get(i).getTarget().setFirstNodeId(father.getId());
            }// end of if

            /**
             * updating each children's final distance in the visitedNodes list
             */
            updateNode(children.get(i).getTarget());
        } // end of for loop
    }// end of calculateDistance method

    /**
     * A method to update the node in visitedNode array list.
     * @param node
     */
    protected void updateNode(WaypointNode node) {
        if (visitedNodes.contains(node)) {
            if (visitedNodes.get(visitedNodes.indexOf(node)).getShortestDistance() > node.getShortestDistance()) {
                visitedNodes.get(visitedNodes.indexOf(node)).setShortestDistance(node.getShortestDistance());
                visitedNodes.get(visitedNodes.indexOf(node)).setFirstNodeId((node.getFirstNodeId()));
            }// end of internal if
        } // end of if
        else {
            visitedNodes.add(node);
        }// end of else
    }// end of the updateNode

    /**
     * A method to search the visitedNode ArrayList, return the best choice, and delete that node from the ArrayList.
     * @return deleted node.
     */
    protected WaypointNode setVisitedNodes() {
        double bestChoice = Double.MAX_VALUE;
        int indexNumber = -1;
        /* this method is called to search in the array list and return the best choice
         * if there is not any object in the arraylist, null should be returned
         */
        if (visitedNodes.size() == 0) {
            return null;
        }
        for (int i = 0; i < visitedNodes.size(); i++) {
            if (visitedNodes.get(i).getShortestDistance() < bestChoice) {
                bestChoice = visitedNodes.get(i).getShortestDistance();
                indexNumber = i;
            } // end of if
        } // end of for loop
        // a temp object to keep the best choice
        WaypointNode temp = visitedNodes.get(indexNumber);
        //		System.out.println("Dijkstra.java, setVisitedNodes() : temp.getId: " + temp.getId());
        visitedNodes.remove(indexNumber);
        return temp;
    }// end of the method

    /**
     * A method to start the searching by implementing Dijkstra
     * @param allNodes hash map of all nodes.
     * @param source node to start searching
     * @param target node to be reached
     * @param wayType shows the based search
     * 0 -> on foot
     * 1 -> by bike
     * 2 -> by car
     * @return ArrayList<WaypointNode> of the way.
     */
    ArrayList<WaypointNode> findShortestPath(HashMap<WaypointNode, ArrayList<Path>> allNodes, WaypointNode source, WaypointNode target, int wayType) {

        this.allNodes = allNodes;
        source.setShortestDistance(0);
        list_N.add(source);
        do {
            boolean wayTypeFlag = false;
//            do {
            wayTypeFlag = false;
            calculateDistance(getChildren(source), source, wayType);
            source = setVisitedNodes();
            if (list_N.contains(source)) {
                while (list_N.contains(source)) {
                    source = setVisitedNodes();
                }
            }
            if (source == null) {
                break;
            }

//                switch (wayType) {
//                    case 0:
//                        ArrayList<WaypointInfo> list = new ArrayList<WaypointInfo>();
//                        list.add(new WaypointInfo("foot", null));
//                         if (!(source.getId().equalsIgnoreCase(target.getId()))) {
//                            for (int i = 0; i < source.waypointInfo.size(); i++) {
//                                System.out.print("  " + source.getId()+"  " + source.waypointInfo.get(i).getKey());
//                            }
//                            System.out.println();
//                            if (new FootWayComparator().compare(source.waypointInfo, list) != 1) {
//                                System.out.println(new FootWayComparator().compare(source.waypointInfo, list) != 1);
//                                wayTypeFlag = true;
//                            }
//                        }
//                        break;
//                }
//            } while (wayTypeFlag);
            list_N.add(source);
        } while (!(source.getId().equalsIgnoreCase(target.getId())));
        return list_N;
    }// end of findShortestPath method
} // end of class

