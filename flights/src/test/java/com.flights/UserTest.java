package test.java.com.flights;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains unit tests for the User class.
 */
public class UserTest {

    /**
     * Test case for the setUserTimePreference method of the User class.
     * It verifies that the time preference is set correctly.
     */
    @Test
    public void testSetUserTimePreference() {
        User user = new User("John", "Doe", "12345", 0);

        // Test setting time preference to the same value
        user.setUserTimePreference("24");
        assertEquals("Time preference is already set to 24", systemOut().getHistory());

        // Test setting time preference to a different value
        user.setUserTimePreference("12");
        assertEquals("12", user.getTimePreference());
    }
}
