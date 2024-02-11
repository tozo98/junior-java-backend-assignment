package io.falcon.assignment.controller;

import io.falcon.assignment.converter.EnrichedMessageConverter;
import io.falcon.assignment.domain.EnrichedMessageEntity;
import io.falcon.assignment.domain.EnrichedMessageResponse;
import io.falcon.assignment.domain.MessageEntity;
import io.falcon.assignment.service.EnrichedMessageProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrichedMessageProviderRestControllerTest {

    @Mock
    private EnrichedMessageProvider enrichedMessageProviderMock;

    @Mock
    private EnrichedMessageConverter converterMock;

    @InjectMocks
    private EnrichedMessageProviderRestController underTest;


    @Test
    void testRetrieveAllWhenEmptyListReturned() {
        when(enrichedMessageProviderMock.findAll()).thenReturn(Collections.emptyList());
        List<EnrichedMessageResponse> result = underTest.retrieveAll();
        verify(enrichedMessageProviderMock).findAll();
        verifyZeroInteractions(converterMock);
    }

    @Test
    void testRetrieveAllWhenSingleMessageReturned() {
        EnrichedMessageEntity expectedMessage = new EnrichedMessageEntity();
        expectedMessage.setMessageEntity(new MessageEntity(42L, "racecar", ZonedDateTime.now()));
        expectedMessage.setLongestPalindromSize(7);
        List<EnrichedMessageEntity> expected = List.of(expectedMessage);
        EnrichedMessageResponse mockedResponse = new EnrichedMessageResponse();
        when(converterMock.convert(any())).thenReturn(mockedResponse);
        when(enrichedMessageProviderMock.findAll()).thenReturn(expected);

        List<EnrichedMessageResponse> result = underTest.retrieveAll();

        verify(enrichedMessageProviderMock).findAll();
        verify(converterMock).convert(any());
    }


}