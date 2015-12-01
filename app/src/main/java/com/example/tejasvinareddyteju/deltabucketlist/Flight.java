package com.example.tejasvinareddyteju.deltabucketlist;

import java.util.Date;

public class Flight {
    Destination start;
    Destination end;
    private String airline;
    private int number;
    private Date dateTime;
    private double cost;

    public Flight(String airline, int number, Date dateTime, double cost, Destination start, Destination end) {
        this.airline = airline;
        this.number = number;
        this.dateTime = dateTime;
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    public String getAirline() {
        return airline;
    }

    public int getNumber() {
        return number;
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
