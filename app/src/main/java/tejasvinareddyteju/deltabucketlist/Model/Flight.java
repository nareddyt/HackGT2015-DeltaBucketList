package tejasvinareddyteju.deltabucketlist.Model;

import java.util.Date;

// TODO API calls to update this info

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

    public Flight(String airline, int number, Date dateTime, double cost,
                  Destination start, Destination end) {
        this.airline = airline;
        this.flightNumber = number;
        this.dateTime = dateTime;
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Flight)) {
            return false;
        }

        Flight f = (Flight) o;
        return f.dateTime.equals(this.dateTime) && f.airline.equals(this
                .airline) && f.flightNumber == this.flightNumber;
    }

    @Override
    public int hashCode() {
        return dateTime.hashCode() + airline.hashCode() + flightNumber;
    }

    @Override
    public String toString() {
        return airline + " " + flightNumber + " at " + dateTime;
    }

    public String getAirline() {
        return airline;
    }

    public double getCost() {
        return cost;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Destination getEnd() {
        return end;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Destination getStart() {
        return start;
    }
}
