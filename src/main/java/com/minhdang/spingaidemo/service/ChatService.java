package com.minhdang.spingaidemo.service;

import com.minhdang.spingaidemo.dto.ChatRequest;
import com.minhdang.spingaidemo.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ChatResponse chat(ChatRequest chatRequest) {
        ChatResponse content = chatClient
                .prompt(chatRequest.message())
                .call()
                .entity(ParameterizedTypeReference.forType(ChatResponse.class));
        return content;
    }
}
