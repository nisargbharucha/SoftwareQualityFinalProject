package comflights;

import java.time.LocalDate;

public class Flight {
    private int flightID;
    private String departLocation;
    private String destinationLocation;
    private String departTime;
    private String destinationTime;
    private LocalDate departDay;
    private LocalDate destinationDay;
    private int numPassengers;

    public Flight(int flight_id, String departLocation, String destinationLocation, String departTime,
            String destinationTime, LocalDate departDay, LocalDate destinationDay, int numPassengers) {
        this.flightID = flight_id;
        this.departLocation = departLocation;
        this.destinationLocation = destinationLocation;
        this.departDay = departDay;
        this.departTime = departTime;
        this.destinationDay = destinationDay;
        this.numPassengers = numPassengers;

        // // Establish a connection to the database
        // try (Connection connection =
        // DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking",
        // "username", "password")) {
        // // Prepare the SQL statement
        // String sql = "SELECT depart_location, destination_location, depart_time,
        // destination_time, depart_day, destination_day, num_passengers FROM flights
        // WHERE flight_id = ?";
        // PreparedStatement statement = connection.prepareStatement(sql);
        // statement.setInt(1, flight_id);

        // // Execute the query
        // ResultSet resultSet = statement.executeQuery();

        // // Retrieve the data from the result set
        // if (resultSet.next()) {
        // departLocation = resultSet.getString("depart_location");
        // destinationLocation = resultSet.getString("destination_location");
        // departTime = resultSet.getString("depart_time");
        // destinationTime = resultSet.getString("destination_time");
        // departDay = resultSet.getString("depart_day");
        // destinationDay = resultSet.getString("destination_day");
        // numPassengers = resultSet.getInt("num_passengers");
        // }
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
    }

    public String getDepartLocation() {
        return departLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public String getDepartTime() {
        return departTime;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public LocalDate getDepartDay() {
        return departDay;
    }

    public LocalDate getDestinationDay() {
        return destinationDay;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public Flight getFlightInformation() {
        this.toString();
        return null;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departLocation='" + departLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", departTime='" + departTime + '\'' +
                ", destinationTime='" + destinationTime + '\'' +
                ", departDay='" + departDay + '\'' +
                ", destinationDay='" + destinationDay + '\'' +
                ", numPassengers=" + numPassengers +
                '}';
    }
}
