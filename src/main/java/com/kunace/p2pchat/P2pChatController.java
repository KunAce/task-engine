package com.kunace.p2pchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class P2pChatController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/channel1")
    @SendTo("/publicBroker/hello")
    public Message hello(Message message) throws Exception {
        return message;
    }
    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        String from = principal.getName();
        chat.setFrom(from);
        messagingTemplate.convertAndSendToUser(chat.getTo(),"/p2pBroker/chat",chat);
    }

}
