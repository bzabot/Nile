package com.example.backend.repositories;

import com.example.backend.dtos.ChatDto;
import com.example.backend.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
    List<Chat> findByUserId(UUID userId);

    @Query("""
            SELECT new com.example.backend.dtos.ChatDto(c.title, c.id)
                   FROM Chat c
                   WHERE c.user.id = :userId
           """)
    List<ChatDto> findChatsByUserId(@Param("userId") UUID userId);

}
