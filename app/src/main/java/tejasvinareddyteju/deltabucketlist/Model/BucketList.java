package tejasvinareddyteju.deltabucketlist.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BucketList {
    private static Map<String, Destination> allDestinations = new
            HashMap<String, Destination>();
    private static Set<String> addedDestinations = new HashSet<String>();

    private static boolean allChanged;
    private static boolean addedChanged;

    public BucketList() {
        initDestination("New York City");
        initDestination("Atlanta");
        initDestination("Los Angeles");
        initDestination("Dallas");
        initDestination("Las Vegas");
        initDestination("Boston");
        initDestination("Detroit");
        initDestination("Chicago");
        initDestination("Denver");
        initDestination("San Francisco");
    }

    /**
     * Adds a destination to the bucketlist
     *
     * @param name A string representing the name of the destination that
     *             needs to be added
     */
    public static void addDestination(String name) {
        addedDestinations.add(name);
        addedChanged = true;
    }

    /**
     * Returns all the destinations in the bucketlist
     *
     * @return List<Destination>
     */
    public static Destination[] getAddedDestinations() {
        addedChanged = false;

        List<Destination> toReturn = new ArrayList<Destination>();
        for (String name : addedDestinations) {
            toReturn.add(allDestinations.get(name));
        }

        return toReturn.toArray(new Destination[addedDestinations.size()]);
    }

    /**
     * Returns all of the possible destinations
     *
     * @return List<Destination>
     */
    public static Destination[] getAllDestinations() {
        allChanged = false;
        return allDestinations.values().toArray(new
                Destination[allDestinations.size()]);
    }

    /**
     * Returns the destination that is represented by the name
     *
     * @param name A string representing the name of the destination
     * @return Destination, null if it does not exist
     */
    public static Destination getDestination(String name) {
        return allDestinations.get(name);
    }

    /**
     * Returns whether the bucketlist has been changed since it was retrieved
     *
     * @return a boolean
     */
    public static boolean hasAddedDestinationsChanged() {
        return addedChanged;
    }

    /**
     * Returns whether the list of all Destinations has been changed since it
     * was retrieved
     *
     * @return a boolean
     */
    public static boolean hasAllDestinationsChanged() {
        return allChanged;
    }

    /**
     * Checks if the bucketlist contains a destination
     *
     * @param name A string representing the name of the destination
     * @return boolean
     */
    public static boolean hasDestination(String name) {
        return addedDestinations.contains(name);
    }

    /**
     * Removes a destination to the bucketlist
     *
     * @param name A string representing the name of the destination that
     *             needs to be removed
     */
    public static void removeDestination(String name) {
        addedDestinations.remove(name);
        addedChanged = true;
    }

    private static void initDestination(String name) {
        allDestinations.put(name, new Destination(name));
        allChanged = true;
    }
}
