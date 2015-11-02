package com.example.tejasvinareddyteju.deltabucketlist;

import java.util.Random;

//FIXME add state locations

public class Destination implements Comparable<Destination> {
    private String name;
    private int imageId;
    private String airportCode;
    private int cost;

    private String dateTime;
    private Random rand = new Random();

    public Destination(String name) {
        this.name = name;

        if (name.equals("New York City")) {
            airportCode = "JFK";
            imageId = R.mipmap.newyorkcity;
        } else if (name.equals("Atlanta")) {
            airportCode = "ATL";
            imageId = R.mipmap.atlanta;
        } else if (name.equals("Los Angeles")) {
            airportCode = "LAX";
            imageId = R.mipmap.losangeles;
        } else if (name.equals("Dallas")) {
            airportCode = "DFW";
            imageId = R.mipmap.dallas;
        } else if (name.equals("Las Vegas")) {
            airportCode = "LAS";
            imageId = R.mipmap.lasvagas;
        } else if (name.equals("Boston")) {
            airportCode = "BOS";
            imageId = R.mipmap.boston;
        } else if (name.equals("Detroit")) {
            airportCode = "DTT";
            imageId = R.mipmap.detroit;
        } else if (name.equals("Chicago")) {
            airportCode = "ORD";
            imageId = R.mipmap.chicago;
        } else if (name.equals("Denver")) {
            airportCode = "DEN";
            imageId = R.mipmap.denver;
        } else if (name.equals("San Francisco")) {
            airportCode = "SFO";
            imageId = R.mipmap.sanfransisco;
        }

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

    public String getName() {
        return name;
    }

    public String getAirportCode() {
        return airportCode;
    }

    @Override
    public int compareTo(Destination another) {
        return this.getName().compareTo(another.getName());
    }

    public int getImageId() {
        return imageId;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Destination)) {
            return false;
        }

        Destination d = (Destination) obj;
        return d.getName().equals(this.getName());
    }

    public int hashCode() {
        return getName().hashCode();
    }
}
