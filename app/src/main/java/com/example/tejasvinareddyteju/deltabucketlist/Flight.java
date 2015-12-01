package com.example.tejasvinareddyteju.deltabucketlist;

import java.util.Date;

public class Flight {
    // Only way to uniquly identify a flight is with these three fields
    private Date dateTime;
    private String airline;
    private int flightNumber;

    // Other instance variables
    private Destination start;
    private Destination end;
    private double cost;
    private int airlineImageId;     // FIXME storing images

    public Flight(String airline, int number, Date dateTime, double cost, Destination start, Destination end) {
        this.airline = airline;
        this.flightNumber = number;
        this.dateTime = dateTime;
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    public String getAirline() {
        return airline;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public double getCost() {
        return cost;
    }

    public Destination getStart() {
        return start;
    }

    public Destination getEnd() {
        return end;
    }
}
