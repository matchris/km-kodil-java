package com.kodilla.good.patterns.challenges.filght;

import java.util.Objects;

public class Flight {

    private Airport departure;

    @Override
    public String toString() {
        return "Flight{" +
                "departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }

    private Airport arrival;

    public Flight(Airport departure, Airport arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departure == flight.departure &&
                arrival == flight.arrival;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }
}