package com.example.tejasvinareddyteju.deltabucketlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BucketList {
    private static Map<String, Destination> allDestinations = new HashMap<String, Destination>();
    private static Set<String> addedDestinations = new HashSet<String>();

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

    private static void initDestination(String name) {
        allDestinations.put(name, new Destination(name));
    }

    public static void addDestination(String name) {
        addedDestinations.add(name);
    }

    public static void removeDestination(String name) {
        addedDestinations.remove(name);
    }

    public static Destination getDestination(String name) {
        return allDestinations.get(name);
    }

    public static boolean hasDestination(String name) {
        return addedDestinations.contains(name);
    }

    public static List<Destination> getAllDestinations() {
        return new ArrayList<Destination>(allDestinations.values());
    }

    public static List<Destination> getAddedDestinations() {
        List<Destination> toReturn = new ArrayList<Destination>();
        for (String name : addedDestinations) {
            toReturn.add(allDestinations.get(name));
        }
        return toReturn;
    }

    public static int getNumberOfAllDestinations() {
        return allDestinations.size();
    }

    public static int getNumberOfAddedDestinations() {
        return addedDestinations.size();
    }
}
