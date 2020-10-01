package com.kunace.groupchat;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GroupChatController {
    @MessageMapping("/channel1")
    @SendTo("/publicBroker/hello")
    public Message hello(Message message) throws Exception {
        return message;
    }
}
