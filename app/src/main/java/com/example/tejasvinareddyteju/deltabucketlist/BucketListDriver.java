package com.example.tejasvinareddyteju.deltabucketlist;

/**
 * Created by Kavin and Teju on 9/26/2015.
 */

import java.util.ArrayList;
import java.util.Collections;

public class BucketListDriver {
    private ArrayList<Destination> bucketList = new ArrayList<Destination>();
    private ArrayList<Destination> possibleDestinations = new ArrayList<Destination>();

    public BucketListDriver() {
        possibleDestinations.add(new Destination("New York City"));
        possibleDestinations.add(new Destination("Atlanta"));
        possibleDestinations.add(new Destination("Los Angeles"));
        possibleDestinations.add(new Destination("Dallas"));
        possibleDestinations.add(new Destination("Las Vegas"));
        possibleDestinations.add(new Destination("Boston"));
        possibleDestinations.add(new Destination("Detroit"));
        possibleDestinations.add(new Destination("Chicago"));
        possibleDestinations.add(new Destination("Denver"));
        possibleDestinations.add(new Destination("San Francisco"));
        Collections.sort(possibleDestinations);
    }

    public static String[] destinationToStringArray(Destination[] dests) {
        String[] strings = new String[dests.length];
        for (int i = 0; i < dests.length; i++) {
            strings[i] = dests[i].getName();
        }
        return strings;
    }

    public boolean hasDestination(Destination destination) {
        for (Destination d : bucketList) {
            if (destination.equals(d)) {
                return true;
            }
        }

        return false;
    }

    public boolean addDestination(Destination place) {
        if (!alreadyExists(place)) {
            bucketList.add(place);
            return true;
        }
        return false;
    }

    public Destination findDestinationById(int id) {
        for (Destination d : possibleDestinations) {
            if (d.getId() == id) {
                return d;
            }
        }

        return null;
    }

    public boolean alreadyExists(Destination toCheck) {
        return bucketList.contains(toCheck);
    }

    public Destination[] bucketListToArray() {
        return bucketList.toArray(new Destination[bucketList.size()]);
    }

    public Destination[] possibleDestinationsToArray() {
        return possibleDestinations.toArray(new Destination[possibleDestinations.size()]);
    }

    public void removeDestination(Destination place) {
        bucketList.remove(place);
    }

    public Destination findDestinationByName(String name) {
        for (Destination d : possibleDestinations) {
            if (d.getName().equals(name)) {
                return d;
            }
        }

        return null;
    }
}
