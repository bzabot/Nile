package com.example.backend.repositories;

import com.example.backend.dtos.ChatRecordDto;
import com.example.backend.models.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<ChatModel, UUID> {
    List<ChatModel> findByUserId(UUID userId);

    @Query("SELECT new com.example.backend.dtos.ChatRecordDto(c.title, c.user.id, c.id) FROM ChatModel c WHERE c.user.id = :userId")
    List<ChatRecordDto> findChatsByUserId(@Param("userId") UUID userId);

}
