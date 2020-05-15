package com.kodilla.good.patterns.challenges.filght;

import java.util.List;

public class FlightsRunner {

    public static void main(String[] args) {
        System.out.println("Flights to: ");
        List<Flight> flightsTo = FlightsFinder.getFlightToCity(Airport.POZNAN);
        List<Flight> flightsTo1 = FlightsFinder.getFlightToCity(Airport.WARSZAWA);
        System.out.println("Flights to airport Poznań: " + flightsTo.toString());
        System.out.println("Flights to airport Warszawa: " + flightsTo1.toString());
        System.out.println("");
        System.out.println("Flights from: ");
        List<Flight> flightsFrom = FlightsFinder.getFlightFromCity(Airport.KRAKOW);
        List<Flight> flightsFrom1 = FlightsFinder.getFlightFromCity(Airport.WARSZAWA);
        System.out.println("Flights from Kraków: " + flightsFrom.toString());
        System.out.println("Flights from Warszawa: " + flightsFrom1.toString());

        System.out.println("");
        System.out.println("Flights from: through: to: ");
        List<Flight> allInOne = FlightsFinder.getFlightToThrough(Airport.KRAKOW,Airport.WROCLAW,Airport.WARSZAWA);
        System.out.println("Flights from Kraków through Wrocław to Warszawa ");
        System.out.println(allInOne);
        System.out.println("");
        List<Flight> allInOne2 = FlightsFinder.getFlightToThrough(Airport.KRAKOW,Airport.ZABRZE,Airport.WARSZAWA);
        System.out.println("Flights from Kraków through Zabrze to Warszawa ");
        System.out.println(allInOne);



    }
}
