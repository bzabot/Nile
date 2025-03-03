package com.example.backend.services;

import com.example.backend.dtos.ChatRecordDto;
import com.example.backend.models.UserModel;
import com.example.backend.repositories.ChatRepository;
import com.example.backend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetUserByIdService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetChatsByUserService.class);

    public GetUserByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getChatsByUserId(UUID userId){
        return userRepository.findUserById(userId);
    }
}
