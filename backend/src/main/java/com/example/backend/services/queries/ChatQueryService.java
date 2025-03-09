package com.example.backend.services.queries;

import com.example.backend.dtos.ChatDto;
import com.example.backend.repositories.ChatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatQueryService {
    private final ChatRepository chatRepository;
    private static final Logger logger = LoggerFactory.getLogger(ChatQueryService.class);

    public ChatQueryService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<ChatDto> getChatsByUserId(UUID userId){
        logger.info("User id: {}", userId);
        return chatRepository.findChatsByUserId(userId);
    }
}
