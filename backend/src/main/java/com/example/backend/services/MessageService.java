package com.example.backend.services;

import com.example.backend.dtos.MessageDto;
import com.example.backend.models.Chat;
import com.example.backend.models.Message;
import com.example.backend.repositories.ChatRepository;
import com.example.backend.repositories.MessageRepository;
import com.example.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageService(ChatRepository chatRepository, MessageRepository messageRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Chat saveMessage(MessageDto message){
        UUID chatId = message.chatId();

        Chat chat = (chatId == null) ? createNewChat(message) : chatRepository.getReferenceById(chatId);

        Message savedMessage = new Message();
        savedMessage.setMessage(message.message());
        savedMessage.setTimeStamp(message.timeStamp());
        // Há uma vulnerabilidade aqui: se o user enviar o dto com o isUser trocado, ele consegue se passar por uma resposta da API
        // Não que isso seja importante, acho que nao da pra fazer nada com isso além de bugar o FE
        savedMessage.setIsUser(message.isUser());
        savedMessage.setChat(chat);
        messageRepository.save(savedMessage);

        return chat;
    }

    private Chat createNewChat(MessageDto message) {
        Chat chat = new Chat();
        chat.setUser(userRepository.findUserById(message.userId()));
        chat.setTitle(message.message());
        chatRepository.save(chat);
        return chat;
    }



}
