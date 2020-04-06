package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlightRunner {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Berlin", true);
        airportsMap.put("Warsaw", false);
        airportsMap.put("Prague", true);
        airportsMap.put("Moscow", true);

        if (airportsMap.containsKey(flight.getArrivalAirport())) {
            if (airportsMap.get(flight.getArrivalAirport())) { // true
                System.out.println("We can touch down in " + flight.getArrivalAirport() + " airport");
            } else {
                System.out.println("The airport " + flight.getArrivalAirport() + " is not available");
            }
        } else {

            throw new RouteNotFoundException("Route to " + flight.getArrivalAirport() + " not found");
        }
        System.out.print("The airport exists in our airport map: ");
        return airportsMap.containsKey(flight.getArrivalAirport());
    }

    public static void main(String[] args) throws RouteNotFoundException {
        Flight flightToRotterdam = new Flight("Istanbul", "Rotterdam");
        Flight flightToWarsaw = new Flight("Moscow", "Warsaw");
        Flight flightToPrague = new Flight("Florida", "Prague");

        FindFlightRunner findFlightRunner = new FindFlightRunner();
        System.out.println(findFlightRunner.findFlight(flightToWarsaw));
        System.out.println(findFlightRunner.findFlight(flightToPrague));
        System.out.println(findFlightRunner.findFlight(flightToRotterdam));

    }

}
