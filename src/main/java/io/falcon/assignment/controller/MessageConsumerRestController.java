package io.falcon.assignment.controller;

import io.falcon.assignment.converter.MessageConverter;
import io.falcon.assignment.domain.MessageRequest;
import io.falcon.assignment.service.MessageSaverService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class MessageConsumerRestController {

    private MessageSaverService messageSaverService;

    private MessageConverter converter;

    private SimpMessagingTemplate template;

    @PostMapping("api/v1/messages/save")
    public void saveMessage(@Valid @RequestBody MessageRequest request) {
        messageSaverService.save(converter.convert(request));
        this.template.convertAndSend("/topic/messages", request);
    }
}
