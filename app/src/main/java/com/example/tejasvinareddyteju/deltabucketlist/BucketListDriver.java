package com.example.tejasvinareddyteju.deltabucketlist;

/**
 * Created by Rishi on 9/26/2015.
 */
import java.util.ArrayList;
public class BucketListDriver {
    ArrayList<Destination> bucketList = new ArrayList<Destination>();
    ArrayList<Destination> possibleDestinations = new ArrayList<Destination>();

    public BucketListDriver() {
        possibleDestinations.add(new Destination("New York City"));
        possibleDestinations.add(new Destination("Atlanta"));
        possibleDestinations.add(new Destination("Los Angelas"));
        possibleDestinations.add(new Destination("Dallas"));
        possibleDestinations.add(new Destination("Las Vegas"));
    }

    public void addDestination(Destination place){
        bucketList.add(place);
    }

    public Destination findDestinationByName(String name) {
        for (Destination d: bucketList) {
            if (d.getName().equals(name)) {
                return d;
            }
        }

        return null;
    }

    public Destination[] toArray() {
        return (Destination[]) bucketList.toArray();
    }

    public void removeDestination(String name) {
        for(int i = 0; i < bucketList.size(); i++) {
            if( bucketList.get(i).equals(name)) {
                bucketList.remove(i);
            }
        }
    }
}
