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
        } else if (name.equals("Los Angeles")) {
            code = "LAX";
        } else if (name.equals("Dallas")) {
            code = "DFW";
        } else if (name.equals("Las Vegas")) {
            code = "LAS";
        } else if (name.equals("Boston")) {
            code = "BOS";
        } else if (name.equals("Detroit")) {
            code = "DTT";
        } else if (name.equals("Chicago")) {
            code = "ORD";
        } else if (name.equals("Denver")) {
            code = "DEN";
        } else if (name.equals("San Francisco")) {
            code = "SFO";
        }
        return code;
    }

}
