package com.flights;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// CLASS FOR ALL METHODS TO USE TO GET INFORMATION FROM DATABASE
public class Utilities {

    // public List<Flight> getDirectFlights(String departure, String destination) {
    // // will return all flights that are direct from departure to destination
    // }
    public List<Flight> getDirectFlights(String departure, String destination) {
        List<Flight> directFlights = new ArrayList<>();

        // Simulate a flights database (replace with actual data source)
        List<Flight> flights = new ArrayList<>();
        // ... populate flights list with sample flight data (including a mix of direct
        // and connecting flights)

        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(departure) &&
                    flight.getDestinationLocation().equals(destination) &&
                    /* Check for direct flight indicator in the data model */
                    flight.isDirect()) { // Replace with your logic to identify direct flights based on your data model
                directFlights.add(flight);
            }
        }

        return directFlights;
    }

    public List<Flight> getReturnFlights(String departure, String destination, DateTimeFormatter day) {
        List<Flight> returnFlights = new ArrayList<>();

        // Simulate a flights database (replace with actual data source)
        List<Flight> flights = new ArrayList<>();
        // ... populate flights list with sample flight data

        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(destination) &&
                    flight.getDestinationLocation().equals(departure) &&
                    flight.getDepartureDay().isAfter(day)) {
                returnFlights.add(flight);
            }
        }

        return returnFlights;
    }

    public List<Flight> getMultistopFlights(String old_destination, String new_destination,
            DateTimeFormatter departing_day) {
        List<Flight> multistopFlights = new ArrayList<>();

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(old_destination) &&
                    flight.getDestinationLocation().equals(new_destination) &&
                    flight.getDepartureDay().isAfter(departing_day)) {
                multistopFlights.add(flight);
            }
        }

        return multistopFlights;
    }

    // Flight.getFlightInfromation() method
    public void confirmFlight(User user, Flight flight) {
    }        System.out.println("Flight confirmation for " + user.getName() + ":\n" + flight.getFlightInformation());


    public void formatTime(User user, DateTimeFormatter time, String preference) {
        // convert the given time to something else if the preference is different to
        // what is being done now.
        if (preference == "12hr") {
            user.setUserTimePreference("12hr");
        } else if (preference == "24hr") {
            user.setUserTimePreference("24hr");
        }
    }
}
