package io.falcon.assignment.controller;

import io.falcon.assignment.converter.MessageConverter;
import io.falcon.assignment.domain.MessageEntity;
import io.falcon.assignment.domain.MessageRequest;
import io.falcon.assignment.service.MessageSaverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.time.ZonedDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageConsumerRestControllerTest {

    @Mock
    private MessageSaverService messageSaverServiceMock;

    @Mock
    private MessageConverter converterMock;

    @Mock
    private SimpMessagingTemplate templateMock;

    @InjectMocks
    private MessageConsumerRestController underTest;

    @Test
    void testSaveMethodWhenRequestIsCorrect() {
        when(converterMock.convert(any())).thenReturn(new MessageEntity());
        MessageRequest request = new MessageRequest();
        request.setContent("message");
        request.setTimestamp(ZonedDateTime.now().toString());
        underTest.saveMessage(request);
        verify(converterMock).convert(any());
        verify(messageSaverServiceMock).save(any());
        verify(templateMock).convertAndSend(anyString(), (Object) any());
    }

}