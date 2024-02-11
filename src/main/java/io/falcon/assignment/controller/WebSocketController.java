package io.falcon.assignment.controller;

import io.falcon.assignment.domain.MessageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/websocket/server")
    @SendTo("/topic/messages")
    public MessageRequest forwardMessage(MessageRequest message) {
        return message;
    }
}
