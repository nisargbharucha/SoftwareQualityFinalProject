package comflights;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    // @Before
    // public void setUp() {
    // utilities = new Utilities();
    // }

    @Test
    public void testDirectFlights() {
        // create a mock so that we can test the Utilities.getDirectFlights() method
        UtilitiesService utilitiesMock = mock(UtilitiesService.class);
        Utilities utilities = new Utilities(utilitiesMock);
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(1, "Toronto", "California", "10:00", "12:00",
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
        Flight flight2 = new Flight(2, "California", "London", "10:00", "12:00",
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 4), 180);
        Flight flight3 = new Flight(3, "California", "London", "10:00", "12:00",
                LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 4), 190);
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        List<Flight> expected = new ArrayList<>();
        expected.add(flight1);

        // when this method is run, then return this list of all flights (defined above)
        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getDirectFlights("Toronto", "California");
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }

    @Test
    public void testDirectFlightsWithNoFlights() {
        UtilitiesService utilitiesMock = mock(UtilitiesService.class);
        Utilities utilities = new Utilities(utilitiesMock);
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(1, "Toronto", "California", "10:00", "12:00",
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
        Flight flight2 = new Flight(2, "California", "London", "10:00", "12:00",
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 4), 180);
        Flight flight3 = new Flight(3, "California", "London", "10:00", "12:00",
                LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 4), 190);
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        List<Flight> expected = new ArrayList<>();

        // whent his method is run, then return this list of all flights (defined above)
        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getDirectFlights("London", "Paris");
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }

    @Test
    public void testReturnFlights() {
        UtilitiesService utilitiesMock = mock(UtilitiesService.class);
        Utilities utilities = new Utilities(utilitiesMock);
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(1, "Toronto", "California", "10:00", "12:00",
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
        Flight flight2 = new Flight(2, "California", "London", "10:00", "12:00",
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 3, 4), 180);
        Flight flight3 = new Flight(3, "California", "London", "10:00", "12:00",
                LocalDate.of(2024, 4, 1), LocalDate.of(2024, 3, 4), 190);
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        List<Flight> expected = new ArrayList<>();
        expected.add(flight2);
        expected.add(flight3);

        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getReturnFlights("California", "London", LocalDate.of(2024, 4, 2));
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }

    // @Test
    // public void testGetDirectFlights() {
    // // Arrange
    // UtilitiesService utilitiesMock = mock(UtilitiesService.class);
    // Utilities utilities = new Utilities(utilitiesMock);
    // String departure = "Toronto";
    // String destination = "California";
    // List<Flight> expectedFlights = new ArrayList<>();
    // Flight flight1 = new Flight(1, "Toronto", "California", "10:00", "12:00",
    // LocalDate.of(2024, 4, 2),
    // LocalDate.of(2024, 4, 3), 200);
    // expectedFlights.add(flight1);
    // when(utilitiesMock.getAllFlights()).thenReturn(expectedFlights);

    // // Act
    // List<Flight> actualFlights = utilities.getDirectFlights("Toronto",
    // "California");

    // // Assert
    // assertEquals(expectedFlights, actualFlights);
    // }

    // List<Flight> actualFlights = utilities.getReturnFlights(departure,
    // destination, day);

    // // Assert
    // assertEquals(expectedFlights, actualFlights);
    // }

    // /**
    // * Test case for the getMultistopFlights method.
    // *
    // * It verifies that the getMultistopFlights method returns the expected list
    // of
    // * flights
    // * when given an old destination, new destination, and departing day.
    // */
    // @Test
    // public void testGetMultistopFlights() {
    // // Arrange
    // String oldDestination = "B";
    // String newDestination = "C";
    // DateTimeFormatter departingDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // List<Flight> expectedFlights = new ArrayList<>();
    // // Add expected flights to the list

    // // Act
    // List<Flight> actualFlights = utilities.getMultistopFlights(oldDestination,
    // newDestination, departingDay);

    // // Assert
    // assertEquals(expectedFlights, actualFlights);
    // }

    // /**
    // * Test case for the sendConfirmation method.
    // *
    // * It verifies that the sendConfirmation method calls the getFlightInformation
    // * method
    // * on the flight object.
    // */
    // @Test
    // public void testSendConfirmation() {
    // // Arrange
    // User user = mock(User.class);
    // Flight flight = mock(Flight.class);

    // // Act
    // utilities.sendConfirmation(user, flight);

    // // Assert
    // verify(flight).getFlightInformation();
    // }
}
