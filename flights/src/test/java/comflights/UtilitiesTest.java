package comflights;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


/**
 * Unit tests for the Utilities class.
 */
public class UtilitiesTest {
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