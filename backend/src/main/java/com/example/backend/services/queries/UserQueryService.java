package com.example.backend.services.queries;

import com.example.backend.models.User;
import com.example.backend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserQueryService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ChatQueryService.class);

    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getChatsByUserId(UUID userId){
        return userRepository.findUserById(userId);
    }
}
