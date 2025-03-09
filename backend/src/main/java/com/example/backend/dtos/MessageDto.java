package com.example.backend.dtos;

import java.util.Date;
import java.util.UUID;

public record MessageDto(
                               String message,
                               Date timeStamp,
                               Boolean isUser,
                               UUID chatId,
                               UUID userId
                                ) {

}
