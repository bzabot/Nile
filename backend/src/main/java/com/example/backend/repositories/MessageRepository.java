package com.example.backend.repositories;

import com.example.backend.dtos.MessageDto;
import com.example.backend.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query("SELECT new com.example.backend.dtos.MessageDto(m.message, m.timeStamp, m.isUser, m.chat.id, m.chat.user.id) FROM Message m WHERE m.chat.id = :chatId")
    List<MessageDto> findByChatId(@Param("chatId") UUID chatId);
}
