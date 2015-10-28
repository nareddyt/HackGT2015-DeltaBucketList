package com.example.tejasvinareddyteju.deltabucketlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BucketListDriver {
    private Map<Destination, Boolean> bucketListMap = new HashMap<Destination, Boolean>();

    public BucketListDriver() {
        bucketListMap.put(new Destination("New York City"), false);
        bucketListMap.put(new Destination("Atlanta"), false);
        bucketListMap.put(new Destination("Los Angeles"), false);
        bucketListMap.put(new Destination("Dallas"), false);
        bucketListMap.put(new Destination("Las Vegas"), false);
        bucketListMap.put(new Destination("Boston"), false);
        bucketListMap.put(new Destination("Detroit"), false);
        bucketListMap.put(new Destination("Chicago"), false);
        bucketListMap.put(new Destination("Denver"), false);
        bucketListMap.put(new Destination("San Francisco"), false);
        // Collections.sort(bucketListMap);
    }

    public static String[] destinationToStringArray(Destination[] dests) {
        String[] strings = new String[dests.length];
        for (int i = 0; i < dests.length; i++) {
            strings[i] = dests[i].getName();
        }
        return strings;
    }

    public void addDestination(Destination place) {
        bucketListMap.put(place, true);
    }

    public boolean hasDestination(Destination toCheck) {
        return bucketListMap.get(toCheck);
    }

    public Destination[] getArrayOfDestinations() {
        ArrayList<Destination> toReturn = new ArrayList<Destination>();

        for (Destination d : bucketListMap.keySet()) {
            if (bucketListMap.get(d)) {
                toReturn.add(d);
            }
        }

        return toReturn.toArray(new Destination[1]);
    }

    public Destination[] possibleDestinationsToArray() {
        return bucketListMap.keySet().toArray(new Destination[1]);
    }

    public void removeDestination(Destination place) {
        bucketListMap.put(place, false);
    }

    public Destination findDestinationByName(String name) {
        for (Destination d : bucketListMap.keySet()) {
            if (d.getName().equals(name)) {
                return d;
            }
        }

        return null;
    }
}
