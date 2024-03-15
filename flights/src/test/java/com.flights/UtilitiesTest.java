package test.java.com.flights;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.flights.Flight;
import com.flights.Utilities;

public class UtilitiesTest {

    private Utilities utilities;

    @Before
    public void setUp() {
        utilities = new Utilities();
    }

    @Test
    public void testGetDirectFlights() {
        // Arrange
        String departure = "A";
        String destination = "B";
        List<Flight> expectedFlights = new ArrayList<>();
        // Add expected flights to the list

        // Act
        List<Flight> actualFlights = utilities.getDirectFlights(departure, destination);

        // Assert
        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void testGetReturnFlights() {
        // Arrange
        String departure = "A";
        String destination = "B";
        DateTimeFormatter day = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2022-01-01", day);
        List<Flight> expectedFlights = new ArrayList<>();
        // Add expected flights to the list

        // Act
        List<Flight> actualFlights = utilities.getReturnFlights(departure, destination, day);

        // Assert
        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void testGetMultistopFlights() {
        // Arrange
        String oldDestination = "B";
        String newDestination = "C";
        DateTimeFormatter departingDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Flight> expectedFlights = new ArrayList<>();
        // Add expected flights to the list

        // Act
        List<Flight> actualFlights = utilities.getMultistopFlights(oldDestination, newDestination, departingDay);

        // Assert
        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void testSendConfirmation() {
        // Arrange
        User user = mock(User.class);
        Flight flight = mock(Flight.class);

        // Act
        utilities.sendConfirmation(user, flight);

        // Assert
        verify(flight).getFlightInformation();
    }
}
