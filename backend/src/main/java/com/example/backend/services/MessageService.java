package com.example.backend.services;

import com.example.backend.dtos.MessageRecordDto;
import com.example.backend.models.ChatModel;
import com.example.backend.models.MessageModel;
import com.example.backend.repositories.ChatRepository;
import com.example.backend.repositories.MessageRepository;
import com.example.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private ChatRepository chatRepository;
    private MessageRepository messageRepository;
    private UserRepository userRepository;

    public MessageService(ChatRepository chatRepository, MessageRepository messageRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveMessage(MessageRecordDto message){
        if(message.chatId()!=null){
            ChatModel chat = chatRepository.getReferenceById(message.chatId());
            MessageModel savedMessage = new MessageModel();
            savedMessage.setMessage(message.message());
            savedMessage.setTimeStamp(message.timeStamp());
            // Há uma vulnerabilidade aqui: se o user enviar o dto com o isUser trocado, ele consegue se passar por uma resposta da API
            savedMessage.setIsUser(message.isUser());
            savedMessage.setChat(chat);
            messageRepository.save(savedMessage);
        }
    }



}
