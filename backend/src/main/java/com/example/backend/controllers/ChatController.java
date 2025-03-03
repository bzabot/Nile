package com.example.backend.controllers;

import com.example.backend.dtos.ChatRecordDto;
import com.example.backend.dtos.MessageRecordDto;
import com.example.backend.models.ChatModel;
import com.example.backend.models.MessageModel;
import com.example.backend.services.GetChatsByUserService;
import com.example.backend.services.GetMessagesByChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final GetChatsByUserService getChatsByUserService;
    private final GetMessagesByChatService getMessagesByChatService;

    @Autowired
    public ChatController(GetChatsByUserService getChatsByUserService, GetMessagesByChatService getMessagesByChatService) {
        this.getChatsByUserService = getChatsByUserService;
        this.getMessagesByChatService = getMessagesByChatService;
    }

    @GetMapping("/user/{userId}")
    public List<ChatRecordDto> getChatsByUserService(@PathVariable UUID userId){
        return getChatsByUserService.getChatsByUserId(userId);
    }

    @GetMapping("/c/{chatId}")
    public List<MessageRecordDto> getMessagesByChatService(@PathVariable UUID chatId){
        return getMessagesByChatService.getMessagesByChatId(chatId);
    }
}
