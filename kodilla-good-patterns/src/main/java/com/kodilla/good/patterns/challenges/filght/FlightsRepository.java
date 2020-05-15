package com.kodilla.good.patterns.challenges.filght;

import java.util.ArrayList;

public class FlightsRepository {

    public static ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight(Airport.WARSZAWA,Airport.SZCZECIN));
        flights.add(new Flight(Airport.SZCZECIN,Airport.POZNAN));
        flights.add(new Flight(Airport.WARSZAWA,Airport.POZNAN));
        flights.add(new Flight(Airport.POZNAN,Airport.OPOLE));
        flights.add(new Flight(Airport.POZNAN,Airport.ZABRZE));
        flights.add(new Flight(Airport.ZABRZE,Airport.WARSZAWA));
        flights.add(new Flight(Airport.GDANSK,Airport.KRAKOW));
        flights.add(new Flight(Airport.KRAKOW,Airport.WROCLAW));
        flights.add(new Flight(Airport.KRAKOW,Airport.GDANSK));
        flights.add(new Flight(Airport.KRAKOW,Airport.KOLOBRZEG));
        flights.add(new Flight(Airport.KRAKOW,Airport.WARSZAWA));
        flights.add(new Flight(Airport.WROCLAW,Airport.WARSZAWA));

        return flights;
    }
}
