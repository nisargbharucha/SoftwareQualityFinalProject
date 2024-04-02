package comflights;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import java.time.LocalDate;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


// /**
// * Unit tests for the Flight class.
// */
public class FlightTest {
    Flight flight = new Flight(1, "Toronto", "New York", "10:00", "12:00",
            LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);

    @Test
    public void testFlightConstructorWithValidID() {
        assertEquals("Toronto", flight.getDepartLocation());
        assertEquals("New York", flight.getDestinationLocation());
        assertEquals("10:00", flight.getDepartTime());
        assertEquals("12:00", flight.getDestinationTime());
        assertEquals(LocalDate.of(2024, 4, 2), flight.getDepartDay());
        assertEquals(LocalDate.of(2024, 4, 3), flight.getDestinationDay());
        assertEquals(200, flight.getNumPassengers());
    }


    @Test
    public void testFlightToString() {
        Flight flight = new Flight(1, "Toronto", "New York", "10:00", "12:00",
        LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
        String flightString = flight.toString();
        
        // check and makes sure that to toString method does not return in a null variable
        assertNotNull(flightString);

    }

    @Test
    public void testGetDepartLocation(){
        assertEquals("Toronto", flight.getDepartLocation());
    }

}
