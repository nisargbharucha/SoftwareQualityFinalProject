// package com.flights;

public class User {
    private String firstName;
    private String lastName;
    private String userID;
    private int booked;
    private String timePreference; // 24 or 12 hours for 24-hour or 12-hour time format, respectively

    // Constructor
    public User(String firstName, String lastName, String userID, int booked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.booked = booked;
    }

    public void setUserTimePreference(String newPreference) {
        if (newPreference == timePreference) {
            System.out.println("Time preference is already set to " + newPreference);
        }
        else {
            this.timePreference = newPreference;
        }
    }

}
