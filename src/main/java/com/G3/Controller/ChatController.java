package com.G3.Controller;

import com.G3.Model.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class ChatController {
    Sample sample = new Sample();
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/hello")
    public void greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        log.info("sessionId>>>>>>>>>"+sample.getSessionId());
        messagingTemplate.convertAndSendToUser(sample.getSessionId(),"/topic/greetings",message);
//        return message;
    }
}
