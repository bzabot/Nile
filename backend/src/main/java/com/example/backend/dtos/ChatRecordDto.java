package com.example.backend.dtos;

import java.util.UUID;

public record ChatRecordDto(String title,
                            UUID userId,
                            UUID chatId) {
}
