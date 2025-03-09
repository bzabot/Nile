package com.example.backend.controllers;

import com.example.backend.dtos.ChatDto;
import com.example.backend.dtos.MessageDto;
import com.example.backend.services.queries.ChatQueryService;
import com.example.backend.services.queries.MessagesQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatQueryService getChatsByUserService;
    private final MessagesQueryService getMessagesByChatService;

    @Autowired
    public ChatController(ChatQueryService getChatsByUserService, MessagesQueryService getMessagesByChatService) {
        this.getChatsByUserService = getChatsByUserService;
        this.getMessagesByChatService = getMessagesByChatService;
    }

    @GetMapping("/user/{userId}")
    public List<ChatDto> getChatsByUserService(@PathVariable UUID userId){
        return getChatsByUserService.getChatsByUserId(userId);
    }

    @GetMapping("/c/{chatId}")
    public List<MessageDto> getMessagesByChatService(@PathVariable UUID chatId){
        return getMessagesByChatService.getMessagesByChatId(chatId);
    }
}
