package comflights;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import comflights.Flight;
import comflights.Utilities;

/**
 * This class contains unit tests for the Utilities class.
 */
public class UtilitiesTest {

    private Utilities utilities;

    /**
     * Sets up the test fixture by creating an instance of the Utilities class.
     */
    @Before
    public void setUp() {
        utilities = new Utilities();
    }

    public void testDirectFlights() {
        Utilities utilitiesMock = mock(Utilities.class);

    }

    /**
     * Test case for the getDirectFlights method.
     * 
     * It verifies that the getDirectFlights method returns the expected list of
     * flights
     * when given a departure and destination.
     */
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

    /**
     * Test case for the getReturnFlights method.
     * 
     * It verifies that the getReturnFlights method returns the expected list of
     * flights
     * when given a departure, destination, and date.
     */
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

    /**
     * Test case for the getMultistopFlights method.
     * 
     * It verifies that the getMultistopFlights method returns the expected list of
     * flights
     * when given an old destination, new destination, and departing day.
     */
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

    /**
     * Test case for the sendConfirmation method.
     * 
     * It verifies that the sendConfirmation method calls the getFlightInformation
     * method
     * on the flight object.
     */
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
