package com.example.backend.dtos;

import java.util.UUID;

public record ChatDto(String title,
                      UUID chatId) {
}
