package comflights;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilitiesController {
    @RestController
    public class FlightController {

        @PostMapping("/getDirectFlights")
        public List<Flight> getDirectFlights(@RequestParam("departure") String departure,
                @RequestParam("destination") String destination) {
            List<Flight> directFlights = new ArrayList<>();

            List<Flight> flights;
            flights = getAllFlights();

            for (Flight flight : flights) {
                if (flight.getDepartLocation().equals(departure)
                        && flight.getDestinationLocation().equals(destination)) {
                    directFlights.add(flight);
                }
            }

            return directFlights;
        }

        @PostMapping("/getReturnFlights")
        public List<Flight> getReturnFlights(@RequestParam("departure") String departure,
                @RequestParam("destination") String destination, @RequestParam("day") LocalDate day) {
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

        @PostMapping("/getMultiStopFlights")
        public List<Flight> getMultistopFlights(@RequestParam("oldDestination") String oldDestination,
                @RequestParam("newDestination") String newDestination, @RequestParam("stopDay") LocalDate stopDay) {
            // this list will hold all the flights that are multistop from old_destination
            // to new_destination
            List<Flight> multistopFlights = new ArrayList<>();

            // this list will hold every single available flight
            List<Flight> flights = getAllFlights();

            // go through every single flight and find one that goes from "old_destionation"
            // to "new_destination", and departs after the given departing day
            for (Flight flight : flights) {
                if (flight.getDepartLocation().equals(oldDestination)
                        && flight.getDestinationLocation().equals(newDestination)
                        && flight.getDepartDay().isAfter(stopDay)) {

                    System.out.println("ADDED");
                    multistopFlights.add(flight);
                }
            }

            System.out.println(multistopFlights);

            return multistopFlights;
        }

        private List<Flight> getAllFlights() {
            // To get all flights here which will be implemented later due to no database
            return new ArrayList<>();
        }
    }
}
