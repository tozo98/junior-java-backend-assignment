package io.falcon.assignment.converter;

import io.falcon.assignment.domain.EnrichedMessageEntity;
import io.falcon.assignment.domain.EnrichedMessageResponse;
import io.falcon.assignment.domain.MessageEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrichedMessageConverterTest {

    @Mock
    private TimestampConverter timestampConverterMock;

    @InjectMocks
    private EnrichedMessageConverter underTest;

    @Test
    void testConvertWhenParamIsAddedCorrectly() {
        when(timestampConverterMock.getString(any())).thenReturn("timestamp");
        MessageEntity entity = new MessageEntity(42L, "content", null);
        EnrichedMessageEntity enrichedMessageEntity = new EnrichedMessageEntity();
        enrichedMessageEntity.setMessageEntity(entity);

        EnrichedMessageResponse result = underTest.convert(enrichedMessageEntity);

        assertNotNull(result);
        verify(timestampConverterMock).getString(any());
    }

}