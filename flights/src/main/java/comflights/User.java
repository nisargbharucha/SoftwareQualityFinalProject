package comflights;

public class User {
    private String firstName;
    private String lastName;
    private String userID;
    private int booked;
    private String timePreference = "12"; // 24 or 12 hours for 24-hour or 12-hour time format, respectively
    // set to 12 by default

    // Constructor
    public User(String firstName, String lastName, String userID, int booked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.booked = booked;
    }

    public String setUserTimePreference(String newPreference) {
        if (newPreference == timePreference) {
            return ("Time preference is already set to " + newPreference);
        } else {
            this.timePreference = newPreference;
        }
        return "Your time preference has changed to " + newPreference;
    }

    public String getTimePreference() {
        return timePreference;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userID='" + userID + '\'' +
                ", booked=" + booked +
                ", timePreference='" + timePreference + '\'' +
                '}';
    }

}
