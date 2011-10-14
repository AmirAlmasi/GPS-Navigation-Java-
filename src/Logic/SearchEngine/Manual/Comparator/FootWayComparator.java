/*
 * Created on Mar 22, 2011, 07:59:20 PM
 *
 * FootWayComparator.java
 */
package Logic.SearchEngine.Manual.Comparator;

import Logic.SearchEngine.Manual.WaypointInfo;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The class which is used for comparing the two nodes.
 * @author Amir Almasi
 * @version 0.1
 */
public class FootWayComparator implements Comparator<ArrayList<WaypointInfo>> {

    /**
     * Done method to compare
     * @param list1
     * @param list2
     * @return
     */
    @Override
    public int compare(ArrayList<WaypointInfo> list1, ArrayList<WaypointInfo> list2) {
        if (list1.contains(list2.get(0))) {
            return 1;
        }
        return -1;
    }
}
