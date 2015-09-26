package com.example.tejasvinareddyteju.deltabucketlist;

/**
 * Created by Rishi on 9/26/2015.
 */
import java.util.ArrayList;
public class Driver {
    ArrayList<Destination> bucketList = new ArrayList<Destination>();
    public void addDestination(Destination place){
        bucketList.add(place);
    }
}
