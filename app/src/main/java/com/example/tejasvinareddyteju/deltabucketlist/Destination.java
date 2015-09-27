package com.example.tejasvinareddyteju.deltabucketlist;

import java.util.Random;

/**
 * Created by Rishi on 9/26/2015.
 */
public class Destination implements Comparable<Destination> {
    private String name;
    private int cost;
    private String dateTime;
    private Random rand = new Random();

    public Destination(String name) {
        this.name = name;
        int choice = rand.nextInt(8);

        if (choice == 7) {
            dateTime = "8:45PM on 10/4/15";
        } else if (choice == 6) {
            dateTime = "4:25PM on 10/13/15";
        } else if (choice == 5) {
            dateTime = "10:25AM on 10/19/15";
        } else if (choice == 4) {
            dateTime = "1:20AM on 10/09/15";
        } else if (choice == 3) {
            dateTime = "10:55AM on 10/30/15";
        } else if (choice == 2) {
            dateTime = "12:25AM on 11/07/15";
        } else if (choice == 1) {
            dateTime = "5:25AM on 10/19/15";
        } else {
            dateTime = "3:55PM on 11/02/15";
        }

        cost = 150 + rand.nextInt(100);
    }

    public int getCost() {
        return cost;
    }

    public String getDateTime() {
        return dateTime;
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

    @Override
    public int compareTo(Destination another) {
        return this.getName().compareTo(another.getName());
    }
}
