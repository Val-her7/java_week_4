package dev.val;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visit {
    private final String firstName;
    private final String lastName;
    private final String reason;
    private final LocalDateTime timestamp;

    public Visit(String firstName, String lastName, String reason, LocalDateTime timestamp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reason = reason;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " came to see " + reason + " at " +
                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}