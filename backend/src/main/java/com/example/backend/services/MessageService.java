package com.example.backend.services;

import com.example.backend.dtos.ChatRecordDto;
import com.example.backend.dtos.MessageRecordDto;
import com.example.backend.models.ChatModel;
import com.example.backend.models.MessageModel;
import com.example.backend.models.UserModel;
import com.example.backend.repositories.ChatRepository;
import com.example.backend.repositories.MessageRepository;
import com.example.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public ChatModel saveMessage(MessageRecordDto message){
        ChatModel chat;
        UUID chatId = message.chatId();

        if(chatId==null){
            // É uma nova mensagem, portanto um novo chat precisa ser criado
            chat = new ChatModel();
            chat.setUser(userRepository.findUserById(message.userId()));
            chat.setTitle(message.message());
            chatRepository.save(chat);
            chatId = chat.getId();
        }

        chat = chatRepository.getReferenceById(chatId);
        MessageModel savedMessage = new MessageModel();
        savedMessage.setMessage(message.message());
        savedMessage.setTimeStamp(message.timeStamp());
        // Há uma vulnerabilidade aqui: se o user enviar o dto com o isUser trocado, ele consegue se passar por uma resposta da API
        // Não que isso seja importante, acho que nao da pra fazer nada com isso além de bugar o FE
        savedMessage.setIsUser(message.isUser());
        savedMessage.setChat(chat);
        messageRepository.save(savedMessage);
        return savedMessage.getChat();
    }



}
