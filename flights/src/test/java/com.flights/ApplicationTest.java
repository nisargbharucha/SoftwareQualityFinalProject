package test.java.com.flights;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    @Test
    @DisplayName("Test converting time from 12-hour format to 24-hour format")
    public void testConvertTime_12To24() {
        Application application = new Application();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        DateTimeFormatter resultFormatter = application.convertTime(inputFormatter);

        assertEquals(expectedFormatter, resultFormatter);
    }

    @Test
    @DisplayName("Test converting time from 24-hour format to 12-hour format")
    public void testConvertTime_24To12() {
        Application application = new Application();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        DateTimeFormatter resultFormatter = application.convertTime(inputFormatter);

        assertEquals(expectedFormatter, resultFormatter);
    }
}
