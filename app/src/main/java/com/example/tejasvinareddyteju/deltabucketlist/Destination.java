package com.example.tejasvinareddyteju.deltabucketlist;

/**
 * Created by Rishi on 9/26/2015.
 */
public class Destination {
    private String name;

    public Destination(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getAirportCode() {
        String code = "NULL";
        if (name.equals("New York City")) {
            code = "JFK";
        } else if (name.equals("Atlanta")) {
            code = "ATL";
        } else if (name.equals("Las Angeles")) {
            code = "LAX";
        } else if (name.equals("Dallas")) {
            code = "DFW";
        } else if (name.equals("Las Vegas")) {
            code = "LAS";
        }
        return code;
    }

}
