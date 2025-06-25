package com.minhdang.spingaidemo.service;

import com.minhdang.spingaidemo.dto.ChatRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public String chat(ChatRequest chatRequest) {
        String content = chatClient
                .prompt(chatRequest.message())
                .call()
                .content();;
        return content;
    }
}
