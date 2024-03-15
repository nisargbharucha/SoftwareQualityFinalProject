package test.java.com.flights;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightTest {

    @Mock
    private ResultSet resultSet;

    @Mock
    private PreparedStatement statement;

    @Mock
    private Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        when(resultSet.getString("depart_location")).thenReturn("Toronto");
        when(resultSet.getString("destination_location")).thenReturn("New York");
        when(resultSet.getString("depart_time")).thenReturn("10:00");
        when(resultSet.getString("destination_time")).thenReturn("12:00");
        when(resultSet.getString("depart_day")).thenReturn("Monday");
        when(resultSet.getString("destination_day")).thenReturn("Monday");
        when(resultSet.getInt("num_passengers")).thenReturn(100);

        when(statement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);

        DriverManager.registerDriver(new MockDriver(connection));
    }

    @Nested
    @DisplayName("Flight Constructor Tests")
    class FlightConstructorTests {

        @Test
        @DisplayName("Flight constructor should initialize flight object with valid ID")
        public void testFlightConstructorWithValidID() throws SQLException {
            // Arrange
            Flight flight = new Flight(1);

            // Assert
            assertEquals("Toronto", flight.getDepartLocation());
            assertEquals("New York", flight.getDestinationLocation());
            assertEquals("10:00", flight.getDepartTime());
            assertEquals("12:00", flight.getDestinationTime());
            assertEquals("Monday", flight.getDepartDay());
            assertEquals("Monday", flight.getDestinationDay());
            assertEquals(100, flight.getNumPassengers());
        }

        @Test
        @DisplayName("Flight constructor should throw SQLException for invalid ID")
        public void testFlightConstructorWithInvalidID() {
            // Assert
            assertThrows(SQLException.class, () -> new Flight(-1));
        }

        @Test
        @DisplayName("Flight constructor should handle empty result set")
        public void testFlightConstructorWithEmptyResultSet() throws SQLException {
            // Arrange
            when(resultSet.next()).thenReturn(false);

            // Assert
            assertDoesNotThrow(() -> new Flight(1));
        }

        @Test
        @DisplayName("Flight constructor should handle null values in result set")
        public void testFlightConstructorWithNullValues() throws SQLException {
            // Arrange
            when(resultSet.getString("depart_location")).thenReturn(null);
            when(resultSet.getString("destination_location")).thenReturn(null);
            when(resultSet.getString("depart_time")).thenReturn(null);
            when(resultSet.getString("destination_time")).thenReturn(null);
            when(resultSet.getString("depart_day")).thenReturn(null);
            when(resultSet.getString("destination_day")).thenReturn(null);
            when(resultSet.getInt("num_passengers")).thenReturn(0);

            // Act
            Flight flight = new Flight(1);

            // Assert
            assertNull(flight.getDepartLocation());
            assertNull(flight.getDestinationLocation());
            assertNull(flight.getDepartTime());
            assertNull(flight.getDestinationTime());
            assertNull(flight.getDepartDay());
            assertNull(flight.getDestinationDay());
            assertEquals(0, flight.getNumPassengers());
        }

        @Test
        @DisplayName("Flight constructor should handle SQLException")
        public void testFlightConstructorHandlesSQLException() throws SQLException {
            // Arrange
            when(connection.prepareStatement(any(String.class))).thenThrow(SQLException.class);

            // Assert
            assertThrows(SQLException.class, () -> new Flight(1));
        }
    }

    @Nested
    @DisplayName("Flight toString() Tests")
    class FlightToStringTests {

        @Test
        @DisplayName("Flight toString() should return a string representation of the flight")
        public void testFlightToString() throws SQLException {
            // Arrange
            Flight flight = new Flight(1);

            // Act
            String flightString = flight.toString();

            // Assert
            assertNotNull(flightString);
            assertTrue(flightString.contains("Flight ID: 1"));
            assertTrue(flightString.contains("Departure Location: Toronto"));
            assertTrue(flightString.contains("Destination Location: New York"));
            assertTrue(flightString.contains("Departure Time: 10:00"));
            assertTrue(flightString.contains("Destination Time: 12:00"));
            assertTrue(flightString.contains("Departure Day: Monday"));
            assertTrue(flightString.contains("Destination Day: Monday"));
            assertTrue(flightString.contains("Number of Passengers: 100"));
        }
    }

    @Nested
    @DisplayName("Flight getFlightInformation() Tests")
    class FlightGetFlightInformationTests {

        @Test
        @DisplayName("Flight getFlightInformation() should return the flight information")
        public void testGetFlightInformation() throws SQLException {
            // Arrange
            Flight flight = new Flight(1);

            // Act
            Flight flightInformation = flight.getFlightInformation();

            // Assert
            assertNotNull(flightInformation);
            assertEquals("Toronto", flightInformation.getDepartLocation());
            assertEquals("New York", flightInformation.getDestinationLocation());
            assertEquals("10:00", flightInformation.getDepartTime());
            assertEquals("12:00", flightInformation.getDestinationTime());
            assertEquals("Monday", flightInformation.getDepartDay());
            assertEquals("Monday", flightInformation.getDestinationDay());
            assertEquals(100, flightInformation.getNumPassengers());
        }
    }

    @RepeatedTest(3)
    @DisplayName("Flight getDepartLocation() should return the correct departure location")
    public void testGetDepartLocation() throws SQLException {
        // Arrange
        Flight flight = new Flight(1);

        // Act
        String departLocation = flight.getDepartLocation();

        // Assert
        assertEquals("Toronto", departLocation);
    }

    @ParameterizedTest
    @ValueSource(strings = { "10:00", "12:00", "14:00" })
    @DisplayName("Flight getDepartTime() should return the correct departure time")
    public void testGetDepartTime(String departTime) throws SQLException {
        // Arrange
        Flight flight = new Flight(1);

        // Act
        String actualDepartTime = flight.getDepartTime();

        // Assert
        assertEquals(departTime, actualDepartTime);
    }

    @Test
    @EnabledOnOs({ OS.WINDOWS, OS.LINUX })
    @DisplayName("Flight getNumPassengers() should return the correct number of passengers on Windows and Linux")
    public void testGetNumPassengersOnWindowsAndLinux() throws SQLException {
        // Arrange
        Flight flight = new Flight(1);

        // Act
        int numPassengers = flight.getNumPassengers();

        // Assert
        assertEquals(100, numPassengers);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    @DisplayName("Flight getNumPassengers() should return 0 on macOS")
    public void testGetNumPassengersOnMac() throws SQLException {
        // Arrange
        Flight flight = new Flight(1);

        // Act
        int numPassengers = flight.getNumPassengers();

        // Assert
        assertEquals(0, numPassengers);
    }

    private static class MockDriver implements Driver {
        private Connection connection;

        public MockDriver(Connection connection) {
            this.connection = connection;
        }

        @Override
        public Connection connect(String url, Properties info) throws SQLException {
            return connection;
        }

        @Override
        public boolean acceptsURL(String url) throws SQLException {
            return true;
        }
    }
}
