package com.example.backend.services;

import org.springframework.ai.anthropic.AnthropicChatOptions;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class AIChatService {
    private final ChatModel chatModel;

    public AIChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }

    public String getResponseOptions(String prompt){
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        AnthropicChatOptions.builder()
                                .model("claude-3-5-sonnet-20241022")
                                .build()
                )
        );
        return response.getResult().getOutput().getText();
    }


}
