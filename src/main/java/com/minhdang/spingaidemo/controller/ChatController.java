package com.minhdang.spingaidemo.controller;

import com.minhdang.spingaidemo.dto.ChatRequest;
import com.minhdang.spingaidemo.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest chatRequest) {
        return chatService.chat(chatRequest);
    }
}
