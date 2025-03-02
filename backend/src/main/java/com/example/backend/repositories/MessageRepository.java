package com.example.backend.repositories;

import com.example.backend.dtos.MessageRecordDto;
import com.example.backend.models.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageModel, UUID> {

    @Query("SELECT new com.example.backend.dtos.MessageRecordDto(m.message, m.timeStamp, m.isUser, m.chat.id, m.chat.user.id) FROM MessageModel m WHERE m.chat.id = :chatId")
    List<MessageRecordDto> findByChatId(@Param("chatId") UUID chatId);
}
