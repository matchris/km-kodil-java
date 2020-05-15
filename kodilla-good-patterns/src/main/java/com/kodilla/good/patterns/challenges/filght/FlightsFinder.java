package com.kodilla.good.patterns.challenges.filght;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightsFinder {

    public static List<Flight> getFlightToCity(Airport airport) {
        return FlightsRepository.getFlights().stream()
                .filter(flight -> flight.getArrival().equals(airport))
                .collect(Collectors.toList());
    }

    public static List<Flight> getFlightFromCity(Airport airport) {
        return FlightsRepository.getFlights().stream()
                .filter(flight -> flight.getDeparture().equals(airport))
                .collect(Collectors.toList());
    }

    public static List<Flight> getFlightToThrough(Airport from, Airport through, Airport destination) {
        List<Flight> allFromToThrough;
        List<Flight> allThroughToDestination;
        List<Flight> allCollectedInOne;
        allFromToThrough = FlightsRepository.getFlights().stream()
                .filter(flight -> flight.getDeparture().equals(from))
                .filter(flight -> flight.getArrival().equals(through))
                .collect(Collectors.toList());
        allThroughToDestination = FlightsRepository.getFlights().stream()
                .filter(flight -> flight.getDeparture().equals(through))
                .filter(flight -> flight.getArrival().equals(destination))
                .collect(Collectors.toList());
        allThroughToDestination.addAll(allFromToThrough);

        if (allFromToThrough.isEmpty())
            System.out.println(".... Sorry no flights completed.");
        else if (allThroughToDestination.isEmpty())
            System.out.println(".... Sorry no flights completed.");
        else
            System.out.println(".... Searching completed successfully!");
        return allThroughToDestination;
    }
}

