package com.flights ;

import java.util.List;
import java.time.format.DateTimeFormatter;


// CLASS FOR ALL METHODS TO USE TO GET INFORMATION FROM DATABASE
public class Utilities {

    public list<Flight> getDirectFlights(String departure, String destination) {
        // will return all flights that are direct from departure to destination
    }

    public list<Flight> getReturnFlights(String departure, String destination, DateTimeFormatter day) {
        // will return all flights that coming from the destination and go back to departure, on a
        // day that is AFTER the date 
    }

    public list<Flight> getMultistopFlights(String old_destination, String new_destination, DateTimeFormatter departing_day) {
        // used to find flights that have a stop in them. a flight that is going from A -> B will need another flight that is
        // going from B -> C. This will find a flight that goes from the old destination (B) to a new destination (C)
        // used for flights that are going from A -> C
    }

    public void sendConfirmation(User user, Flight flight) {
        // will show confirmation to the user about their upcoming flight using the Flight.getFlightInfromation() method
    }
}
