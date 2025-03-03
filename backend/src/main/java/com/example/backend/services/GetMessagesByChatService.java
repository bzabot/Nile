package com.example.backend.services;

import com.example.backend.dtos.ChatRecordDto;
import com.example.backend.dtos.MessageRecordDto;
import com.example.backend.models.ChatModel;
import com.example.backend.models.MessageModel;
import com.example.backend.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class GetMessagesByChatService {
    private final MessageRepository messageRepository;

    private static final Logger logger = LoggerFactory.getLogger(GetChatsByUserService.class);

    public GetMessagesByChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageRecordDto> getMessagesByChatId(UUID chatId){
        logger.info("Chat id: {}", chatId);

        return messageRepository.findByChatId(chatId);
    }
}
