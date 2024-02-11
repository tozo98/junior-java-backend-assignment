package io.falcon.assignment.converter;

import io.falcon.assignment.domain.MessageEntity;
import io.falcon.assignment.domain.MessageRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageConverterTest {

    @Mock
    private TimestampConverter timestampConverterMock;

    @InjectMocks
    private MessageConverter underTest;

    @Test
    void testConvertMethodWhenParamsAreAddedCorrectly() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2023-09-18 15:00:00+0100", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ"));
        when(timestampConverterMock.getZonedDateTime(any())).thenReturn(zonedDateTime);
        MessageRequest request = new MessageRequest();
        request.setContent("content");
        request.setTimestamp("2023-09-18 15:00:00+0100");
        MessageEntity expected = new MessageEntity();
        expected.setContent("content");
        expected.setTimestamp(zonedDateTime);

        MessageEntity result = underTest.convert(request);

        assertNotNull(result);
        assertEquals(expected.getContent(), result.getContent());
        assertEquals(expected.getTimestamp(), result.getTimestamp());
        assertNull(result.getId());
    }

    @Test
    void testConvertMethodWhenTimestampIsNotCorrect() {
        when(timestampConverterMock.getZonedDateTime(any())).thenThrow(DateTimeException.class);
        MessageRequest request = new MessageRequest();
        request.setContent("content");
        request.setTimestamp("23-09-18 15:00:00+0100");
        assertThrows(DateTimeException.class, () -> underTest.convert(request));
    }

}