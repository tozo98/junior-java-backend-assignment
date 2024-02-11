package io.falcon.assignment.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimestampConverterTest {

    private TimestampConverter underTest;

    @BeforeEach
    void setup() {
        underTest = new TimestampConverter();
    }

    @Test
    void testGetStringWhenInputIsPresent() {
        String expected = "2023-09-19 17:00:00+0100";
        ZonedDateTime input = ZonedDateTime.of(2023, 9, 19, 17, 00, 00, 00, ZoneId.of("UTC+1"));
        String result = underTest.getString(input);
        assertNotNull(result);
        assertEquals(expected, result);
    }


    @Test
    void getZonedDateTimeWhenInputIsWellFormed() {
        String input = "2023-09-19 17:00:00+0100";
        ZonedDateTime expected = ZonedDateTime.of(2023, 9, 19, 17, 00, 00, 00, ZoneId.of("UTC+1"));
        ZonedDateTime result = underTest.getZonedDateTime(input);
        assertNotNull(result);
        assertEquals(expected.toLocalDateTime(), result.toLocalDateTime());
    }

    @Test
    void getZonedDateTimeWhenInputHasIncorrectFormat() {
        String input = "23-09-19 17:00:00+0100";
        assertThrows(DateTimeException.class, () -> underTest.getZonedDateTime(input));
    }
}