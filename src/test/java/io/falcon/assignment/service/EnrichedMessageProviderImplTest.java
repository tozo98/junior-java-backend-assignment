package io.falcon.assignment.service;

import io.falcon.assignment.dataaccess.MessageRepository;
import io.falcon.assignment.domain.EnrichedMessageEntity;
import io.falcon.assignment.domain.EnrichedMessageResponse;
import io.falcon.assignment.domain.MessageEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EnrichedMessageProviderImplTest {

    @Mock
    private MessageRepository messageRepositoryMock;

    @Mock
    private PalindromFinderService palindromFinderServiceMock;

    @InjectMocks
    private EnrichedMessageProviderImpl underTest;

    @Test
    void testFindAllWhenASingleEntityIsReturned() {
        EnrichedMessageResponse enrichedMessageResponse = new EnrichedMessageResponse();
        enrichedMessageResponse.setLongestPalindromSize(42);
        Mockito.when(messageRepositoryMock.findAll()).thenReturn(List.of(new MessageEntity(42L, "content", null)));
        Mockito.when(palindromFinderServiceMock.findLongestPalindromSize(Mockito.any())).thenReturn(42);

        List<EnrichedMessageEntity> result = underTest.findAll();

        assertNotNull(result);
        assertEquals(enrichedMessageResponse.getLongestPalindromSize(), result.get(0).getLongestPalindromSize());

        Mockito.verify(messageRepositoryMock).findAll();
        Mockito.verify(palindromFinderServiceMock).findLongestPalindromSize(Mockito.any());
    }

}