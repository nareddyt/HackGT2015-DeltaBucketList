package com.example.tejasvinareddyteju.deltabucketlist;

/**
 * Created by Rishi on 9/26/2015.
 */
public class Destination {
    private String name;
    private String airportCode;

    public Destination(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getCode(){
        return airportCode;
    }

}
