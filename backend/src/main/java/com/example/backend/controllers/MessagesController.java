package com.example.backend.controllers;

import com.example.backend.dtos.MessageRecordDto;
import com.example.backend.models.ChatModel;
import com.example.backend.services.ChatService;
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
public class MessagesController {

    private final ChatService chatService;
    private final MessageService messageService;
    private static final Logger logger = LoggerFactory.getLogger(MessagesController.class);

    /**
     * Constructor for MessagesController.
     *
     * @param chatService the service for handling chat-related operations
     * @param messageService the service for handling message-related operations
     */
    @Autowired
    public MessagesController(ChatService chatService, MessageService messageService) {
        this.chatService = chatService;
        this.messageService = messageService;
    }

    /**
     * Endpoint to receive a message and get response options.
     *
     * @param message the message received from the client
     * @return the response message with options
     */
    @PostMapping("/question")
    public MessageRecordDto getResponseOptions(@RequestBody MessageRecordDto message) {
        logger.info("Received message: {}", message);

        // Save the message in the database
        // If this is the first message, a new chat is created
        ChatModel chat = messageService.saveMessage(message);

        // Get response options for the message
        String response = chatService.getResponseOptions(message.message());
        MessageRecordDto ans = new MessageRecordDto(response, new Date(), false, chat.getId(), message.userId());

        // Save the response in the database
        messageService.saveMessage(ans);

        return ans;
    }
}