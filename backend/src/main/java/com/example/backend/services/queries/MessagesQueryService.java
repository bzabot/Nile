package com.example.backend.services.queries;

import com.example.backend.dtos.MessageDto;
import com.example.backend.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessagesQueryService {
    private final MessageRepository messageRepository;

    private static final Logger logger = LoggerFactory.getLogger(ChatQueryService.class);

    public MessagesQueryService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDto> getMessagesByChatId(UUID chatId){
        logger.info("Chat id: {}", chatId);

        return messageRepository.findByChatId(chatId);
    }
}
