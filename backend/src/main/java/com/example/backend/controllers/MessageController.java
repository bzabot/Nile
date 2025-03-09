package com.example.backend.controllers;

import com.example.backend.dtos.MessageDto;
import com.example.backend.models.Chat;
import com.example.backend.services.AIChatService;
import com.example.backend.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * REST controller for handling message-related requests.
 */
@RestController
public class MessageController {

    private final AIChatService AIChatService;
    private final MessageService messageService;
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    /**
     * Constructor for MessagesController.
     *
     * @param AIChatService the service for handling chat-related operations
     * @param messageService the service for handling message-related operations
     */
    @Autowired
    public MessageController(AIChatService AIChatService, MessageService messageService) {
        this.AIChatService = AIChatService;
        this.messageService = messageService;
    }

    /**
     * Endpoint to receive a message and get response options.
     *
     * @param message the message received from the client
     * @return the response message with options
     */
    @PostMapping("/question")
    public MessageDto getResponseOptions(@RequestBody MessageDto message) {

        // Save the message in the database
        // If this is the first message, a new chat is created
        Chat chat = messageService.saveMessage(message);

        // Get response options for the message
        String response = AIChatService.getResponseOptions(message.message());
        MessageDto ans = new MessageDto(response, new Date(), false, chat.getId(), message.userId());

        // Save the response in the database
        messageService.saveMessage(ans);

        return ans;
    }
}