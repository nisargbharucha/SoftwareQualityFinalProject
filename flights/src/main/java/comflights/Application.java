<<<<<<< HEAD
package comflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

=======
package main.java.com.flights;

import org.springframework.boot.SpringApplication;
>>>>>>> fd77b3a6ab3b2b36de9ae366754e9cfa310720fa
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public DateTimeFormatter convertTime(DateTimeFormatter timeToChange) {
<<<<<<< HEAD
        return timeToChange;
=======
>>>>>>> fd77b3a6ab3b2b36de9ae366754e9cfa310720fa
        // return the converted time format (12->24 or 24->12 depending on the input)
        // return DateTimeFormatter.ofPattern("HH:mm:ss");
    }

<<<<<<< HEAD
=======
    
>>>>>>> fd77b3a6ab3b2b36de9ae366754e9cfa310720fa
}