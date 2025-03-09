package com.example.backend.services;

import com.example.backend.dtos.ChatRecordDto;
import com.example.backend.repositories.ChatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetChatsByUserService {
    private final ChatRepository chatRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetChatsByUserService.class);


    public GetChatsByUserService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<ChatRecordDto> getChatsByUserId(UUID userId){
        logger.info("User id: {}", userId);
        return chatRepository.findChatsByUserId(userId);
    }
}
