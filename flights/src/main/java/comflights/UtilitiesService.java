package comflights;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface UtilitiesService {
    public List<Flight> getAllFlights();

    public List<Flight> getDirectFlights(String departure, String destination);

    public List<Flight> getReturnFlights(String departure, String destination, LocalDate day);

    public List<Flight> getMultistopFlights(String old_destination, String new_destination,
            LocalDate departing_day);

    public void confirmFlight(User user, Flight flight);

    public void formatTime(User user, DateTimeFormatter time, String preference);
}
