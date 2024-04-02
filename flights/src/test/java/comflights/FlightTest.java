package comflights;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
/* Unit tests for the Flight class.
**/
public class FlightTest {
    Flight flight = new Flight(1, "Toronto", "New York", "10:00", "12:00",
            LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
            UtilitiesService utilitiesMock = mock(UtilitiesService.class);
    Utilities utilities = new Utilities(utilitiesMock);
    Flight flight1 = new Flight(1, "Toronto", "California", "10:00", "12:00",
            LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
    Flight flight2 = new Flight(2, "California", "London", "10:00", "12:00",
            LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 4), 180);
    Flight flight3 = new Flight(3, "California", "London", "10:00", "12:00",
            LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 4), 190);
    Flight flight4 = new Flight(4, "London", "Paris", "10:00", "12:00",
            LocalDate.of(2024, 5, 3), LocalDate.of(2024, 4, 4), 190);
    Flight flight5 = new Flight(5, "California", "Paris", "10:00", "12:00",
            LocalDate.of(2024, 4, 4), LocalDate.of(2024, 4, 5), 200);

    
    /**
     * Test case for the Flight constructor
     * Verifies that the values given by the constructor are working correctly, as well as the getter functions in the 
     * @return true if every every variable is correct
     */
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

    /**
     * Test case for the Flight toString method
     * Verifies the toString method works and does not have a null return value
     * @return true if every every variable is correct
     */
    @Test
    public void testFlightToString() {
        Flight flight = new Flight(1, "Toronto", "New York", "10:00", "12:00",
        LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), 200);
        String flightString = flight.toString();
        
        // check and makes sure that to toString method does not return in a null variable
        assertNotNull(flightString);

    }

    /**
     * Test case for the Flight getDepartLocation method
     * Verifies that the depart location is returned correctly
     * @return true if the output matches that of the method
     */
    @Test
    public void testGetDepartLocation(){
        assertEquals("Toronto", flight.getDepartLocation());
    }

    /**
     * Test case for the setUserTimePreference method of the User class
     * It verifies that the time preference is set correctly.
     * @return True if the output matches that of the method
     */
    @Test
    public void testSetUserTimePreferenceWhenSame() {
        User user = new User("John", "Doe", "12345", 0);
        String result = user.setUserTimePreference("12");
        assertEquals("Time preference is already set to 12", result);
    }

    /**
     * Test case for the setUserTimePreference method of the User class
     * It verifies that the time preference is set correctly when a new one is given
     * @return True if the output matches that of the method
     */
    @Test
    public void testSetUserTimePreference() {
        User user = new User("John", "Doe", "123", 0);
        String result = user.setUserTimePreference("24");
        assertEquals("Your time preference has changed to 24", result);
    }

    /**
     * Test case for the getName method of the User class
     * It verifies that the name is returned correctly
     * @return True if the output matches that of the method
     */
    @Test
    public void testName() {
        User user = new User("John", "Doe", "12", 0);
        String result = user.getName(); 
        assertEquals("John Doe", result);
    }

    /**
     * Test case for the constructor of the User.java class
     * Verifies that the constructor does not return a null value
     * @return True if the created object is not null
     */
    @Test
    public void testConstructor(){
        User user = new User("John", "Doe", "12", 0);
        assertNotNull(user.toString());
    }

    /**
     * Test case for the getDirectFlights method when there is a valid flight
     * 
     * @return true if the output matches that of the method
     */
    @Test
    public void testDirectFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        List<Flight> expected = new ArrayList<>();
        expected.add(flight1);

        // whent his method is run, then return this list of all flights (defined above)
        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getDirectFlights("Toronto", "California");
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }

    /**
     * Test case for the getDirectFlights method when there are no valid flights
     * @return true if the output (empty list) matches the one given by 'getDirectFlights()'
     */
    @Test
    public void testDirectFlightsWithNoFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        List<Flight> expected = new ArrayList<>();

        // whent his method is run, then return this list of all flights (defined above)
        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getDirectFlights("London", "California");
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }

    /**
     * Test case for the getReturnFlights method when there is a valid flight
     * @return true if the output matches that of the method
     */
    @Test
    public void testReturnFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        List<Flight> expected = new ArrayList<>();
        expected.add(flight4);

        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getReturnFlights("Paris", "London", LocalDate.of(2024, 3, 2));
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }
    
    /**
     * Test case for the getReturnFlights method when there is no valid flight
     * @return true if the output matches that of the method
     */
    @Test
    public void testReturnFlightsWithNoFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        List<Flight> expected = new ArrayList<>();

        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getReturnFlights("Toronto", "Paris", LocalDate.of(2024, 3, 2));
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }
    
    /**
     * Test case for the getMultistopFlights method when there is a valid flight
     * @return true if the output matches that of the method
     */
    @Test
    public void testMultistopFlights() {
        Utilities utilities = new Utilities(utilitiesMock);
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);

        List<Flight> expected = new ArrayList<>();
        expected.add(flight5);

        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getMultistopFlights("California", "Paris", LocalDate.of(2024, 4, 2));
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }

    /**
     * Test case for the getMultistopFlights method when there is no valid flights
     * @return true if the output matches that of the method
     */
    @Test
    public void testMultistopFlightsWithNoFlights() {
        Utilities utilities = new Utilities(utilitiesMock);
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);

        List<Flight> expected = new ArrayList<>();

        when(utilitiesMock.getAllFlights()).thenReturn(flights);

        List<Flight> result = utilities.getMultistopFlights("London", "Paris", LocalDate.of(2024, 5, 4));
        String stringExpected = expected.toString();
        String stringResult = result.toString();
        assertEquals(stringExpected, stringResult);
    }


}
