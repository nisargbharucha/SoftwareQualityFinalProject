package comflights;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// CLASS FOR ALL METHODS TO USE TO GET INFORMATION FROM DATABASE
public class Utilities {

    // public List<Flight> getDirectFlights(String departure, String destination) {
    // // will return all flights that are direct from departure to destination
    // }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        // Flight flight1 = new Flight(1, "Toronto", "California", "12:00", "Monday",
        // 200);
        // Flight flight2 = new Flight(2, "California", "London", "12:00", "Tuesday",
        // 180);
        // Flight flight3 = new Flight(3, "Paris", "Toronto", "12:00", "Wednesday",
        // 150);

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
        // Create sample flights
        Flight flight1 = new Flight("Departure1", "Destination1", true, LocalDateTime.now());
        Flight flight2 = new Flight("Departure2", "Destination2", true, LocalDateTime.now());
        Flight flight3 = new Flight("Departure3", "Destination3", true, LocalDateTime.now());

        // Add flights to the flights list
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(destination) &&
                    flight.getDestinationLocation().equals(departure) &&
                    flight.getDepartDay().isAfter(day)) {
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
