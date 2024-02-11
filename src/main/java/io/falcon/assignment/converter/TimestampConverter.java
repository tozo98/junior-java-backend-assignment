package io.falcon.assignment.converter;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimestampConverter {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");

    public String getString(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(FORMATTER);
    }

    public ZonedDateTime getZonedDateTime(String input) {
        return ZonedDateTime.parse(input, FORMATTER);
    }
}
