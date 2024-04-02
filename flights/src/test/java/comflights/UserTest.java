package comflights;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains unit tests for the User class.
 */
public class UserTest {

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
}
