package com.example.backend.repositories;

import com.example.backend.models.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageModel, UUID> {

    

}
