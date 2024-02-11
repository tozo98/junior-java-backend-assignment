package io.falcon.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketDemoPageController {

    @GetMapping("/websocketdemo")
    public String home() {
        return "websocketdemo.html";
    }

}