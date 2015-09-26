package com.example.tejasvinareddyteju.deltabucketlist;

/**
 * Created by Rishi on 9/26/2015.
 */
import java.util.ArrayList;
public class BucketListDriver {
    private ArrayList<Destination> bucketList = new ArrayList<Destination>();
    private ArrayList<Destination> possibleDestinations = new ArrayList<Destination>();

    public BucketListDriver() {
        possibleDestinations.add(new Destination("New York City"));
        possibleDestinations.add(new Destination("Atlanta"));
        possibleDestinations.add(new Destination("Los Angeles"));
        possibleDestinations.add(new Destination("Dallas"));
        possibleDestinations.add(new Destination("Las Vegas"));
    }

    public void addDestination(Destination place){
        bucketList.add(place);
    }

    public Destination findDestinationByName(String name) {
        for (Destination d: possibleDestinations) {
            if (d.getName().equals(name)) {
                return d;
            }
        }

        return null;
    }

    public String[] bucketListToArray() {
        ArrayList<String> destr = new ArrayList<String>();
        for (Destination d: bucketList) {
            destr.add(d.getName());
        }

        return destr.toArray(new String[destr.size()]);
    }

    public String[] possibleDestinationsToArray() {
        ArrayList<String> destr = new ArrayList<String>();
        for (Destination d: possibleDestinations) {
            destr.add(d.getName());
        }
        return destr.toArray(new String[destr.size()]);
    }
    public void removeDestination(String name) {
        for(int i = 0; i < bucketList.size(); i++) {
            if (bucketList.get(i).getName().equals(name)) {
                bucketList.remove(i);
                break;
            }
        }
    }
}
