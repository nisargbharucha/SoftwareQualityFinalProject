package com.flights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Flight {
    private int flightID;
    private String departLocation;
    private String destinationLocation;
    private String departTime;
    private String destinationTime;
    private String departDay;
    private String destinationDay;
    private int numPassengers;

    public Flight(int flight_id) {
        this.flightID = flight_id;

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking",
                "username", "password")) {
            // Prepare the SQL statement
            String sql = "SELECT depart_location, destination_location, depart_time, destination_time, depart_day, destination_day, num_passengers FROM flights WHERE flight_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, flight_id);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the data from the result set
            if (resultSet.next()) {
                departLocation = resultSet.getString("depart_location");
                destinationLocation = resultSet.getString("destination_location");
                departTime = resultSet.getString("depart_time");
                destinationTime = resultSet.getString("destination_time");
                departDay = resultSet.getString("depart_day");
                destinationDay = resultSet.getString("destination_day");
                numPassengers = resultSet.getInt("num_passengers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public String getDepartDay() {
        return departDay;
    }

    public String getDestinationDay() {
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
