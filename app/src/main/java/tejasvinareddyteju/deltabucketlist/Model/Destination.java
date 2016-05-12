package tejasvinareddyteju.deltabucketlist.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import tejasvinareddyteju.deltabucketlist.R;

//TODO add state locations
//TODO flight integration

public class Destination implements Comparable<Destination> {
    private String name;
    private int imageId;    // FIXME storing images
    private String airportCode;
    private int priority;

    //TODO API call to update flightsToHere
    private List<Flight> flightsToHere;

    //FIXME hardcoding
    public Destination(String name) {
        this.name = name;
        flightsToHere = new ArrayList<>();

        // FIXME
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

        priority = 1;
        System.out.println(name + ": Priority = " + priority);
    }

    @Override
    public int compareTo(Destination another) {
        return this.getName().compareTo(another.getName());
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Destination)) {
            return false;
        }

        Destination d = (Destination) other;
        return d.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String getAirportCode() {
        return airportCode;
    }

    // TODO an algorithm to get the "best" instances based on all the
    // possible flightsToHere
    public int getBestCost() {
        // TODO
        return -1;
    }

    public String getBestDateTime() {
        // TODO
        return "TO DO";
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static class NameComparator implements Comparator<Destination> {
        public int compare(Destination d1, Destination d2) {
            return d1.name.compareTo(d2.name);
        }
    }

    public static class PriorityComparator implements Comparator<Destination> {
        public int compare(Destination d1, Destination d2) {
            return d1.priority - d2.priority;
        }
    }
}
