package io.falcon.assignment.service;

import io.falcon.assignment.dataaccess.MessageRepository;
import io.falcon.assignment.domain.MessageEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageSaverServiceImplTest {

    @Mock
    private MessageRepository messageRepositoryMock;

    @InjectMocks
    private MessageSaverServiceImpl underTest;

    @Test
    void testSaveMethod() {
        MessageEntity entity = new MessageEntity(25L, "racecar", null);
        Mockito.when(messageRepositoryMock.save(Mockito.any())).thenReturn(entity);

        underTest.save(entity);

        Mockito.verify(messageRepositoryMock).save(Mockito.any());
    }

}