package comflights;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

// CLASS FOR ALL METHODS TO USE TO GET INFORMATION FROM DATABASE
public class Utilities {

    // public List<Flight> getDirectFlights(String departure, String destination) {
    // // will return all flights that are direct from departure to destination
    // }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(1, "Toronto", "California", "10:00", "12:00", LocalDate.of(2024, 4, 2),
                LocalDate.of(2024, 4, 3), 200);
        Flight flight2 = new Flight(2, "California", "London", "10:00", "12:00", LocalDate.of(2024, 4, 2),
                LocalDate.of(2024, 4, 4), 180);
        Flight flight3 = new Flight(3, "California", "London", "10:00", "12:00", LocalDate.of(2024, 4, 1),
                LocalDate.of(2024, 4, 4), 190);

        // // Add flights to the flights list
        // flights.add(flight1);
        // flights.add(flight2);
        // flights.add(flight3);
        // returns all flights that are available, defined here

        return flights;
    }

    public List<Flight> getDirectFlights(String departure, String destination) {
        List<Flight> directFlights = new ArrayList<>();

        List<Flight> flights = getAllFlights();

        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(departure) && flight.getDestinationLocation().equals(destination)) {
                directFlights.add(flight);
            }
        }

        if (directFlights.isEmpty()) {
            System.out.println("Sorry, there are no direct flights from " + departure + " to " + destination + ".");
            return null;
        }

        return directFlights;
    }

    public List<Flight> getReturnFlights(String departure, String destination, LocalDate day) {
        List<Flight> returnFlights = new ArrayList<>();

        List<Flight> flights = getAllFlights();

        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(destination) && flight.getDestinationLocation().equals(departure)
                    && flight.getDepartDay().isAfter(day)) {
                returnFlights.add(flight);
            }
        }

        return returnFlights;
    }

    public List<Flight> getMultistopFlights(String old_destination, String new_destination,
            LocalDate departing_day) {
        // this list will hold all the flights that are multistop from old_destination
        // to new_destination
        List<Flight> multistopFlights = new ArrayList<>();

        // this list will hold every single available flight
        List<Flight> flights = getAllFlights();

        // go through every single flight and find one that goes from "old_destionation"
        // to "new_destination", and departs after the given departing day
        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(old_destination) &&
                    flight.getDestinationLocation().equals(new_destination) &&
                    flight.getDepartDay().isAfter(departing_day)) {
                multistopFlights.add(flight);
            }
        }

        return multistopFlights;
    }

    // Flight.getFlightInfromation() method
    public void confirmFlight(User user, Flight flight) {
        System.out.println("Flight confirmation for " + user.getName() + ":\n" + flight.getFlightInformation());
    }

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
